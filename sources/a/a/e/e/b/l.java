package a.a.e.e.b;

import a.a.l;
/* compiled from: ObservableObserveOn.java */
/* loaded from: classes.dex */
public final class l<T> extends a.a.e.e.b.a<T, T> {
    final a.a.l b;
    final boolean c;
    final int d;

    public l(a.a.j<T> jVar, a.a.l lVar, boolean z, int i) {
        super(jVar);
        this.b = lVar;
        this.c = z;
        this.d = i;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        a.a.l lVar = this.b;
        if (lVar instanceof a.a.e.g.m) {
            this.f159a.a(kVar);
            return;
        }
        this.f159a.a(new a(kVar, lVar.a(), this.c, this.d));
    }

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends a.a.e.d.b<T> implements a.a.k<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f172a;
        final l.b b;
        final boolean c;
        final int d;
        a.a.e.c.e<T> e;
        a.a.b.b f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(a.a.k<? super T> kVar, l.b bVar, boolean z, int i) {
            this.f172a = kVar;
            this.b = bVar;
            this.c = z;
            this.d = i;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof a.a.e.c.a) {
                    a.a.e.c.a aVar = (a.a.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.h = true;
                        this.f172a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.f172a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new a.a.e.f.b(this.d);
                this.f172a.onSubscribe(this);
            }
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(t);
            }
            a();
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.h) {
                a.a.h.a.a(th);
                return;
            }
            this.g = th;
            this.h = true;
            a();
        }

        @Override // a.a.k
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            a();
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.b.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.i;
        }

        void a() {
            if (getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        void b() {
            a.a.e.c.e<T> eVar = this.e;
            a.a.k<? super T> kVar = this.f172a;
            int i = 1;
            while (!a(this.h, eVar.isEmpty(), kVar)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        Object obj = (T) eVar.poll();
                        boolean z2 = obj == null;
                        if (a(z, z2, kVar)) {
                            return;
                        }
                        if (!z2) {
                            kVar.onNext(obj);
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        a.a.c.b.b(th);
                        this.i = true;
                        this.f.dispose();
                        eVar.clear();
                        kVar.onError(th);
                        this.b.dispose();
                        return;
                    }
                }
            }
        }

        void c() {
            int i = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (!this.c && z && th != null) {
                    this.i = true;
                    this.f172a.onError(this.g);
                    this.b.dispose();
                    return;
                }
                this.f172a.onNext(null);
                if (z) {
                    this.i = true;
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        this.f172a.onError(th2);
                    } else {
                        this.f172a.onComplete();
                    }
                    this.b.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                c();
            } else {
                b();
            }
        }

        boolean a(boolean z, boolean z2, a.a.k<? super T> kVar) {
            if (this.i) {
                this.e.clear();
                return true;
            } else if (z) {
                Throwable th = this.g;
                if (this.c) {
                    if (z2) {
                        this.i = true;
                        if (th != null) {
                            kVar.onError(th);
                        } else {
                            kVar.onComplete();
                        }
                        this.b.dispose();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.i = true;
                    this.e.clear();
                    kVar.onError(th);
                    this.b.dispose();
                    return true;
                } else if (z2) {
                    this.i = true;
                    kVar.onComplete();
                    this.b.dispose();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // a.a.e.c.b
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.k = true;
                return 2;
            }
            return 0;
        }

        @Override // a.a.e.c.e
        public T poll() throws Exception {
            return this.e.poll();
        }

        @Override // a.a.e.c.e
        public void clear() {
            this.e.clear();
        }

        @Override // a.a.e.c.e
        public boolean isEmpty() {
            return this.e.isEmpty();
        }
    }
}

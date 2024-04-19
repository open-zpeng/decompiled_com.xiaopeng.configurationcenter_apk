package a.a.e.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableConcatMap.java */
/* loaded from: classes.dex */
public final class b<T, U> extends a.a.e.e.b.a<T, U> {
    final a.a.d.f<? super T, ? extends a.a.j<? extends U>> b;
    final int c;
    final a.a.e.h.c d;

    public b(a.a.j<T> jVar, a.a.d.f<? super T, ? extends a.a.j<? extends U>> fVar, int i, a.a.e.h.c cVar) {
        super(jVar);
        this.b = fVar;
        this.d = cVar;
        this.c = Math.max(8, i);
    }

    @Override // a.a.g
    public void b(a.a.k<? super U> kVar) {
        if (p.a(this.f159a, kVar, this.b)) {
            return;
        }
        if (this.d == a.a.e.h.c.IMMEDIATE) {
            this.f159a.a(new C0005b(new a.a.g.a(kVar), this.b, this.c));
        } else {
            this.f159a.a(new a(kVar, this.b, this.c, this.d == a.a.e.h.c.END));
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: a.a.e.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0005b<T, U> extends AtomicInteger implements a.a.b.b, a.a.k<T> {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super U> f162a;
        final a.a.d.f<? super T, ? extends a.a.j<? extends U>> b;
        final a<U> c;
        final int d;
        a.a.e.c.e<T> e;
        a.a.b.b f;
        volatile boolean g;
        volatile boolean h;
        volatile boolean i;
        int j;

        C0005b(a.a.k<? super U> kVar, a.a.d.f<? super T, ? extends a.a.j<? extends U>> fVar, int i) {
            this.f162a = kVar;
            this.b = fVar;
            this.d = i;
            this.c = new a<>(kVar, this);
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof a.a.e.c.a) {
                    a.a.e.c.a aVar = (a.a.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.i = true;
                        this.f162a.onSubscribe(this);
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = aVar;
                        this.f162a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new a.a.e.f.b(this.d);
                this.f162a.onSubscribe(this);
            }
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.j == 0) {
                this.e.offer(t);
            }
            b();
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.i) {
                a.a.h.a.a(th);
                return;
            }
            this.i = true;
            dispose();
            this.f162a.onError(th);
        }

        @Override // a.a.k
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            b();
        }

        void a() {
            this.g = false;
            b();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.h;
        }

        @Override // a.a.b.b
        public void dispose() {
            this.h = true;
            this.c.a();
            this.f.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.h) {
                if (!this.g) {
                    boolean z = this.i;
                    try {
                        T poll = this.e.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.h = true;
                            this.f162a.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                a.a.j jVar = (a.a.j) a.a.e.b.b.a(this.b.apply(poll), "The mapper returned a null ObservableSource");
                                this.g = true;
                                jVar.a(this.c);
                            } catch (Throwable th) {
                                a.a.c.b.b(th);
                                dispose();
                                this.e.clear();
                                this.f162a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        a.a.c.b.b(th2);
                        dispose();
                        this.e.clear();
                        this.f162a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.e.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: a.a.e.e.b.b$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> extends AtomicReference<a.a.b.b> implements a.a.k<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: a  reason: collision with root package name */
            final a.a.k<? super U> f163a;
            final C0005b<?, ?> b;

            a(a.a.k<? super U> kVar, C0005b<?, ?> c0005b) {
                this.f163a = kVar;
                this.b = c0005b;
            }

            @Override // a.a.k
            public void onSubscribe(a.a.b.b bVar) {
                a.a.e.a.c.replace(this, bVar);
            }

            @Override // a.a.k
            public void onNext(U u) {
                this.f163a.onNext(u);
            }

            @Override // a.a.k
            public void onError(Throwable th) {
                this.b.dispose();
                this.f163a.onError(th);
            }

            @Override // a.a.k
            public void onComplete() {
                this.b.a();
            }

            void a() {
                a.a.e.a.c.dispose(this);
            }
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes.dex */
    static final class a<T, R> extends AtomicInteger implements a.a.b.b, a.a.k<T> {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super R> f160a;
        final a.a.d.f<? super T, ? extends a.a.j<? extends R>> b;
        final int c;
        final a.a.e.h.b d = new a.a.e.h.b();
        final C0004a<R> e;
        final boolean f;
        a.a.e.c.e<T> g;
        a.a.b.b h;
        volatile boolean i;
        volatile boolean j;
        volatile boolean k;
        int l;

        a(a.a.k<? super R> kVar, a.a.d.f<? super T, ? extends a.a.j<? extends R>> fVar, int i, boolean z) {
            this.f160a = kVar;
            this.b = fVar;
            this.c = i;
            this.f = z;
            this.e = new C0004a<>(kVar, this);
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.h, bVar)) {
                this.h = bVar;
                if (bVar instanceof a.a.e.c.a) {
                    a.a.e.c.a aVar = (a.a.e.c.a) bVar;
                    int requestFusion = aVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = aVar;
                        this.j = true;
                        this.f160a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = aVar;
                        this.f160a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new a.a.e.f.b(this.c);
                this.f160a.onSubscribe(this);
            }
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.l == 0) {
                this.g.offer(t);
            }
            a();
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.d.a(th)) {
                this.j = true;
                a();
                return;
            }
            a.a.h.a.a(th);
        }

        @Override // a.a.k
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.k;
        }

        @Override // a.a.b.b
        public void dispose() {
            this.k = true;
            this.h.dispose();
            this.e.a();
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            a.a.k<? super R> kVar = this.f160a;
            a.a.e.c.e<T> eVar = this.g;
            a.a.e.h.b bVar = this.d;
            while (true) {
                if (!this.i) {
                    if (this.k) {
                        eVar.clear();
                        return;
                    } else if (!this.f && bVar.get() != null) {
                        eVar.clear();
                        this.k = true;
                        kVar.onError(bVar.a());
                        return;
                    } else {
                        boolean z = this.j;
                        try {
                            T poll = eVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.k = true;
                                Throwable a2 = bVar.a();
                                if (a2 != null) {
                                    kVar.onError(a2);
                                    return;
                                } else {
                                    kVar.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    a.a.j jVar = (a.a.j) a.a.e.b.b.a(this.b.apply(poll), "The mapper returned a null ObservableSource");
                                    if (jVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) jVar).call();
                                            if (obj != 0 && !this.k) {
                                                kVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            a.a.c.b.b(th);
                                            bVar.a(th);
                                        }
                                    } else {
                                        this.i = true;
                                        jVar.a(this.e);
                                    }
                                } catch (Throwable th2) {
                                    a.a.c.b.b(th2);
                                    this.k = true;
                                    this.h.dispose();
                                    eVar.clear();
                                    bVar.a(th2);
                                    kVar.onError(bVar.a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            a.a.c.b.b(th3);
                            this.k = true;
                            this.h.dispose();
                            bVar.a(th3);
                            kVar.onError(bVar.a());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMap.java */
        /* renamed from: a.a.e.e.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0004a<R> extends AtomicReference<a.a.b.b> implements a.a.k<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: a  reason: collision with root package name */
            final a.a.k<? super R> f161a;
            final a<?, R> b;

            C0004a(a.a.k<? super R> kVar, a<?, R> aVar) {
                this.f161a = kVar;
                this.b = aVar;
            }

            @Override // a.a.k
            public void onSubscribe(a.a.b.b bVar) {
                a.a.e.a.c.replace(this, bVar);
            }

            @Override // a.a.k
            public void onNext(R r) {
                this.f161a.onNext(r);
            }

            @Override // a.a.k
            public void onError(Throwable th) {
                a<?, R> aVar = this.b;
                if (aVar.d.a(th)) {
                    if (!aVar.f) {
                        aVar.h.dispose();
                    }
                    aVar.i = false;
                    aVar.a();
                    return;
                }
                a.a.h.a.a(th);
            }

            @Override // a.a.k
            public void onComplete() {
                a<?, R> aVar = this.b;
                aVar.i = false;
                aVar.a();
            }

            void a() {
                a.a.e.a.c.dispose(this);
            }
        }
    }
}

package a.a.e.e.b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableRefCount.java */
/* loaded from: classes.dex */
public final class n<T> extends a.a.g<T> {

    /* renamed from: a  reason: collision with root package name */
    final a.a.f.a<T> f177a;
    final int b;
    final long c;
    final TimeUnit d;
    final a.a.l e;
    a f;

    public n(a.a.f.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    public n(a.a.f.a<T> aVar, int i, long j, TimeUnit timeUnit, a.a.l lVar) {
        this.f177a = aVar;
        this.b = i;
        this.c = j;
        this.d = timeUnit;
        this.e = lVar;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        a aVar;
        boolean z;
        synchronized (this) {
            aVar = this.f;
            if (aVar == null) {
                aVar = new a(this);
                this.f = aVar;
            }
            long j = aVar.c;
            if (j == 0 && aVar.b != null) {
                aVar.b.dispose();
            }
            long j2 = j + 1;
            aVar.c = j2;
            z = true;
            if (aVar.d || j2 != this.b) {
                z = false;
            } else {
                aVar.d = true;
            }
        }
        this.f177a.a((a.a.k) new b(kVar, this, aVar));
        if (z) {
            this.f177a.c(aVar);
        }
    }

    void a(a aVar) {
        synchronized (this) {
            a aVar2 = this.f;
            if (aVar2 != null && aVar2 == aVar) {
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0 && aVar.d) {
                    if (this.c == 0) {
                        c(aVar);
                        return;
                    }
                    a.a.e.a.g gVar = new a.a.e.a.g();
                    aVar.b = gVar;
                    gVar.a(this.e.a(aVar, this.c, this.d));
                }
            }
        }
    }

    void b(a aVar) {
        synchronized (this) {
            a aVar2 = this.f;
            if (aVar2 != null && aVar2 == aVar) {
                this.f = null;
                if (aVar.b != null) {
                    aVar.b.dispose();
                }
            }
            long j = aVar.c - 1;
            aVar.c = j;
            if (j == 0) {
                a.a.f.a<T> aVar3 = this.f177a;
                if (aVar3 instanceof a.a.b.b) {
                    ((a.a.b.b) aVar3).dispose();
                } else if (aVar3 instanceof a.a.e.a.f) {
                    ((a.a.e.a.f) aVar3).a(aVar.get());
                }
            }
        }
    }

    void c(a aVar) {
        synchronized (this) {
            if (aVar.c == 0 && aVar == this.f) {
                this.f = null;
                a.a.b.b bVar = aVar.get();
                a.a.e.a.c.dispose(aVar);
                a.a.f.a<T> aVar2 = this.f177a;
                if (aVar2 instanceof a.a.b.b) {
                    ((a.a.b.b) aVar2).dispose();
                } else if (aVar2 instanceof a.a.e.a.f) {
                    if (bVar == null) {
                        aVar.e = true;
                    } else {
                        ((a.a.e.a.f) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<a.a.b.b> implements a.a.d.e<a.a.b.b>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;

        /* renamed from: a  reason: collision with root package name */
        final n<?> f178a;
        a.a.b.b b;
        long c;
        boolean d;
        boolean e;

        a(n<?> nVar) {
            this.f178a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f178a.c(this);
        }

        @Override // a.a.d.e
        /* renamed from: a */
        public void accept(a.a.b.b bVar) throws Exception {
            a.a.e.a.c.replace(this, bVar);
            synchronized (this.f178a) {
                if (this.e) {
                    ((a.a.e.a.f) this.f178a.f177a).a(bVar);
                }
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicBoolean implements a.a.b.b, a.a.k<T> {
        private static final long serialVersionUID = -7419642935409022375L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f179a;
        final n<T> b;
        final a c;
        a.a.b.b d;

        b(a.a.k<? super T> kVar, n<T> nVar, a aVar) {
            this.f179a = kVar;
            this.b = nVar;
            this.c = aVar;
        }

        @Override // a.a.k
        public void onNext(T t) {
            this.f179a.onNext(t);
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.b.b(this.c);
                this.f179a.onError(th);
                return;
            }
            a.a.h.a.a(th);
        }

        @Override // a.a.k
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.b(this.c);
                this.f179a.onComplete();
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            this.d.dispose();
            if (compareAndSet(false, true)) {
                this.b.a(this.c);
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.d, bVar)) {
                this.d = bVar;
                this.f179a.onSubscribe(this);
            }
        }
    }
}

package a.a.e.e.b;
/* compiled from: ObservableTake.java */
/* loaded from: classes.dex */
public final class r<T> extends a.a.e.e.b.a<T, T> {
    final long b;

    public r(a.a.j<T> jVar, long j) {
        super(jVar);
        this.b = j;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        this.f159a.a(new a(kVar, this.b));
    }

    /* compiled from: ObservableTake.java */
    /* loaded from: classes.dex */
    static final class a<T> implements a.a.b.b, a.a.k<T> {

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f184a;
        boolean b;
        a.a.b.b c;
        long d;

        a(a.a.k<? super T> kVar, long j) {
            this.f184a = kVar;
            this.d = j;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.c, bVar)) {
                this.c = bVar;
                if (this.d == 0) {
                    this.b = true;
                    bVar.dispose();
                    a.a.e.a.d.complete(this.f184a);
                    return;
                }
                this.f184a.onSubscribe(this);
            }
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            long j = this.d;
            long j2 = j - 1;
            this.d = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f184a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.b) {
                a.a.h.a.a(th);
                return;
            }
            this.b = true;
            this.c.dispose();
            this.f184a.onError(th);
        }

        @Override // a.a.k
        public void onComplete() {
            if (this.b) {
                return;
            }
            this.b = true;
            this.c.dispose();
            this.f184a.onComplete();
        }

        @Override // a.a.b.b
        public void dispose() {
            this.c.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.c.isDisposed();
        }
    }
}

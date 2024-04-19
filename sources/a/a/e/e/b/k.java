package a.a.e.e.b;
/* compiled from: ObservableMap.java */
/* loaded from: classes.dex */
public final class k<T, U> extends a.a.e.e.b.a<T, U> {
    final a.a.d.f<? super T, ? extends U> b;

    public k(a.a.j<T> jVar, a.a.d.f<? super T, ? extends U> fVar) {
        super(jVar);
        this.b = fVar;
    }

    @Override // a.a.g
    public void b(a.a.k<? super U> kVar) {
        this.f159a.a(new a(kVar, this.b));
    }

    /* compiled from: ObservableMap.java */
    /* loaded from: classes.dex */
    static final class a<T, U> extends a.a.e.d.a<T, U> {
        final a.a.d.f<? super T, ? extends U> f;

        a(a.a.k<? super U> kVar, a.a.d.f<? super T, ? extends U> fVar) {
            super(kVar);
            this.f = fVar;
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.f150a.onNext(null);
                return;
            }
            try {
                this.f150a.onNext(a.a.e.b.b.a(this.f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // a.a.e.c.b
        public int requestFusion(int i) {
            return a(i);
        }

        @Override // a.a.e.c.e
        public U poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                return (U) a.a.e.b.b.a(this.f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}

package a.a.e.e.b;
/* compiled from: ObservableFilter.java */
/* loaded from: classes.dex */
public final class g<T> extends a.a.e.e.b.a<T, T> {
    final a.a.d.h<? super T> b;

    public g(a.a.j<T> jVar, a.a.d.h<? super T> hVar) {
        super(jVar);
        this.b = hVar;
    }

    @Override // a.a.g
    public void b(a.a.k<? super T> kVar) {
        this.f159a.a(new a(kVar, this.b));
    }

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes.dex */
    static final class a<T> extends a.a.e.d.a<T, T> {
        final a.a.d.h<? super T> f;

        a(a.a.k<? super T> kVar, a.a.d.h<? super T> hVar) {
            super(kVar);
            this.f = hVar;
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.e == 0) {
                try {
                    if (this.f.test(t)) {
                        this.f150a.onNext(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            this.f150a.onNext(null);
        }

        @Override // a.a.e.c.b
        public int requestFusion(int i) {
            return a(i);
        }

        @Override // a.a.e.c.e
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f.test(poll));
            return poll;
        }
    }
}

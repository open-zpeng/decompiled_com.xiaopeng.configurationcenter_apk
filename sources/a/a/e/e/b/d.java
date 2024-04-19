package a.a.e.e.b;
/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes.dex */
public final class d<T> extends a.a.e.e.b.a<T, T> {
    final a.a.d.e<? super T> b;
    final a.a.d.e<? super Throwable> c;
    final a.a.d.a d;
    final a.a.d.a e;

    public d(a.a.j<T> jVar, a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar, a.a.d.a aVar2) {
        super(jVar);
        this.b = eVar;
        this.c = eVar2;
        this.d = aVar;
        this.e = aVar2;
    }

    @Override // a.a.g
    public void b(a.a.k<? super T> kVar) {
        this.f159a.a(new a(kVar, this.b, this.c, this.d, this.e));
    }

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes.dex */
    static final class a<T> implements a.a.b.b, a.a.k<T> {

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f166a;
        final a.a.d.e<? super T> b;
        final a.a.d.e<? super Throwable> c;
        final a.a.d.a d;
        final a.a.d.a e;
        a.a.b.b f;
        boolean g;

        a(a.a.k<? super T> kVar, a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar, a.a.d.a aVar2) {
            this.f166a = kVar;
            this.b = eVar;
            this.c = eVar2;
            this.d = aVar;
            this.e = aVar2;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            if (a.a.e.a.c.validate(this.f, bVar)) {
                this.f = bVar;
                this.f166a.onSubscribe(this);
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            this.f.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // a.a.k
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                this.b.accept(t);
                this.f166a.onNext(t);
            } catch (Throwable th) {
                a.a.c.b.b(th);
                this.f.dispose();
                onError(th);
            }
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.g) {
                a.a.h.a.a(th);
                return;
            }
            this.g = true;
            try {
                this.c.accept(th);
            } catch (Throwable th2) {
                a.a.c.b.b(th2);
                th = new a.a.c.a(th, th2);
            }
            this.f166a.onError(th);
            try {
                this.e.run();
            } catch (Throwable th3) {
                a.a.c.b.b(th3);
                a.a.h.a.a(th3);
            }
        }

        @Override // a.a.k
        public void onComplete() {
            if (this.g) {
                return;
            }
            try {
                this.d.run();
                this.g = true;
                this.f166a.onComplete();
                try {
                    this.e.run();
                } catch (Throwable th) {
                    a.a.c.b.b(th);
                    a.a.h.a.a(th);
                }
            } catch (Throwable th2) {
                a.a.c.b.b(th2);
                onError(th2);
            }
        }
    }
}

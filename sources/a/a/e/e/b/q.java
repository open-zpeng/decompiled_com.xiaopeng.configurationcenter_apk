package a.a.e.e.b;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes.dex */
public final class q<T> extends a.a.e.e.b.a<T, T> {
    final a.a.l b;

    public q(a.a.j<T> jVar, a.a.l lVar) {
        super(jVar);
        this.b = lVar;
    }

    @Override // a.a.g
    public void b(a.a.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.onSubscribe(aVar);
        aVar.a(this.b.a(new b(aVar)));
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, a.a.k<T> {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f182a;
        final AtomicReference<a.a.b.b> b = new AtomicReference<>();

        a(a.a.k<? super T> kVar) {
            this.f182a = kVar;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            a.a.e.a.c.setOnce(this.b, bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            this.f182a.onNext(t);
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            this.f182a.onError(th);
        }

        @Override // a.a.k
        public void onComplete() {
            this.f182a.onComplete();
        }

        @Override // a.a.b.b
        public void dispose() {
            a.a.e.a.c.dispose(this.b);
            a.a.e.a.c.dispose(this);
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return a.a.e.a.c.isDisposed(get());
        }

        void a(a.a.b.b bVar) {
            a.a.e.a.c.setOnce(this, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    final class b implements Runnable {
        private final a<T> b;

        b(a<T> aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.f159a.a(this.b);
        }
    }
}

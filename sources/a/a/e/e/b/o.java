package a.a.e.e.b;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableRetryPredicate.java */
/* loaded from: classes.dex */
public final class o<T> extends a.a.e.e.b.a<T, T> {
    final a.a.d.h<? super Throwable> b;
    final long c;

    public o(a.a.g<T> gVar, long j, a.a.d.h<? super Throwable> hVar) {
        super(gVar);
        this.b = hVar;
        this.c = j;
    }

    @Override // a.a.g
    public void b(a.a.k<? super T> kVar) {
        a.a.e.a.g gVar = new a.a.e.a.g();
        kVar.onSubscribe(gVar);
        new a(kVar, this.c, this.b, gVar, this.f159a).a();
    }

    /* compiled from: ObservableRetryPredicate.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicInteger implements a.a.k<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f180a;
        final a.a.e.a.g b;
        final a.a.j<? extends T> c;
        final a.a.d.h<? super Throwable> d;
        long e;

        a(a.a.k<? super T> kVar, long j, a.a.d.h<? super Throwable> hVar, a.a.e.a.g gVar, a.a.j<? extends T> jVar) {
            this.f180a = kVar;
            this.b = gVar;
            this.c = jVar;
            this.d = hVar;
            this.e = j;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            this.b.a(bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            this.f180a.onNext(t);
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            long j = this.e;
            if (j != Long.MAX_VALUE) {
                this.e = j - 1;
            }
            if (j == 0) {
                this.f180a.onError(th);
                return;
            }
            try {
                if (!this.d.test(th)) {
                    this.f180a.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                a.a.c.b.b(th2);
                this.f180a.onError(new a.a.c.a(th, th2));
            }
        }

        @Override // a.a.k
        public void onComplete() {
            this.f180a.onComplete();
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.b.isDisposed()) {
                    this.c.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}

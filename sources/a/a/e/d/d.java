package a.a.e.d;

import a.a.k;
/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes.dex */
public final class d<T> implements a.a.b.b, k<T> {

    /* renamed from: a  reason: collision with root package name */
    final k<? super T> f151a;
    final a.a.d.e<? super a.a.b.b> b;
    final a.a.d.a c;
    a.a.b.b d;

    public d(k<? super T> kVar, a.a.d.e<? super a.a.b.b> eVar, a.a.d.a aVar) {
        this.f151a = kVar;
        this.b = eVar;
        this.c = aVar;
    }

    @Override // a.a.k
    public void onSubscribe(a.a.b.b bVar) {
        try {
            this.b.accept(bVar);
            if (a.a.e.a.c.validate(this.d, bVar)) {
                this.d = bVar;
                this.f151a.onSubscribe(this);
            }
        } catch (Throwable th) {
            a.a.c.b.b(th);
            bVar.dispose();
            this.d = a.a.e.a.c.DISPOSED;
            a.a.e.a.d.error(th, this.f151a);
        }
    }

    @Override // a.a.k
    public void onNext(T t) {
        this.f151a.onNext(t);
    }

    @Override // a.a.k
    public void onError(Throwable th) {
        if (this.d != a.a.e.a.c.DISPOSED) {
            this.d = a.a.e.a.c.DISPOSED;
            this.f151a.onError(th);
            return;
        }
        a.a.h.a.a(th);
    }

    @Override // a.a.k
    public void onComplete() {
        if (this.d != a.a.e.a.c.DISPOSED) {
            this.d = a.a.e.a.c.DISPOSED;
            this.f151a.onComplete();
        }
    }

    @Override // a.a.b.b
    public void dispose() {
        a.a.b.b bVar = this.d;
        if (bVar != a.a.e.a.c.DISPOSED) {
            this.d = a.a.e.a.c.DISPOSED;
            try {
                this.c.run();
            } catch (Throwable th) {
                a.a.c.b.b(th);
                a.a.h.a.a(th);
            }
            bVar.dispose();
        }
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.d.isDisposed();
    }
}

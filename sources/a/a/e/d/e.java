package a.a.e.d;

import a.a.k;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: LambdaObserver.java */
/* loaded from: classes.dex */
public final class e<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, k<T> {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a  reason: collision with root package name */
    final a.a.d.e<? super T> f152a;
    final a.a.d.e<? super Throwable> b;
    final a.a.d.a c;
    final a.a.d.e<? super a.a.b.b> d;

    public e(a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar, a.a.d.e<? super a.a.b.b> eVar3) {
        this.f152a = eVar;
        this.b = eVar2;
        this.c = aVar;
        this.d = eVar3;
    }

    @Override // a.a.k
    public void onSubscribe(a.a.b.b bVar) {
        if (a.a.e.a.c.setOnce(this, bVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                a.a.c.b.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }

    @Override // a.a.k
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.f152a.accept(t);
        } catch (Throwable th) {
            a.a.c.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // a.a.k
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(a.a.e.a.c.DISPOSED);
            try {
                this.b.accept(th);
                return;
            } catch (Throwable th2) {
                a.a.c.b.b(th2);
                a.a.h.a.a(new a.a.c.a(th, th2));
                return;
            }
        }
        a.a.h.a.a(th);
    }

    @Override // a.a.k
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(a.a.e.a.c.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            a.a.c.b.b(th);
            a.a.h.a.a(th);
        }
    }

    @Override // a.a.b.b
    public void dispose() {
        a.a.e.a.c.dispose(this);
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return get() == a.a.e.a.c.DISPOSED;
    }
}

package a.a;

import java.util.concurrent.Callable;
/* compiled from: Maybe.java */
/* loaded from: classes.dex */
public abstract class d<T> implements f<T> {
    protected abstract void b(e<? super T> eVar);

    public static <T> d<T> a(Callable<? extends T> callable) {
        a.a.e.b.b.a(callable, "callable is null");
        return a.a.h.a.a((d) new a.a.e.e.a.c(callable));
    }

    public final d<T> a(l lVar) {
        a.a.e.b.b.a(lVar, "scheduler is null");
        return a.a.h.a.a(new a.a.e.e.a.d(this, lVar));
    }

    public final a.a.b.b a(a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar) {
        a.a.e.b.b.a(eVar, "onSuccess is null");
        a.a.e.b.b.a(eVar2, "onError is null");
        a.a.e.b.b.a(aVar, "onComplete is null");
        return (a.a.b.b) c(new a.a.e.e.a.b(eVar, eVar2, aVar));
    }

    @Override // a.a.f
    public final void a(e<? super T> eVar) {
        a.a.e.b.b.a(eVar, "observer is null");
        e<? super T> a2 = a.a.h.a.a(this, eVar);
        a.a.e.b.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            a.a.c.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final d<T> b(l lVar) {
        a.a.e.b.b.a(lVar, "scheduler is null");
        return a.a.h.a.a(new a.a.e.e.a.e(this, lVar));
    }

    public final <E extends e<? super T>> E c(E e) {
        a(e);
        return e;
    }
}

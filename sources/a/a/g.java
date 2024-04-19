package a.a;

import a.a.e.e.b.o;
import a.a.e.e.b.q;
import a.a.e.e.b.r;
import a.a.e.e.b.s;
import java.util.concurrent.TimeUnit;
/* compiled from: Observable.java */
/* loaded from: classes.dex */
public abstract class g<T> implements j<T> {
    protected abstract void b(k<? super T> kVar);

    public static int a() {
        return c.a();
    }

    public static <T> g<T> a(j<? extends T>... jVarArr) {
        if (jVarArr.length == 0) {
            return b();
        }
        if (jVarArr.length == 1) {
            return a((j) jVarArr[0]);
        }
        return a.a.h.a.a(new a.a.e.e.b.b(a((Object[]) jVarArr), a.a.e.b.a.a(), a(), a.a.e.h.c.BOUNDARY));
    }

    public static <T> g<T> a(i<T> iVar) {
        a.a.e.b.b.a(iVar, "source is null");
        return a.a.h.a.a(new a.a.e.e.b.c(iVar));
    }

    public static <T> g<T> b() {
        return a.a.h.a.a(a.a.e.e.b.f.f167a);
    }

    public static <T> g<T> a(T... tArr) {
        a.a.e.b.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return b();
        }
        if (tArr.length == 1) {
            return a(tArr[0]);
        }
        return a.a.h.a.a(new a.a.e.e.b.h(tArr));
    }

    public static <T> g<T> a(T t) {
        a.a.e.b.b.a((Object) t, "item is null");
        return a.a.h.a.a((g) new a.a.e.e.b.j(t));
    }

    public static <T> g<T> a(j<T> jVar) {
        a.a.e.b.b.a(jVar, "source is null");
        if (jVar instanceof g) {
            return a.a.h.a.a((g) jVar);
        }
        return a.a.h.a.a(new a.a.e.e.b.i(jVar));
    }

    public final g<T> a(a.a.d.a aVar) {
        return a(a.a.e.b.a.b(), aVar);
    }

    private g<T> a(a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar, a.a.d.a aVar2) {
        a.a.e.b.b.a(eVar, "onNext is null");
        a.a.e.b.b.a(eVar2, "onError is null");
        a.a.e.b.b.a(aVar, "onComplete is null");
        a.a.e.b.b.a(aVar2, "onAfterTerminate is null");
        return a.a.h.a.a(new a.a.e.e.b.d(this, eVar, eVar2, aVar, aVar2));
    }

    public final g<T> a(a.a.d.e<? super a.a.b.b> eVar, a.a.d.a aVar) {
        a.a.e.b.b.a(eVar, "onSubscribe is null");
        a.a.e.b.b.a(aVar, "onDispose is null");
        return a.a.h.a.a(new a.a.e.e.b.e(this, eVar, aVar));
    }

    public final g<T> a(a.a.d.e<? super T> eVar) {
        return a(eVar, a.a.e.b.a.b(), a.a.e.b.a.c, a.a.e.b.a.c);
    }

    public final g<T> a(a.a.d.h<? super T> hVar) {
        a.a.e.b.b.a(hVar, "predicate is null");
        return a.a.h.a.a(new a.a.e.e.b.g(this, hVar));
    }

    public final <R> g<R> a(a.a.d.f<? super T, ? extends R> fVar) {
        a.a.e.b.b.a(fVar, "mapper is null");
        return a.a.h.a.a(new a.a.e.e.b.k(this, fVar));
    }

    public final g<T> a(l lVar) {
        return a(lVar, false, a());
    }

    public final g<T> a(l lVar, boolean z, int i) {
        a.a.e.b.b.a(lVar, "scheduler is null");
        a.a.e.b.b.a(i, "bufferSize");
        return a.a.h.a.a(new a.a.e.e.b.l(this, lVar, z, i));
    }

    public final a.a.f.a<T> c() {
        return a.a.e.e.b.m.b((j) this);
    }

    public final g<T> a(long j, a.a.d.h<? super Throwable> hVar) {
        if (j < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        }
        a.a.e.b.b.a(hVar, "predicate is null");
        return a.a.h.a.a(new o(this, j, hVar));
    }

    public final g<T> b(a.a.d.h<? super Throwable> hVar) {
        return a(Long.MAX_VALUE, hVar);
    }

    public final g<T> d() {
        return c().e();
    }

    public final g<T> b(T t) {
        a.a.e.b.b.a((Object) t, "item is null");
        return a(a(t), this);
    }

    public final a.a.b.b b(a.a.d.e<? super T> eVar) {
        return a(eVar, a.a.e.b.a.f, a.a.e.b.a.c, a.a.e.b.a.b());
    }

    public final a.a.b.b a(a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar, a.a.d.e<? super a.a.b.b> eVar3) {
        a.a.e.b.b.a(eVar, "onNext is null");
        a.a.e.b.b.a(eVar2, "onError is null");
        a.a.e.b.b.a(aVar, "onComplete is null");
        a.a.e.b.b.a(eVar3, "onSubscribe is null");
        a.a.e.d.e eVar4 = new a.a.e.d.e(eVar, eVar2, aVar, eVar3);
        a((k) eVar4);
        return eVar4;
    }

    @Override // a.a.j
    public final void a(k<? super T> kVar) {
        a.a.e.b.b.a(kVar, "observer is null");
        try {
            k<? super T> a2 = a.a.h.a.a(this, kVar);
            a.a.e.b.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b((k) a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            a.a.c.b.b(th);
            a.a.h.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final g<T> b(l lVar) {
        a.a.e.b.b.a(lVar, "scheduler is null");
        return a.a.h.a.a(new q(this, lVar));
    }

    public final g<T> a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j);
        }
        return a.a.h.a.a(new r(this, j));
    }

    public final g<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, (j) null, a.a.i.a.a());
    }

    private g<T> a(long j, TimeUnit timeUnit, j<? extends T> jVar, l lVar) {
        a.a.e.b.b.a(timeUnit, "timeUnit is null");
        a.a.e.b.b.a(lVar, "scheduler is null");
        return a.a.h.a.a(new s(this, j, timeUnit, lVar, jVar));
    }
}

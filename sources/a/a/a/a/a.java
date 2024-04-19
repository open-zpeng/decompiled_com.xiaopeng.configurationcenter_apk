package a.a.a.a;

import a.a.c.b;
import a.a.d.f;
import a.a.l;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f<Callable<l>, l> f137a;
    private static volatile f<l, l> b;

    public static l a(Callable<l> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        f<Callable<l>, l> fVar = f137a;
        if (fVar == null) {
            return b(callable);
        }
        return a(fVar, callable);
    }

    public static l a(l lVar) {
        Objects.requireNonNull(lVar, "scheduler == null");
        f<l, l> fVar = b;
        return fVar == null ? lVar : (l) a(fVar, lVar);
    }

    static l b(Callable<l> callable) {
        try {
            l call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static l a(f<Callable<l>, l> fVar, Callable<l> callable) {
        l lVar = (l) a((f<Callable<l>, Object>) fVar, callable);
        Objects.requireNonNull(lVar, "Scheduler Callable returned null");
        return lVar;
    }

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }
}

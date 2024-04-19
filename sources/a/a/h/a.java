package a.a.h;

import a.a.c.c;
import a.a.d;
import a.a.d.b;
import a.a.d.e;
import a.a.d.f;
import a.a.g;
import a.a.k;
import a.a.l;
import java.util.concurrent.Callable;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile e<? super Throwable> f221a;
    static volatile f<? super Runnable, ? extends Runnable> b;
    static volatile f<? super Callable<l>, ? extends l> c;
    static volatile f<? super Callable<l>, ? extends l> d;
    static volatile f<? super Callable<l>, ? extends l> e;
    static volatile f<? super Callable<l>, ? extends l> f;
    static volatile f<? super l, ? extends l> g;
    static volatile f<? super l, ? extends l> h;
    static volatile f<? super l, ? extends l> i;
    static volatile f<? super g, ? extends g> j;
    static volatile f<? super a.a.f.a, ? extends a.a.f.a> k;
    static volatile f<? super d, ? extends d> l;
    static volatile b<? super d, ? super a.a.e, ? extends a.a.e> m;
    static volatile b<? super g, ? super k, ? extends k> n;

    public static l a(Callable<l> callable) {
        a.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<l>, ? extends l> fVar = c;
        if (fVar == null) {
            return e(callable);
        }
        return a(fVar, callable);
    }

    public static l b(Callable<l> callable) {
        a.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<l>, ? extends l> fVar = e;
        if (fVar == null) {
            return e(callable);
        }
        return a(fVar, callable);
    }

    public static l c(Callable<l> callable) {
        a.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<l>, ? extends l> fVar = f;
        if (fVar == null) {
            return e(callable);
        }
        return a(fVar, callable);
    }

    public static l d(Callable<l> callable) {
        a.a.e.b.b.a(callable, "Scheduler Callable can't be null");
        f<? super Callable<l>, ? extends l> fVar = d;
        if (fVar == null) {
            return e(callable);
        }
        return a(fVar, callable);
    }

    public static l a(l lVar) {
        f<? super l, ? extends l> fVar = g;
        return fVar == null ? lVar : (l) a((f<l, Object>) fVar, lVar);
    }

    public static void a(Throwable th) {
        e<? super Throwable> eVar = f221a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!b(th)) {
            th = new a.a.c.f(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static boolean b(Throwable th) {
        return (th instanceof a.a.c.d) || (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof a.a.c.a);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static l b(l lVar) {
        f<? super l, ? extends l> fVar = i;
        return fVar == null ? lVar : (l) a((f<l, Object>) fVar, lVar);
    }

    public static Runnable a(Runnable runnable) {
        a.a.e.b.b.a(runnable, "run is null");
        f<? super Runnable, ? extends Runnable> fVar = b;
        return fVar == null ? runnable : (Runnable) a((f<Runnable, Object>) fVar, runnable);
    }

    public static l c(l lVar) {
        f<? super l, ? extends l> fVar = h;
        return fVar == null ? lVar : (l) a((f<l, Object>) fVar, lVar);
    }

    public static <T> k<? super T> a(g<T> gVar, k<? super T> kVar) {
        b<? super g, ? super k, ? extends k> bVar = n;
        return bVar != null ? (k) a(bVar, gVar, kVar) : kVar;
    }

    public static <T> a.a.e<? super T> a(d<T> dVar, a.a.e<? super T> eVar) {
        b<? super d, ? super a.a.e, ? extends a.a.e> bVar = m;
        return bVar != null ? (a.a.e) a(bVar, dVar, eVar) : eVar;
    }

    public static <T> d<T> a(d<T> dVar) {
        f<? super d, ? extends d> fVar = l;
        return fVar != null ? (d) a((f<d<T>, Object>) fVar, dVar) : dVar;
    }

    public static <T> g<T> a(g<T> gVar) {
        f<? super g, ? extends g> fVar = j;
        return fVar != null ? (g) a((f<g<T>, Object>) fVar, gVar) : gVar;
    }

    public static <T> a.a.f.a<T> a(a.a.f.a<T> aVar) {
        f<? super a.a.f.a, ? extends a.a.f.a> fVar = k;
        return fVar != null ? (a.a.f.a) a((f<a.a.f.a<T>, Object>) fVar, aVar) : aVar;
    }

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            throw a.a.e.h.d.a(th);
        }
    }

    static <T, U, R> R a(b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.a(t, u);
        } catch (Throwable th) {
            throw a.a.e.h.d.a(th);
        }
    }

    static l e(Callable<l> callable) {
        try {
            return (l) a.a.e.b.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw a.a.e.h.d.a(th);
        }
    }

    static l a(f<? super Callable<l>, ? extends l> fVar, Callable<l> callable) {
        return (l) a.a.e.b.b.a(a((f<Callable<l>, Object>) fVar, callable), "Scheduler Callable result can't be null");
    }
}

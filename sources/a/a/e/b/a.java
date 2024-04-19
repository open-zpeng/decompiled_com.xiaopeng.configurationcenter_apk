package a.a.e.b;

import java.util.Comparator;
import java.util.concurrent.Callable;
/* compiled from: Functions.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final a.a.d.f<Object, Object> f148a = new g();
    public static final Runnable b = new d();
    public static final a.a.d.a c = new C0003a();
    static final a.a.d.e<Object> d = new b();
    public static final a.a.d.e<Throwable> e = new e();
    public static final a.a.d.e<Throwable> f = new k();
    public static final a.a.d.g g = new c();
    static final a.a.d.h<Object> h = new l();
    static final a.a.d.h<Object> i = new f();
    static final Callable<Object> j = new j();
    static final Comparator<Object> k = new i();
    public static final a.a.d.e<org.a.b> l = new h();

    public static <T> a.a.d.f<T, T> a() {
        return (a.a.d.f<T, T>) f148a;
    }

    public static <T> a.a.d.e<T> b() {
        return (a.a.d.e<T>) d;
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class g implements a.a.d.f<Object, Object> {
        @Override // a.a.d.f
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        g() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        d() {
        }
    }

    /* compiled from: Functions.java */
    /* renamed from: a.a.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0003a implements a.a.d.a {
        @Override // a.a.d.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        C0003a() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class b implements a.a.d.e<Object> {
        @Override // a.a.d.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        b() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class e implements a.a.d.e<Throwable> {
        e() {
        }

        @Override // a.a.d.e
        /* renamed from: a */
        public void accept(Throwable th) {
            a.a.h.a.a(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class k implements a.a.d.e<Throwable> {
        k() {
        }

        @Override // a.a.d.e
        /* renamed from: a */
        public void accept(Throwable th) {
            a.a.h.a.a(new a.a.c.d(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class c implements a.a.d.g {
        c() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class l implements a.a.d.h<Object> {
        @Override // a.a.d.h
        public boolean test(Object obj) {
            return true;
        }

        l() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class f implements a.a.d.h<Object> {
        @Override // a.a.d.h
        public boolean test(Object obj) {
            return false;
        }

        f() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class j implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        j() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class h implements a.a.d.e<org.a.b> {
        h() {
        }

        @Override // a.a.d.e
        /* renamed from: a */
        public void accept(org.a.b bVar) throws Exception {
            bVar.a(Long.MAX_VALUE);
        }
    }
}

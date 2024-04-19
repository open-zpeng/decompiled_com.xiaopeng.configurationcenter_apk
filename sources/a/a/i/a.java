package a.a.i;

import a.a.e.g.m;
import a.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final l f222a = a.a.h.a.d(new h());
    static final l b = a.a.h.a.a(new b());
    static final l c = a.a.h.a.b(new c());
    static final l d = m.c();
    static final l e = a.a.h.a.c(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: a.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0009a {

        /* renamed from: a  reason: collision with root package name */
        static final l f223a = new a.a.e.g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final l f224a = new a.a.e.g.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final l f225a = new a.a.e.g.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final l f226a = new a.a.e.g.l();
    }

    public static l a() {
        return a.a.h.a.a(b);
    }

    public static l b() {
        return a.a.h.a.b(c);
    }

    public static l c() {
        return a.a.h.a.c(f222a);
    }

    public static l a(Executor executor) {
        return new a.a.e.g.d(executor, false);
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class c implements Callable<l> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l call() throws Exception {
            return d.f224a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class f implements Callable<l> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l call() throws Exception {
            return e.f225a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class h implements Callable<l> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l call() throws Exception {
            return g.f226a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes.dex */
    static final class b implements Callable<l> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l call() throws Exception {
            return C0009a.f223a;
        }
    }
}

package a.a.e.g;

import a.a.l;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* loaded from: classes.dex */
public final class b extends a.a.l {
    static final C0007b b;
    static final h c;
    static final int d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c e;
    final ThreadFactory f;
    final AtomicReference<C0007b> g;

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        c cVar = new c(new h("RxComputationShutdown"));
        e = cVar;
        cVar.dispose();
        h hVar = new h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        c = hVar;
        C0007b c0007b = new C0007b(0, hVar);
        b = c0007b;
        c0007b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: a.a.e.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0007b {

        /* renamed from: a  reason: collision with root package name */
        final int f194a;
        final c[] b;
        long c;

        C0007b(int i, ThreadFactory threadFactory) {
            this.f194a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f194a;
            if (i == 0) {
                return b.e;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    public b() {
        this(c);
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(b);
        b();
    }

    @Override // a.a.l
    public l.b a() {
        return new a(this.g.get().a());
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, timeUnit);
    }

    @Override // a.a.l
    public void b() {
        C0007b c0007b = new C0007b(d, this.f);
        if (this.g.compareAndSet(b, c0007b)) {
            return;
        }
        c0007b.b();
    }

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends l.b {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f193a;
        private final a.a.e.a.e b;
        private final a.a.b.a c;
        private final a.a.e.a.e d;
        private final c e;

        a(c cVar) {
            this.e = cVar;
            a.a.e.a.e eVar = new a.a.e.a.e();
            this.b = eVar;
            a.a.b.a aVar = new a.a.b.a();
            this.c = aVar;
            a.a.e.a.e eVar2 = new a.a.e.a.e();
            this.d = eVar2;
            eVar2.a(eVar);
            eVar2.a(aVar);
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.f193a) {
                return;
            }
            this.f193a = true;
            this.d.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.f193a;
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable) {
            if (this.f193a) {
                return a.a.e.a.d.INSTANCE;
            }
            return this.e.a(runnable, 0L, TimeUnit.MILLISECONDS, this.b);
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f193a) {
                return a.a.e.a.d.INSTANCE;
            }
            return this.e.a(runnable, j, timeUnit, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}

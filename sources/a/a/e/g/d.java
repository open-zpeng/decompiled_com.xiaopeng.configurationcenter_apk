package a.a.e.g;

import a.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExecutorScheduler.java */
/* loaded from: classes.dex */
public final class d extends a.a.l {
    static final a.a.l d = a.a.i.a.c();
    final boolean b;
    final Executor c;

    public d(Executor executor, boolean z) {
        this.c = executor;
        this.b = z;
    }

    @Override // a.a.l
    public l.b a() {
        return new c(this.c, this.b);
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable) {
        Runnable a2 = a.a.h.a.a(runnable);
        try {
            if (this.c instanceof ExecutorService) {
                i iVar = new i(a2);
                iVar.a(((ExecutorService) this.c).submit(iVar));
                return iVar;
            } else if (this.b) {
                c.b bVar = new c.b(a2, null);
                this.c.execute(bVar);
                return bVar;
            } else {
                c.a aVar = new c.a(a2);
                this.c.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e) {
            a.a.h.a.a(e);
            return a.a.e.a.d.INSTANCE;
        }
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable a2 = a.a.h.a.a(runnable);
        if (this.c instanceof ScheduledExecutorService) {
            try {
                i iVar = new i(a2);
                iVar.a(((ScheduledExecutorService) this.c).schedule(iVar, j, timeUnit));
                return iVar;
            } catch (RejectedExecutionException e) {
                a.a.h.a.a(e);
                return a.a.e.a.d.INSTANCE;
            }
        }
        b bVar = new b(a2);
        bVar.f197a.a(d.a(new a(bVar), j, timeUnit));
        return bVar;
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends l.b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f198a;
        final Executor b;
        volatile boolean d;
        final AtomicInteger e = new AtomicInteger();
        final a.a.b.a f = new a.a.b.a();
        final a.a.e.f.a<Runnable> c = new a.a.e.f.a<>();

        public c(Executor executor, boolean z) {
            this.b = executor;
            this.f198a = z;
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable) {
            a.a.b.b aVar;
            if (this.d) {
                return a.a.e.a.d.INSTANCE;
            }
            Runnable a2 = a.a.h.a.a(runnable);
            if (this.f198a) {
                aVar = new b(a2, this.f);
                this.f.a(aVar);
            } else {
                aVar = new a(a2);
            }
            this.c.offer(aVar);
            if (this.e.getAndIncrement() == 0) {
                try {
                    this.b.execute(this);
                } catch (RejectedExecutionException e) {
                    this.d = true;
                    this.c.clear();
                    a.a.h.a.a(e);
                    return a.a.e.a.d.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(runnable);
            }
            if (this.d) {
                return a.a.e.a.d.INSTANCE;
            }
            a.a.e.a.g gVar = new a.a.e.a.g();
            a.a.e.a.g gVar2 = new a.a.e.a.g(gVar);
            j jVar = new j(new RunnableC0008c(gVar2, a.a.h.a.a(runnable)), this.f);
            this.f.a(jVar);
            Executor executor = this.b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    jVar.a(((ScheduledExecutorService) executor).schedule((Callable) jVar, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.d = true;
                    a.a.h.a.a(e);
                    return a.a.e.a.d.INSTANCE;
                }
            } else {
                jVar.a(new a.a.e.g.c(d.d.a(jVar, j, timeUnit)));
            }
            gVar.a(jVar);
            return gVar2;
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.f.dispose();
            if (this.e.getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r3.d == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
            r1 = r3.e.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 != 0) goto L2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
                a.a.e.f.a<java.lang.Runnable> r0 = r3.c
                r1 = 1
            L3:
                boolean r2 = r3.d
                if (r2 == 0) goto Lb
                r0.clear()
                return
            Lb:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L25
                boolean r2 = r3.d
                if (r2 == 0) goto L1b
                r0.clear()
                return
            L1b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.e
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L3
                return
            L25:
                r2.run()
                boolean r2 = r3.d
                if (r2 == 0) goto Lb
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a.a.e.g.d.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes.dex */
        public static final class a extends AtomicBoolean implements a.a.b.b, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;

            /* renamed from: a  reason: collision with root package name */
            final Runnable f199a;

            a(Runnable runnable) {
                this.f199a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f199a.run();
                } finally {
                    lazySet(true);
                }
            }

            @Override // a.a.b.b
            public void dispose() {
                lazySet(true);
            }

            @Override // a.a.b.b
            public boolean isDisposed() {
                return get();
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: a.a.e.g.d$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class RunnableC0008c implements Runnable {
            private final a.a.e.a.g b;
            private final Runnable c;

            RunnableC0008c(a.a.e.a.g gVar, Runnable runnable) {
                this.b = gVar;
                this.c = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.a(c.this.a(this.c));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes.dex */
        public static final class b extends AtomicInteger implements a.a.b.b, Runnable {
            private static final long serialVersionUID = -3603436687413320876L;

            /* renamed from: a  reason: collision with root package name */
            final Runnable f200a;
            final a.a.e.a.b b;
            volatile Thread c;

            b(Runnable runnable, a.a.e.a.b bVar) {
                this.f200a = runnable;
                this.b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.c = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f200a.run();
                            this.c = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                            return;
                        } catch (Throwable th) {
                            this.c = null;
                            if (compareAndSet(1, 2)) {
                                a();
                            } else {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            }
                            throw th;
                        }
                    }
                    this.c = null;
                }
            }

            @Override // a.a.b.b
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.c;
                        if (thread != null) {
                            thread.interrupt();
                            this.c = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            void a() {
                a.a.e.a.b bVar = this.b;
                if (bVar != null) {
                    bVar.c(this);
                }
            }

            @Override // a.a.b.b
            public boolean isDisposed() {
                return get() >= 2;
            }
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes.dex */
    static final class b extends AtomicReference<Runnable> implements a.a.b.b, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.e.a.g f197a;
        final a.a.e.a.g b;

        b(Runnable runnable) {
            super(runnable);
            this.f197a = new a.a.e.a.g();
            this.b = new a.a.e.a.g();
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.f197a.lazySet(a.a.e.a.c.DISPOSED);
                    this.b.lazySet(a.a.e.a.c.DISPOSED);
                }
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // a.a.b.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f197a.dispose();
                this.b.dispose();
            }
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes.dex */
    final class a implements Runnable {
        private final b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.b.a(d.this.a(this.b));
        }
    }
}

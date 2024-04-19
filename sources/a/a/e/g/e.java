package a.a.e.g;

import a.a.l;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* loaded from: classes.dex */
public final class e extends a.a.l {
    static final h b;
    static final h c;
    static final c d;
    static final a g;
    final ThreadFactory e;
    final AtomicReference<a> f;
    private static final TimeUnit i = TimeUnit.SECONDS;
    private static final long h = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        c cVar = new c(new h("RxCachedThreadSchedulerShutdown"));
        d = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        h hVar = new h("RxCachedThreadScheduler", max);
        b = hVar;
        c = new h("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, hVar);
        g = aVar;
        aVar.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a.a.b.a f202a;
        private final long b;
        private final ConcurrentLinkedQueue<c> c;
        private final ScheduledExecutorService d;
        private final Future<?> e;
        private final ThreadFactory f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.b = nanos;
            this.c = new ConcurrentLinkedQueue<>();
            this.f202a = new a.a.b.a();
            this.f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, e.c);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.d = scheduledExecutorService;
            this.e = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }

        c a() {
            if (this.f202a.isDisposed()) {
                return e.d;
            }
            while (!this.c.isEmpty()) {
                c poll = this.c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f);
            this.f202a.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.a(c() + this.b);
            this.c.offer(cVar);
        }

        void b() {
            if (this.c.isEmpty()) {
                return;
            }
            long c = c();
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a() > c) {
                    return;
                }
                if (this.c.remove(next)) {
                    this.f202a.b(next);
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f202a.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public e() {
        this(b);
    }

    public e(ThreadFactory threadFactory) {
        this.e = threadFactory;
        this.f = new AtomicReference<>(g);
        b();
    }

    @Override // a.a.l
    public void b() {
        a aVar = new a(h, i, this.e);
        if (this.f.compareAndSet(g, aVar)) {
            return;
        }
        aVar.d();
    }

    @Override // a.a.l
    public l.b a() {
        return new b(this.f.get());
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    static final class b extends l.b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f203a = new AtomicBoolean();
        private final a.a.b.a b = new a.a.b.a();
        private final a c;
        private final c d;

        b(a aVar) {
            this.c = aVar;
            this.d = aVar.a();
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.f203a.compareAndSet(false, true)) {
                this.b.dispose();
                this.c.a(this.d);
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.f203a.get();
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.b.isDisposed()) {
                return a.a.e.a.d.INSTANCE;
            }
            return this.d.a(runnable, j, timeUnit, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends g {
        private long b;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.b = 0L;
        }

        public long a() {
            return this.b;
        }

        public void a(long j) {
            this.b = j;
        }
    }
}

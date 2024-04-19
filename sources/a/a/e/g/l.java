package a.a.e.g;

import a.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* loaded from: classes.dex */
public final class l extends a.a.l {
    static final h d;
    static final ScheduledExecutorService e;
    final ThreadFactory b;
    final AtomicReference<ScheduledExecutorService> c;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        d = new h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public l() {
        this(d);
    }

    public l(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.c = atomicReference;
        this.b = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return k.a(threadFactory);
    }

    @Override // a.a.l
    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.c.get();
            if (scheduledExecutorService != e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.b);
            }
        } while (!this.c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // a.a.l
    public l.b a() {
        return new a(this.c.get());
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        i iVar = new i(a.a.h.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.c.get().submit(iVar);
            } else {
                schedule = this.c.get().schedule(iVar, j, timeUnit);
            }
            iVar.a(schedule);
            return iVar;
        } catch (RejectedExecutionException e2) {
            a.a.h.a.a(e2);
            return a.a.e.a.d.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends l.b {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f209a;
        final a.a.b.a b = new a.a.b.a();
        volatile boolean c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f209a = scheduledExecutorService;
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.c) {
                return a.a.e.a.d.INSTANCE;
            }
            j jVar = new j(a.a.h.a.a(runnable), this.b);
            this.b.a(jVar);
            try {
                if (j <= 0) {
                    schedule = this.f209a.submit((Callable) jVar);
                } else {
                    schedule = this.f209a.schedule((Callable) jVar, j, timeUnit);
                }
                jVar.a(schedule);
                return jVar;
            } catch (RejectedExecutionException e) {
                dispose();
                a.a.h.a.a(e);
                return a.a.e.a.d.INSTANCE;
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.c;
        }
    }
}

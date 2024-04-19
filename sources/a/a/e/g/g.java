package a.a.e.g;

import a.a.l;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes.dex */
public class g extends l.b implements a.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f204a;
    private final ScheduledExecutorService b;

    public g(ThreadFactory threadFactory) {
        this.b = k.a(threadFactory);
    }

    @Override // a.a.l.b
    public a.a.b.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    @Override // a.a.l.b
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f204a) {
            return a.a.e.a.d.INSTANCE;
        }
        return a(runnable, j, timeUnit, null);
    }

    public a.a.b.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        i iVar = new i(a.a.h.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.b.submit(iVar);
            } else {
                schedule = this.b.schedule(iVar, j, timeUnit);
            }
            iVar.a(schedule);
            return iVar;
        } catch (RejectedExecutionException e) {
            a.a.h.a.a(e);
            return a.a.e.a.d.INSTANCE;
        }
    }

    public j a(Runnable runnable, long j, TimeUnit timeUnit, a.a.e.a.b bVar) {
        Future<?> schedule;
        j jVar = new j(a.a.h.a.a(runnable), bVar);
        if (bVar == null || bVar.a(jVar)) {
            try {
                if (j <= 0) {
                    schedule = this.b.submit((Callable) jVar);
                } else {
                    schedule = this.b.schedule((Callable) jVar, j, timeUnit);
                }
                jVar.a(schedule);
            } catch (RejectedExecutionException e) {
                if (bVar != null) {
                    bVar.b(jVar);
                }
                a.a.h.a.a(e);
            }
            return jVar;
        }
        return jVar;
    }

    @Override // a.a.b.b
    public void dispose() {
        if (this.f204a) {
            return;
        }
        this.f204a = true;
        this.b.shutdownNow();
    }

    public void b() {
        if (this.f204a) {
            return;
        }
        this.f204a = true;
        this.b.shutdown();
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.f204a;
    }
}

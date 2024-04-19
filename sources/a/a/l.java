package a.a;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    static final long f227a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract b a();

    public void b() {
    }

    public a.a.b.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(a.a.h.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static abstract class b implements a.a.b.b {
        public abstract a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public a.a.b.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements a.a.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f228a;
        final b b;
        Thread c;

        a(Runnable runnable, b bVar) {
            this.f228a = runnable;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.f228a.run();
            } finally {
                dispose();
                this.c = null;
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                b bVar = this.b;
                if (bVar instanceof a.a.e.g.g) {
                    ((a.a.e.g.g) bVar).b();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.b.isDisposed();
        }
    }
}

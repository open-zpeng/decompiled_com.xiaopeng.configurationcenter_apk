package a.a.e.g;

import a.a.l;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes.dex */
public final class m extends a.a.l {
    private static final m b = new m();

    public static m c() {
        return b;
    }

    @Override // a.a.l
    public l.b a() {
        return new c();
    }

    m() {
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable) {
        a.a.h.a.a(runnable).run();
        return a.a.e.a.d.INSTANCE;
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            a.a.h.a.a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            a.a.h.a.a(e);
        }
        return a.a.e.a.d.INSTANCE;
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class c extends l.b implements a.a.b.b {
        volatile boolean c;

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f212a = new PriorityBlockingQueue<>();
        private final AtomicInteger d = new AtomicInteger();
        final AtomicInteger b = new AtomicInteger();

        c() {
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        a.a.b.b a(Runnable runnable, long j) {
            if (this.c) {
                return a.a.e.a.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.b.incrementAndGet());
            this.f212a.add(bVar);
            if (this.d.getAndIncrement() == 0) {
                int i = 1;
                while (!this.c) {
                    b poll = this.f212a.poll();
                    if (poll != null) {
                        if (!poll.d) {
                            poll.f211a.run();
                        }
                    } else {
                        i = this.d.addAndGet(-i);
                        if (i == 0) {
                            return a.a.e.a.d.INSTANCE;
                        }
                    }
                }
                this.f212a.clear();
                return a.a.e.a.d.INSTANCE;
            }
            return a.a.b.c.a(new a(bVar));
        }

        @Override // a.a.b.b
        public void dispose() {
            this.c = true;
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f213a;

            a(b bVar) {
                this.f213a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f213a.d = true;
                c.this.f212a.remove(this.f213a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f211a;
        final long b;
        final int c;
        volatile boolean d;

        b(Runnable runnable, Long l, int i) {
            this.f211a = runnable;
            this.b = l.longValue();
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = a.a.e.b.b.a(this.b, bVar.b);
            return a2 == 0 ? a.a.e.b.b.a(this.c, bVar.c) : a2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f210a;
        private final c b;
        private final long c;

        a(Runnable runnable, c cVar, long j) {
            this.f210a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.c) {
                return;
            }
            long a2 = this.b.a(TimeUnit.MILLISECONDS);
            long j = this.c;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    a.a.h.a.a(e);
                    return;
                }
            }
            if (this.b.c) {
                return;
            }
            this.f210a.run();
        }
    }
}

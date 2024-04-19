package a.a.a.b;

import a.a.b.c;
import a.a.l;
import android.os.Handler;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HandlerScheduler.java */
/* loaded from: classes.dex */
public final class b extends l {
    private final Handler b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.b = handler;
    }

    @Override // a.a.l
    public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0001b runnableC0001b = new RunnableC0001b(this.b, a.a.h.a.a(runnable));
        this.b.postDelayed(runnableC0001b, timeUnit.toMillis(j));
        return runnableC0001b;
    }

    @Override // a.a.l
    public l.b a() {
        return new a(this.b);
    }

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes.dex */
    private static final class a extends l.b {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f140a;
        private volatile boolean b;

        a(Handler handler) {
            this.f140a = handler;
        }

        @Override // a.a.l.b
        public a.a.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.b) {
                return c.b();
            }
            RunnableC0001b runnableC0001b = new RunnableC0001b(this.f140a, a.a.h.a.a(runnable));
            Message obtain = Message.obtain(this.f140a, runnableC0001b);
            obtain.obj = this;
            this.f140a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.b) {
                this.f140a.removeCallbacks(runnableC0001b);
                return c.b();
            }
            return runnableC0001b;
        }

        @Override // a.a.b.b
        public void dispose() {
            this.b = true;
            this.f140a.removeCallbacksAndMessages(this);
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: a.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class RunnableC0001b implements a.a.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f141a;
        private final Runnable b;
        private volatile boolean c;

        RunnableC0001b(Handler handler, Runnable runnable) {
            this.f141a = handler;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                a.a.h.a.a(th);
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            this.c = true;
            this.f141a.removeCallbacks(this);
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.c;
        }
    }
}

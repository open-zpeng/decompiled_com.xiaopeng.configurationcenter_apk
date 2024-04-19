package a.a.e.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: AbstractDirectTask.java */
/* loaded from: classes.dex */
abstract class a extends AtomicReference<Future<?>> implements a.a.b.b {
    protected static final FutureTask<Void> c = new FutureTask<>(a.a.e.b.a.b, null);
    protected static final FutureTask<Void> d = new FutureTask<>(a.a.e.b.a.b, null);
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: a  reason: collision with root package name */
    protected final Runnable f192a;
    protected Thread b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f192a = runnable;
    }

    @Override // a.a.b.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == c || future == (futureTask = d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.b != Thread.currentThread());
    }

    @Override // a.a.b.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == c || future == d;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == c) {
                return;
            }
            if (future2 == d) {
                future.cancel(this.b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}

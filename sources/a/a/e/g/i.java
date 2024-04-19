package a.a.e.g;

import java.util.concurrent.Callable;
/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes.dex */
public final class i extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Void call() throws Exception {
        this.b = Thread.currentThread();
        try {
            this.f192a.run();
            return null;
        } finally {
            lazySet(c);
            this.b = null;
        }
    }
}

package a.a.e.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: ScheduledRunnable.java */
/* loaded from: classes.dex */
public final class j extends AtomicReferenceArray<Object> implements a.a.b.b, Runnable, Callable<Object> {
    static final Object b = new Object();
    static final Object c = new Object();
    static final Object d = new Object();
    static final Object e = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: a  reason: collision with root package name */
    final Runnable f206a;

    public j(Runnable runnable, a.a.e.a.b bVar) {
        super(3);
        this.f206a = runnable;
        lazySet(0, bVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f206a.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != b) {
                    ((a.a.e.a.b) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != c) {
                        return;
                    }
                    return;
                } while (!compareAndSet(1, obj5, e));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != b && compareAndSet(0, obj4, e) && obj4 != null) {
            ((a.a.e.a.b) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != c || obj5 == d) {
                return;
            }
        } while (!compareAndSet(1, obj5, e));
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == e) {
                return;
            }
            if (obj == c) {
                future.cancel(false);
                return;
            } else if (obj == d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // a.a.b.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == e || obj5 == (obj3 = c) || obj5 == (obj4 = d)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == e || obj == (obj2 = b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((a.a.e.a.b) obj).c(this);
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == b || obj == e;
    }
}

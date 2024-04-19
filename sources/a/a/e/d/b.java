package a.a.e.d;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes.dex */
public abstract class b<T> extends AtomicInteger implements a.a.e.c.a<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // a.a.e.c.e
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}

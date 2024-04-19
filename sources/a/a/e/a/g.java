package a.a.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* loaded from: classes.dex */
public final class g extends AtomicReference<a.a.b.b> implements a.a.b.b {
    private static final long serialVersionUID = -754898800686245608L;

    public g() {
    }

    public g(a.a.b.b bVar) {
        lazySet(bVar);
    }

    public boolean a(a.a.b.b bVar) {
        return c.replace(this, bVar);
    }

    @Override // a.a.b.b
    public void dispose() {
        c.dispose(this);
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return c.isDisposed(get());
    }
}

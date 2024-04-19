package a.a.b;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* loaded from: classes.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void a(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(T t) {
        super(a.a.e.b.b.a((Object) t, "value is null"));
    }

    @Override // a.a.b.b
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // a.a.b.b
    public final boolean isDisposed() {
        return get() == null;
    }
}

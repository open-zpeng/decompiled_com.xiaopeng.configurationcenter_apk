package a.a.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CancellableDisposable.java */
/* loaded from: classes.dex */
public final class a extends AtomicReference<a.a.d.d> implements a.a.b.b {
    private static final long serialVersionUID = 5718521705281392066L;

    public a(a.a.d.d dVar) {
        super(dVar);
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return get() == null;
    }

    @Override // a.a.b.b
    public void dispose() {
        a.a.d.d andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            a.a.c.b.b(e);
            a.a.h.a.a(e);
        }
    }
}

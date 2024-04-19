package a.a.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* loaded from: classes.dex */
public enum c implements a.a.b.b {
    DISPOSED;

    @Override // a.a.b.b
    public void dispose() {
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(a.a.b.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean set(AtomicReference<a.a.b.b> atomicReference, a.a.b.b bVar) {
        a.a.b.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.dispose();
            return true;
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<a.a.b.b> atomicReference, a.a.b.b bVar) {
        a.a.e.b.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            reportDisposableSet();
            return false;
        }
        return false;
    }

    public static boolean replace(AtomicReference<a.a.b.b> atomicReference, a.a.b.b bVar) {
        a.a.b.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean dispose(AtomicReference<a.a.b.b> atomicReference) {
        a.a.b.b andSet;
        a.a.b.b bVar = atomicReference.get();
        c cVar = DISPOSED;
        if (bVar == cVar || (andSet = atomicReference.getAndSet(cVar)) == cVar) {
            return false;
        }
        if (andSet != null) {
            andSet.dispose();
            return true;
        }
        return true;
    }

    public static boolean validate(a.a.b.b bVar, a.a.b.b bVar2) {
        if (bVar2 == null) {
            a.a.h.a.a(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        } else {
            return true;
        }
    }

    public static void reportDisposableSet() {
        a.a.h.a.a(new a.a.c.e("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<a.a.b.b> atomicReference, a.a.b.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
            return false;
        }
        return false;
    }
}

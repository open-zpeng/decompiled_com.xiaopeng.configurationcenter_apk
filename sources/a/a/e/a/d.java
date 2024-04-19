package a.a.e.a;

import a.a.k;
import a.a.m;
/* compiled from: EmptyDisposable.java */
/* loaded from: classes.dex */
public enum d implements a.a.e.c.a<Object> {
    INSTANCE,
    NEVER;

    @Override // a.a.e.c.e
    public void clear() {
    }

    @Override // a.a.b.b
    public void dispose() {
    }

    @Override // a.a.e.c.e
    public boolean isEmpty() {
        return true;
    }

    @Override // a.a.e.c.e
    public Object poll() throws Exception {
        return null;
    }

    @Override // a.a.e.c.b
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onComplete();
    }

    public static void complete(a.a.e<?> eVar) {
        eVar.a((a.a.b.b) INSTANCE);
        eVar.a();
    }

    public static void error(Throwable th, k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onError(th);
    }

    public static void complete(a.a.a aVar) {
        aVar.a(INSTANCE);
        aVar.a();
    }

    public static void error(Throwable th, a.a.a aVar) {
        aVar.a(INSTANCE);
        aVar.a(th);
    }

    public static void error(Throwable th, m<?> mVar) {
        mVar.a(INSTANCE);
        mVar.a(th);
    }

    public static void error(Throwable th, a.a.e<?> eVar) {
        eVar.a((a.a.b.b) INSTANCE);
        eVar.a(th);
    }

    @Override // a.a.e.c.e
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

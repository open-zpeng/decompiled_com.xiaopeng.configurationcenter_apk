package a.a.e.e.b;

import a.a.e.e.b.p;
/* compiled from: ObservableJust.java */
/* loaded from: classes.dex */
public final class j<T> extends a.a.g<T> implements a.a.e.c.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f171a;

    public j(T t) {
        this.f171a = t;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        p.a aVar = new p.a(kVar, this.f171a);
        kVar.onSubscribe(aVar);
        aVar.run();
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        return this.f171a;
    }
}

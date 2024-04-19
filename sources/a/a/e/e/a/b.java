package a.a.e.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeCallbackObserver.java */
/* loaded from: classes.dex */
public final class b<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, a.a.e<T> {
    private static final long serialVersionUID = -6076952298809384986L;

    /* renamed from: a  reason: collision with root package name */
    final a.a.d.e<? super T> f154a;
    final a.a.d.e<? super Throwable> b;
    final a.a.d.a c;

    public b(a.a.d.e<? super T> eVar, a.a.d.e<? super Throwable> eVar2, a.a.d.a aVar) {
        this.f154a = eVar;
        this.b = eVar2;
        this.c = aVar;
    }

    @Override // a.a.b.b
    public void dispose() {
        a.a.e.a.c.dispose(this);
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return a.a.e.a.c.isDisposed(get());
    }

    @Override // a.a.e
    public void a(a.a.b.b bVar) {
        a.a.e.a.c.setOnce(this, bVar);
    }

    @Override // a.a.e
    public void a(T t) {
        lazySet(a.a.e.a.c.DISPOSED);
        try {
            this.f154a.accept(t);
        } catch (Throwable th) {
            a.a.c.b.b(th);
            a.a.h.a.a(th);
        }
    }

    @Override // a.a.e
    public void a(Throwable th) {
        lazySet(a.a.e.a.c.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            a.a.c.b.b(th2);
            a.a.h.a.a(new a.a.c.a(th, th2));
        }
    }

    @Override // a.a.e
    public void a() {
        lazySet(a.a.e.a.c.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            a.a.c.b.b(th);
            a.a.h.a.a(th);
        }
    }
}

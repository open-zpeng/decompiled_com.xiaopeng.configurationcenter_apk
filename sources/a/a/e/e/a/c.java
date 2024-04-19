package a.a.e.e.a;

import java.util.concurrent.Callable;
/* compiled from: MaybeFromCallable.java */
/* loaded from: classes.dex */
public final class c<T> extends a.a.d<T> implements Callable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f155a;

    public c(Callable<? extends T> callable) {
        this.f155a = callable;
    }

    @Override // a.a.d
    protected void b(a.a.e<? super T> eVar) {
        a.a.b.b a2 = a.a.b.c.a();
        eVar.a(a2);
        if (a2.isDisposed()) {
            return;
        }
        try {
            Object obj = (T) this.f155a.call();
            if (a2.isDisposed()) {
                return;
            }
            if (obj == null) {
                eVar.a();
            } else {
                eVar.a((a.a.e<? super T>) obj);
            }
        } catch (Throwable th) {
            a.a.c.b.b(th);
            if (!a2.isDisposed()) {
                eVar.a(th);
            } else {
                a.a.h.a.a(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.f155a.call();
    }
}

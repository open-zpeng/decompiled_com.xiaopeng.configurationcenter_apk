package a.a.g;

import a.a.b.b;
import a.a.e.a.c;
import a.a.e.h.e;
import a.a.k;
/* compiled from: SerializedObserver.java */
/* loaded from: classes.dex */
public final class a<T> implements b, k<T> {

    /* renamed from: a  reason: collision with root package name */
    final k<? super T> f220a;
    final boolean b;
    b c;
    boolean d;
    a.a.e.h.a<Object> e;
    volatile boolean f;

    public a(k<? super T> kVar) {
        this(kVar, false);
    }

    public a(k<? super T> kVar, boolean z) {
        this.f220a = kVar;
        this.b = z;
    }

    @Override // a.a.k
    public void onSubscribe(b bVar) {
        if (c.validate(this.c, bVar)) {
            this.c = bVar;
            this.f220a.onSubscribe(this);
        }
    }

    @Override // a.a.b.b
    public void dispose() {
        this.c.dispose();
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // a.a.k
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                a.a.e.h.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new a.a.e.h.a<>(4);
                    this.e = aVar;
                }
                aVar.a((a.a.e.h.a<Object>) e.next(t));
                return;
            }
            this.d = true;
            this.f220a.onNext(t);
            a();
        }
    }

    @Override // a.a.k
    public void onError(Throwable th) {
        if (this.f) {
            a.a.h.a.a(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    a.a.e.h.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new a.a.e.h.a<>(4);
                        this.e = aVar;
                    }
                    Object error = e.error(th);
                    if (this.b) {
                        aVar.a((a.a.e.h.a<Object>) error);
                    } else {
                        aVar.b(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
            if (z) {
                a.a.h.a.a(th);
            } else {
                this.f220a.onError(th);
            }
        }
    }

    @Override // a.a.k
    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                return;
            }
            if (this.d) {
                a.a.e.h.a<Object> aVar = this.e;
                if (aVar == null) {
                    aVar = new a.a.e.h.a<>(4);
                    this.e = aVar;
                }
                aVar.a((a.a.e.h.a<Object>) e.complete());
                return;
            }
            this.f = true;
            this.d = true;
            this.f220a.onComplete();
        }
    }

    void a() {
        a.a.e.h.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.e;
                if (aVar == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!aVar.a((k<? super T>) this.f220a));
    }
}

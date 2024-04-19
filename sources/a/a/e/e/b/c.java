package a.a.e.e.b;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCreate.java */
/* loaded from: classes.dex */
public final class c<T> extends a.a.g<T> {

    /* renamed from: a  reason: collision with root package name */
    final a.a.i<T> f164a;

    public c(a.a.i<T> iVar) {
        this.f164a = iVar;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.onSubscribe(aVar);
        try {
            this.f164a.subscribe(aVar);
        } catch (Throwable th) {
            a.a.c.b.b(th);
            aVar.a(th);
        }
    }

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, a.a.h<T> {
        private static final long serialVersionUID = -3434801548987643227L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f165a;

        a(a.a.k<? super T> kVar) {
            this.f165a = kVar;
        }

        @Override // a.a.b
        public void a(T t) {
            if (t == null) {
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (isDisposed()) {
            } else {
                this.f165a.onNext(t);
            }
        }

        @Override // a.a.b
        public void a(Throwable th) {
            if (b(th)) {
                return;
            }
            a.a.h.a.a(th);
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f165a.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        public void a(a.a.b.b bVar) {
            a.a.e.a.c.set(this, bVar);
        }

        @Override // a.a.h
        public void a(a.a.d.d dVar) {
            a((a.a.b.b) new a.a.e.a.a(dVar));
        }

        @Override // a.a.b.b
        public void dispose() {
            a.a.e.a.c.dispose(this);
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return a.a.e.a.c.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}

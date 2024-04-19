package a.a.e.e.a;

import a.a.f;
import a.a.l;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeObserveOn.java */
/* loaded from: classes.dex */
public final class d<T> extends a.a.e.e.a.a<T, T> {
    final l b;

    public d(f<T> fVar, l lVar) {
        super(fVar);
        this.b = lVar;
    }

    @Override // a.a.d
    protected void b(a.a.e<? super T> eVar) {
        this.f153a.a(new a(eVar, this.b));
    }

    /* compiled from: MaybeObserveOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, a.a.e<T>, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.e<? super T> f156a;
        final l b;
        T c;
        Throwable d;

        a(a.a.e<? super T> eVar, l lVar) {
            this.f156a = eVar;
            this.b = lVar;
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
            if (a.a.e.a.c.setOnce(this, bVar)) {
                this.f156a.a((a.a.b.b) this);
            }
        }

        @Override // a.a.e
        public void a(T t) {
            this.c = t;
            a.a.e.a.c.replace(this, this.b.a(this));
        }

        @Override // a.a.e
        public void a(Throwable th) {
            this.d = th;
            a.a.e.a.c.replace(this, this.b.a(this));
        }

        @Override // a.a.e
        public void a() {
            a.a.e.a.c.replace(this, this.b.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.d;
            if (th != null) {
                this.d = null;
                this.f156a.a(th);
                return;
            }
            T t = this.c;
            if (t != null) {
                this.c = null;
                this.f156a.a((a.a.e<? super T>) t);
                return;
            }
            this.f156a.a();
        }
    }
}

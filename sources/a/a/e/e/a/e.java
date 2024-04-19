package a.a.e.e.a;

import a.a.e.a.g;
import a.a.f;
import a.a.l;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MaybeSubscribeOn.java */
/* loaded from: classes.dex */
public final class e<T> extends a.a.e.e.a.a<T, T> {
    final l b;

    public e(f<T> fVar, l lVar) {
        super(fVar);
        this.b = lVar;
    }

    @Override // a.a.d
    protected void b(a.a.e<? super T> eVar) {
        a aVar = new a(eVar);
        eVar.a((a.a.b.b) aVar);
        aVar.f157a.a(this.b.a(new b(aVar, this.f153a)));
    }

    /* compiled from: MaybeSubscribeOn.java */
    /* loaded from: classes.dex */
    static final class b<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a.a.e<? super T> f158a;
        final f<T> b;

        b(a.a.e<? super T> eVar, f<T> fVar) {
            this.f158a = eVar;
            this.b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.f158a);
        }
    }

    /* compiled from: MaybeSubscribeOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, a.a.e<T> {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: a  reason: collision with root package name */
        final g f157a = new g();
        final a.a.e<? super T> b;

        a(a.a.e<? super T> eVar) {
            this.b = eVar;
        }

        @Override // a.a.b.b
        public void dispose() {
            a.a.e.a.c.dispose(this);
            this.f157a.dispose();
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
            this.b.a((a.a.e<? super T>) t);
        }

        @Override // a.a.e
        public void a(Throwable th) {
            this.b.a(th);
        }

        @Override // a.a.e
        public void a() {
            this.b.a();
        }
    }
}

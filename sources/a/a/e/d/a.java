package a.a.e.d;

import a.a.k;
/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes.dex */
public abstract class a<T, R> implements a.a.e.c.a<R>, k<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final k<? super R> f150a;
    protected a.a.b.b b;
    protected a.a.e.c.a<T> c;
    protected boolean d;
    protected int e;

    protected boolean a() {
        return true;
    }

    protected void b() {
    }

    public a(k<? super R> kVar) {
        this.f150a = kVar;
    }

    @Override // a.a.k
    public final void onSubscribe(a.a.b.b bVar) {
        if (a.a.e.a.c.validate(this.b, bVar)) {
            this.b = bVar;
            if (bVar instanceof a.a.e.c.a) {
                this.c = (a.a.e.c.a) bVar;
            }
            if (a()) {
                this.f150a.onSubscribe(this);
                b();
            }
        }
    }

    @Override // a.a.k
    public void onError(Throwable th) {
        if (this.d) {
            a.a.h.a.a(th);
            return;
        }
        this.d = true;
        this.f150a.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        a.a.c.b.b(th);
        this.b.dispose();
        onError(th);
    }

    @Override // a.a.k
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f150a.onComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        a.a.e.c.a<T> aVar = this.c;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = aVar.requestFusion(i);
        if (requestFusion != 0) {
            this.e = requestFusion;
        }
        return requestFusion;
    }

    @Override // a.a.b.b
    public void dispose() {
        this.b.dispose();
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // a.a.e.c.e
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // a.a.e.c.e
    public void clear() {
        this.c.clear();
    }

    @Override // a.a.e.c.e
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

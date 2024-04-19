package a.a.e.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservablePublish.java */
/* loaded from: classes.dex */
public final class m<T> extends a.a.f.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final a.a.j<T> f173a;
    final AtomicReference<b<T>> b;
    final a.a.j<T> c;

    public static <T> a.a.f.a<T> b(a.a.j<T> jVar) {
        AtomicReference atomicReference = new AtomicReference();
        return a.a.h.a.a((a.a.f.a) new m(new c(atomicReference), jVar, atomicReference));
    }

    private m(a.a.j<T> jVar, a.a.j<T> jVar2, AtomicReference<b<T>> atomicReference) {
        this.c = jVar;
        this.f173a = jVar2;
        this.b = atomicReference;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        this.c.a(kVar);
    }

    @Override // a.a.f.a
    public void c(a.a.d.e<? super a.a.b.b> eVar) {
        b<T> bVar;
        while (true) {
            bVar = this.b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (this.b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = true;
        if (bVar.e.get() || !bVar.e.compareAndSet(false, true)) {
            z = false;
        }
        try {
            eVar.accept(bVar);
            if (z) {
                this.f173a.a(bVar);
            }
        } catch (Throwable th) {
            a.a.c.b.b(th);
            throw a.a.e.h.d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class b<T> implements a.a.b.b, a.a.k<T> {
        static final a[] b = new a[0];
        static final a[] c = new a[0];

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<b<T>> f175a;
        final AtomicReference<a.a.b.b> f = new AtomicReference<>();
        final AtomicReference<a<T>[]> d = new AtomicReference<>(b);
        final AtomicBoolean e = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f175a = atomicReference;
        }

        @Override // a.a.b.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.d;
            a<T>[] aVarArr = c;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.f175a.compareAndSet(this, null);
                a.a.e.a.c.dispose(this.f);
            }
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.d.get() == c;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            a.a.e.a.c.setOnce(this.f, bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            for (a<T> aVar : this.d.get()) {
                aVar.f174a.onNext(t);
            }
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            this.f175a.compareAndSet(this, null);
            a<T>[] andSet = this.d.getAndSet(c);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.f174a.onError(th);
                }
                return;
            }
            a.a.h.a.a(th);
        }

        @Override // a.a.k
        public void onComplete() {
            this.f175a.compareAndSet(this, null);
            for (a<T> aVar : this.d.getAndSet(c)) {
                aVar.f174a.onComplete();
            }
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.d.get();
                if (aVarArr == c) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.d.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.d.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2].equals(aVar)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = b;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.d.compareAndSet(aVarArr, aVarArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<Object> implements a.a.b.b {
        private static final long serialVersionUID = -1100270633763673112L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f174a;

        a(a.a.k<? super T> kVar) {
            this.f174a = kVar;
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return get() == this;
        }

        @Override // a.a.b.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        void a(b<T> bVar) {
            if (compareAndSet(null, bVar)) {
                return;
            }
            bVar.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements a.a.j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<b<T>> f176a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f176a = atomicReference;
        }

        @Override // a.a.j
        public void a(a.a.k<? super T> kVar) {
            a aVar = new a(kVar);
            kVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f176a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.f176a);
                    if (this.f176a.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }
}

package a.a.e.e.b;
/* compiled from: ObservableFromArray.java */
/* loaded from: classes.dex */
public final class h<T> extends a.a.g<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f168a;

    public h(T[] tArr) {
        this.f168a = tArr;
    }

    @Override // a.a.g
    public void b(a.a.k<? super T> kVar) {
        a aVar = new a(kVar, this.f168a);
        kVar.onSubscribe(aVar);
        if (aVar.d) {
            return;
        }
        aVar.a();
    }

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes.dex */
    static final class a<T> extends a.a.e.d.c<T> {

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f169a;
        final T[] b;
        int c;
        boolean d;
        volatile boolean e;

        a(a.a.k<? super T> kVar, T[] tArr) {
            this.f169a = kVar;
            this.b = tArr;
        }

        @Override // a.a.e.c.b
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                this.d = true;
                return 1;
            }
            return 0;
        }

        @Override // a.a.e.c.e
        public T poll() {
            int i = this.c;
            T[] tArr = this.b;
            if (i != tArr.length) {
                this.c = i + 1;
                return (T) a.a.e.b.b.a((Object) tArr[i], "The array element is null");
            }
            return null;
        }

        @Override // a.a.e.c.e
        public boolean isEmpty() {
            return this.c == this.b.length;
        }

        @Override // a.a.e.c.e
        public void clear() {
            this.c = this.b.length;
        }

        @Override // a.a.b.b
        public void dispose() {
            this.e = true;
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return this.e;
        }

        void a() {
            T[] tArr = this.b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.f169a.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.f169a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f169a.onComplete();
        }
    }
}

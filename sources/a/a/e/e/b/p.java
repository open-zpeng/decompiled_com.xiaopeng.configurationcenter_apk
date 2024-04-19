package a.a.e.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes.dex */
public final class p {
    public static <T, R> boolean a(a.a.j<T> jVar, a.a.k<? super R> kVar, a.a.d.f<? super T, ? extends a.a.j<? extends R>> fVar) {
        if (jVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) jVar).call();
                if (obj == 0) {
                    a.a.e.a.d.complete(kVar);
                    return true;
                }
                try {
                    a.a.j jVar2 = (a.a.j) a.a.e.b.b.a(fVar.apply(obj), "The mapper returned a null ObservableSource");
                    if (jVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) jVar2).call();
                            if (call == null) {
                                a.a.e.a.d.complete(kVar);
                                return true;
                            }
                            a aVar = new a(kVar, call);
                            kVar.onSubscribe(aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            a.a.c.b.b(th);
                            a.a.e.a.d.error(th, kVar);
                            return true;
                        }
                    } else {
                        jVar2.a(kVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    a.a.c.b.b(th2);
                    a.a.e.a.d.error(th2, kVar);
                    return true;
                }
            } catch (Throwable th3) {
                a.a.c.b.b(th3);
                a.a.e.a.d.error(th3, kVar);
                return true;
            }
        }
        return false;
    }

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements a.a.e.c.a<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f181a;
        final T b;

        public a(a.a.k<? super T> kVar, T t) {
            this.f181a = kVar;
            this.b = t;
        }

        @Override // a.a.e.c.e
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // a.a.e.c.e
        public T poll() throws Exception {
            if (get() == 1) {
                lazySet(3);
                return this.b;
            }
            return null;
        }

        @Override // a.a.e.c.e
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // a.a.e.c.e
        public void clear() {
            lazySet(3);
        }

        @Override // a.a.b.b
        public void dispose() {
            set(3);
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // a.a.e.c.b
        public int requestFusion(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f181a.onNext((T) this.b);
                if (get() == 2) {
                    lazySet(3);
                    this.f181a.onComplete();
                }
            }
        }
    }
}

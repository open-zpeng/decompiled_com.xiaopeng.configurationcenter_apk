package a.a.e.f;

import a.a.e.c.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes.dex */
public final class a<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<C0006a<T>> f189a = new AtomicReference<>();
    private final AtomicReference<C0006a<T>> b = new AtomicReference<>();

    public a() {
        C0006a<T> c0006a = new C0006a<>();
        b(c0006a);
        a(c0006a);
    }

    @Override // a.a.e.c.e
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        C0006a<T> c0006a = new C0006a<>(t);
        a(c0006a).a(c0006a);
        return true;
    }

    @Override // a.a.e.c.e
    public T poll() {
        C0006a<T> c;
        C0006a<T> c2 = c();
        C0006a<T> c3 = c2.c();
        if (c3 != null) {
            T a2 = c3.a();
            b(c3);
            return a2;
        } else if (c2 != a()) {
            do {
                c = c2.c();
            } while (c == null);
            T a3 = c.a();
            b(c);
            return a3;
        } else {
            return null;
        }
    }

    @Override // a.a.e.c.e
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    C0006a<T> a() {
        return this.f189a.get();
    }

    C0006a<T> a(C0006a<T> c0006a) {
        return this.f189a.getAndSet(c0006a);
    }

    C0006a<T> b() {
        return this.b.get();
    }

    C0006a<T> c() {
        return this.b.get();
    }

    void b(C0006a<T> c0006a) {
        this.b.lazySet(c0006a);
    }

    @Override // a.a.e.c.e
    public boolean isEmpty() {
        return b() == a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: a.a.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0006a<E> extends AtomicReference<C0006a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;

        /* renamed from: a  reason: collision with root package name */
        private E f190a;

        C0006a() {
        }

        C0006a(E e) {
            a((C0006a<E>) e);
        }

        public E a() {
            E b = b();
            a((C0006a<E>) null);
            return b;
        }

        public E b() {
            return this.f190a;
        }

        public void a(E e) {
            this.f190a = e;
        }

        public void a(C0006a<E> c0006a) {
            lazySet(c0006a);
        }

        public C0006a<E> c() {
            return get();
        }
    }
}

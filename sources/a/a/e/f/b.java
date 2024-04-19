package a.a.e.f;

import a.a.e.c.d;
import a.a.e.h.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes.dex */
public final class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f191a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();
    int c;
    long d;
    final int e;
    AtomicReferenceArray<Object> f;
    final int g;
    AtomicReferenceArray<Object> h;
    final AtomicLong b = new AtomicLong();
    final AtomicLong i = new AtomicLong();

    private static int b(int i) {
        return i;
    }

    public b(int i) {
        int a2 = g.a(Math.max(8, i));
        int i2 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f = atomicReferenceArray;
        this.e = i2;
        a(a2);
        this.h = atomicReferenceArray;
        this.g = i2;
        this.d = i2 - 1;
        a(0L);
    }

    @Override // a.a.e.c.e
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f;
        long c = c();
        int i = this.e;
        int a2 = a(c, i);
        if (c < this.d) {
            return a(atomicReferenceArray, t, c, a2);
        }
        long j2 = this.c + c;
        if (b(atomicReferenceArray, a(j2, i)) == null) {
            this.d = j2 - 1;
            return a(atomicReferenceArray, t, c, a2);
        } else if (b(atomicReferenceArray, a(1 + c, i)) == null) {
            return a(atomicReferenceArray, t, c, a2);
        } else {
            a(atomicReferenceArray, c, a2, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i) {
        a(atomicReferenceArray, i, t);
        a(j2 + 1);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f = atomicReferenceArray2;
        this.d = (j3 + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, j);
        a(j2 + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b = b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, b);
        a(atomicReferenceArray, b, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // a.a.e.c.e
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long d = d();
        int i = this.g;
        int a2 = a(d, i);
        T t = (T) b(atomicReferenceArray, a2);
        boolean z = t == j;
        if (t == null || z) {
            if (z) {
                return a(a(atomicReferenceArray, i + 1), d, i);
            }
            return null;
        }
        a(atomicReferenceArray, a2, (Object) null);
        b(d + 1);
        return t;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i) {
        this.h = atomicReferenceArray;
        int a2 = a(j2, i);
        T t = (T) b(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            b(j2 + 1);
        }
        return t;
    }

    @Override // a.a.e.c.e
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // a.a.e.c.e
    public boolean isEmpty() {
        return a() == b();
    }

    private void a(int i) {
        this.c = Math.min(i / 4, f191a);
    }

    private long a() {
        return this.b.get();
    }

    private long b() {
        return this.i.get();
    }

    private long c() {
        return this.b.get();
    }

    private long d() {
        return this.i.get();
    }

    private void a(long j2) {
        this.b.lazySet(j2);
    }

    private void b(long j2) {
        this.i.lazySet(j2);
    }

    private static int a(long j2, int i) {
        return b(((int) j2) & i);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}

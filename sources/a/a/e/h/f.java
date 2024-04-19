package a.a.e.h;
/* compiled from: OpenHashSet.java */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f219a;
    int b;
    int c;
    int d;
    T[] e;

    static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public f() {
        this(16, 0.75f);
    }

    public f(int i, float f) {
        this.f219a = f;
        int a2 = g.a(i);
        this.b = a2 - 1;
        this.d = (int) (f * a2);
        this.e = (T[]) new Object[a2];
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a2 = (a2 + 1) & i;
                t2 = tArr[a2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a2] = t;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            a();
        }
        return true;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.e;
        int i = this.b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(a2, tArr, i);
        }
        do {
            a2 = (a2 + 1) & i;
            t2 = tArr[a2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(a2, tArr, i);
    }

    boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a2 = a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a2 && a2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < a2 && a2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void a() {
        T[] tArr = this.e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a2 = a(tArr[length].hashCode()) & i2;
                if (tArr2[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i2;
                    } while (tArr2[a2] != null);
                }
                tArr2[a2] = tArr[length];
                i3 = i4;
            } else {
                this.b = i2;
                this.d = (int) (i * this.f219a);
                this.e = tArr2;
                return;
            }
        }
    }

    public Object[] b() {
        return this.e;
    }
}

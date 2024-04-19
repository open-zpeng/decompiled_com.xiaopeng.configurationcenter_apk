package org.b.a.b;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class e {
    static final boolean g;
    static Class h;

    /* renamed from: a  reason: collision with root package name */
    private final int f1401a;
    private final int b;
    final int c;
    final int d;
    final byte[] e;
    int f = -1;
    private int i = -1;
    private boolean j = false;
    private int k = 0;
    private int l = 0;

    static {
        if (h == null) {
            h = b("org.b.a.b.e");
        }
        g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, int i2, int i3, int i4, int i5) {
        this.e = new byte[a(i, i2, i3, i5)];
        this.f1401a = i2 + i;
        this.b = i3 + i5;
        this.c = i5;
        this.d = i4;
    }

    private static int a(int i, int i2, int i3, int i4) {
        return i2 + i + i3 + i4 + Math.min((i / 2) + 262144, 536870912);
    }

    public static e a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i6 != 4) {
            if (i6 == 20) {
                return new a(i, i2, i3, i4, i5, i7);
            }
            throw new IllegalArgumentException();
        }
        return new c(i, i2, i3, i4, i5, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] <= i) {
                iArr[i2] = 0;
            } else {
                iArr[i2] = iArr[i2] - i;
            }
        }
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void g() {
        int i = ((this.f + 1) - this.f1401a) & (-16);
        byte[] bArr = this.e;
        System.arraycopy(bArr, i, bArr, 0, this.k - i);
        this.f -= i;
        this.i -= i;
        this.k -= i;
    }

    private void h() {
        int i;
        int i2 = this.l;
        if (i2 <= 0 || (i = this.f) >= this.i) {
            return;
        }
        this.f = i - i2;
        this.l = 0;
        a(i2);
        if (!g && this.l >= i2) {
            throw new AssertionError();
        }
    }

    public int a(int i, int i2) {
        return this.e[(this.f + i) - i2] & 255;
    }

    public int a(int i, int i2, int i3) {
        int i4 = this.f + i;
        int i5 = (i4 - i2) - 1;
        int i6 = 0;
        while (i6 < i3) {
            byte[] bArr = this.e;
            if (bArr[i4 + i6] != bArr[i5 + i6]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public int a(byte[] bArr, int i, int i2) {
        if (g || !this.j) {
            if (this.f >= this.e.length - this.b) {
                g();
            }
            byte[] bArr2 = this.e;
            int length = bArr2.length;
            int i3 = this.k;
            if (i2 > length - i3) {
                i2 = bArr2.length - i3;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            int i4 = this.k + i2;
            this.k = i4;
            int i5 = this.b;
            if (i4 >= i5) {
                this.i = i4 - i5;
            }
            h();
            return i2;
        }
        throw new AssertionError();
    }

    public abstract f a();

    public abstract void a(int i);

    public void a(int i, byte[] bArr) {
        boolean z = g;
        if (!z && b()) {
            throw new AssertionError();
        }
        if (!z && this.k != 0) {
            throw new AssertionError();
        }
        if (bArr != null) {
            int min = Math.min(bArr.length, i);
            System.arraycopy(bArr, bArr.length - min, this.e, 0, min);
            this.k += min;
            a(min);
        }
    }

    public void a(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.e, (this.f + 1) - i, i2);
    }

    public boolean a(f fVar) {
        int min = Math.min(e(), this.c);
        for (int i = 0; i < fVar.c; i++) {
            if (b(fVar.b[i], min) != fVar.f1402a[i]) {
                return false;
            }
        }
        return true;
    }

    public int b(int i, int i2) {
        int i3 = (this.f - i) - 1;
        int i4 = 0;
        while (i4 < i2) {
            byte[] bArr = this.e;
            if (bArr[this.f + i4] != bArr[i3 + i4]) {
                break;
            }
            i4++;
        }
        return i4;
    }

    public boolean b() {
        return this.f != -1;
    }

    public boolean b(int i) {
        return this.f - i < this.i;
    }

    public int c(int i) {
        return this.e[this.f - i] & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i, int i2) {
        if (g || i >= i2) {
            int i3 = this.f + 1;
            this.f = i3;
            int i4 = this.k - i3;
            if (i4 < i) {
                if (i4 < i2 || !this.j) {
                    this.l++;
                    return 0;
                }
                return i4;
            }
            return i4;
        }
        throw new AssertionError();
    }

    public void c() {
        this.i = this.k - 1;
        h();
    }

    public void d() {
        this.i = this.k - 1;
        this.j = true;
        h();
    }

    public int e() {
        if (g || b()) {
            return this.k - this.f;
        }
        throw new AssertionError();
    }

    public int f() {
        return this.f;
    }
}

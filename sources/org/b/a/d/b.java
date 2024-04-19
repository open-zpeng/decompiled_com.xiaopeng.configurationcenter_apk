package org.b.a.d;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1412a;
    static Class b;
    private static final int[] c;
    private long d;
    private int e;
    private int f;
    private byte g;
    private final byte[] h;
    private int i;

    static {
        if (b == null) {
            b = a("org.b.a.d.b");
        }
        f1412a = true;
        c = new int[128];
        for (int i = 8; i < 2048; i += 16) {
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < 4; i4++) {
                i2 *= i2;
                i3 <<= 1;
                while (((-65536) & i2) != 0) {
                    i2 >>>= 1;
                    i3++;
                }
            }
            c[i >> 4] = 161 - i3;
        }
    }

    public b(int i) {
        this.h = new byte[i];
        a();
    }

    public static int a(int i) {
        return i << 4;
    }

    public static int a(int i, int i2) {
        if (f1412a || i2 == 0 || i2 == 1) {
            return c[(i ^ ((-i2) & 2047)) >>> 4];
        }
        throw new AssertionError();
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static int b(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        do {
            int i3 = length & 1;
            length >>>= 1;
            i2 += a(sArr[length], i3);
        } while (length != 1);
        return i2;
    }

    public static int d(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 0;
        int i3 = 1;
        do {
            int i4 = length & 1;
            length >>>= 1;
            i2 += a(sArr[i3], i4);
            i3 = (i3 << 1) | i4;
        } while (length != 1);
        return i2;
    }

    private void d() {
        int i;
        long j = this.d;
        int i2 = (int) (j >>> 32);
        if (i2 != 0 || j < 4278190080L) {
            byte b2 = this.g;
            do {
                byte[] bArr = this.h;
                int i3 = this.i;
                this.i = i3 + 1;
                bArr[i3] = (byte) (b2 + i2);
                b2 = 255;
                i = this.f - 1;
                this.f = i;
            } while (i != 0);
            this.g = (byte) (this.d >>> 24);
        }
        this.f++;
        this.d = (this.d & 16777215) << 8;
    }

    public void a() {
        this.d = 0L;
        this.e = -1;
        this.g = (byte) 0;
        this.f = 1;
        this.i = 0;
    }

    public void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.h, 0, this.i);
    }

    public void a(short[] sArr, int i) {
        int length = sArr.length;
        int i2 = 1;
        do {
            length >>>= 1;
            int i3 = i & length;
            a(sArr, i2, i3);
            i2 <<= 1;
            if (i3 != 0) {
                i2 |= 1;
                continue;
            }
        } while (length != 1);
    }

    public void a(short[] sArr, int i, int i2) {
        short s = sArr[i];
        int i3 = this.e;
        int i4 = (i3 >>> 11) * s;
        if (i2 == 0) {
            this.e = i4;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
        } else {
            this.d += i4 & 4294967295L;
            this.e = i3 - i4;
            sArr[i] = (short) (s - (s >>> 5));
        }
        int i5 = this.e;
        if (((-16777216) & i5) == 0) {
            this.e = i5 << 8;
            d();
        }
    }

    public int b() {
        return ((this.i + this.f) + 5) - 1;
    }

    public void b(int i, int i2) {
        do {
            int i3 = this.e >>> 1;
            this.e = i3;
            i2--;
            this.d += (0 - ((i >>> i2) & 1)) & i3;
            if (((-16777216) & i3) == 0) {
                this.e = i3 << 8;
                d();
                continue;
            }
        } while (i2 != 0);
    }

    public int c() {
        for (int i = 0; i < 5; i++) {
            d();
        }
        return this.i;
    }

    public void c(short[] sArr, int i) {
        int length = i | sArr.length;
        int i2 = 1;
        do {
            int i3 = length & 1;
            length >>>= 1;
            a(sArr, i2, i3);
            i2 = (i2 << 1) | i3;
        } while (length != 1);
    }
}

package org.b.a.c;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.lang.reflect.Array;
import org.b.a.c.a;
/* loaded from: classes.dex */
public abstract class b extends org.b.a.c.a {
    static final boolean t;
    static Class u;
    private final int[][] A;
    private final int[] B;
    private int C;
    final org.b.a.b.e m;
    final C0102b n;
    final a o;
    final a p;
    final int q;
    int r;
    int s;
    private final org.b.a.d.b v;
    private int w;
    private int x;
    private final int y;
    private final int[][] z;

    /* renamed from: org.b.a.c.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends a.AbstractC0100a {
        private final int[] e;
        private final int[][] f;
        private final b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b bVar, int i, int i2) {
            super(bVar);
            this.g = bVar;
            int i3 = 1 << i;
            this.e = new int[i3];
            this.f = (int[][]) Array.newInstance(int.class, i3, Math.max((i2 - 2) + 1, 16));
        }

        private void a(int i) {
            int a2 = org.b.a.d.b.a(this.f1405a[0], 0);
            int i2 = 0;
            while (i2 < 8) {
                this.f[i][i2] = org.b.a.d.b.b(this.b[i], i2) + a2;
                i2++;
            }
            int a3 = org.b.a.d.b.a(this.f1405a[0], 1);
            int a4 = org.b.a.d.b.a(this.f1405a[1], 0);
            while (i2 < 16) {
                this.f[i][i2] = a3 + a4 + org.b.a.d.b.b(this.c[i], i2 - 8);
                i2++;
            }
            int a5 = org.b.a.d.b.a(this.f1405a[1], 1);
            while (true) {
                int[][] iArr = this.f;
                if (i2 >= iArr[i].length) {
                    return;
                }
                iArr[i][i2] = a3 + a5 + org.b.a.d.b.b(this.d, (i2 - 8) - 8);
                i2++;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.b.a.c.a.AbstractC0100a
        public void a() {
            super.a();
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }

        void a(int i, int i2) {
            int i3 = i - 2;
            if (i3 < 8) {
                b.a(this.g).a(this.f1405a, 0, 0);
                b.a(this.g).a(this.b[i2], i3);
            } else {
                b.a(this.g).a(this.f1405a, 0, 1);
                int i4 = i3 - 8;
                if (i4 < 8) {
                    b.a(this.g).a(this.f1405a, 1, 0);
                    b.a(this.g).a(this.c[i2], i4);
                } else {
                    b.a(this.g).a(this.f1405a, 1, 1);
                    b.a(this.g).a(this.d, i4 - 8);
                }
            }
            int[] iArr = this.e;
            iArr[i2] = iArr[i2] - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int i, int i2) {
            return this.f[i2][i - 2];
        }

        void b() {
            int i = 0;
            while (true) {
                int[] iArr = this.e;
                if (i >= iArr.length) {
                    return;
                }
                if (iArr[i] <= 0) {
                    iArr[i] = 32;
                    a(i);
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.b.a.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0102b extends a.b {
        static final boolean b;

        /* renamed from: a  reason: collision with root package name */
        a[] f1408a;
        private final b c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: org.b.a.c.b$b$a */
        /* loaded from: classes.dex */
        public class a extends a.b.AbstractC0101a {
            private final C0102b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private a(C0102b c0102b) {
                super(c0102b);
                this.b = c0102b;
            }

            a(C0102b c0102b, AnonymousClass1 anonymousClass1) {
                this(c0102b);
            }

            int a(int i) {
                int i2 = i | IRadioController.TEF663x_PCHANNEL;
                int i3 = 0;
                do {
                    i3 += org.b.a.d.b.a(this.f1407a[i2 >>> 8], (i2 >>> 7) & 1);
                    i2 <<= 1;
                } while (i2 < 65536);
                return i3;
            }

            int a(int i, int i2) {
                int i3 = IRadioController.TEF663x_PCHANNEL;
                int i4 = i | IRadioController.TEF663x_PCHANNEL;
                int i5 = 0;
                do {
                    i2 <<= 1;
                    i5 += org.b.a.d.b.a(this.f1407a[(i2 & i3) + i3 + (i4 >>> 8)], (i4 >>> 7) & 1);
                    i4 <<= 1;
                    i3 &= ~(i2 ^ i4);
                } while (i4 < 65536);
                return i5;
            }

            void b() {
                int c = C0102b.a(this.b).m.c(C0102b.a(this.b).s);
                int i = IRadioController.TEF663x_PCHANNEL;
                int i2 = c | IRadioController.TEF663x_PCHANNEL;
                if (C0102b.a(this.b).c.g()) {
                    do {
                        b.a(C0102b.a(this.b)).a(this.f1407a, i2 >>> 8, (i2 >>> 7) & 1);
                        i2 <<= 1;
                    } while (i2 < 65536);
                } else {
                    int c2 = C0102b.a(this.b).m.c(C0102b.a(this.b).b[0] + 1 + C0102b.a(this.b).s);
                    do {
                        c2 <<= 1;
                        b.a(C0102b.a(this.b)).a(this.f1407a, (c2 & i) + i + (i2 >>> 8), (i2 >>> 7) & 1);
                        i2 <<= 1;
                        i &= ~(c2 ^ i2);
                    } while (i2 < 65536);
                }
                C0102b.a(this.b).c.c();
            }
        }

        static {
            if (b.u == null) {
                b.u = b.a("org.b.a.c.b");
            } else {
                Class cls = b.u;
            }
            b = true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0102b(b bVar, int i, int i2) {
            super(bVar, i, i2);
            this.c = bVar;
            this.f1408a = new a[1 << (i + i2)];
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.f1408a;
                if (i3 >= aVarArr.length) {
                    return;
                }
                aVarArr[i3] = new a(this, null);
                i3++;
            }
        }

        static b a(C0102b c0102b) {
            return c0102b.c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int i, int i2, int i3, int i4, f fVar) {
            int a2 = org.b.a.d.b.a(this.c.d[fVar.b()][this.c.f1404a & i4], 0);
            int a3 = a(i3, i4);
            return a2 + (fVar.g() ? this.f1408a[a3].a(i) : this.f1408a[a3].a(i, i2));
        }

        void a() {
            int i = 0;
            while (true) {
                a[] aVarArr = this.f1408a;
                if (i >= aVarArr.length) {
                    return;
                }
                aVarArr[i].a();
                i++;
            }
        }

        void b() {
            if (!b && this.c.s < 0) {
                throw new AssertionError();
            }
            this.f1408a[0].b();
        }

        void c() {
            if (!b && this.c.s < 0) {
                throw new AssertionError();
            }
            this.f1408a[a(this.c.m.c(this.c.s + 1), this.c.m.f() - this.c.s)].b();
        }
    }

    static {
        if (u == null) {
            u = a("org.b.a.c.b");
        }
        t = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(org.b.a.d.b bVar, org.b.a.b.e eVar, int i, int i2, int i3, int i4, int i5) {
        super(i3);
        this.w = 0;
        this.x = 0;
        this.A = (int[][]) Array.newInstance(int.class, 4, 128);
        this.B = new int[16];
        this.r = 0;
        this.s = -1;
        this.C = 0;
        this.v = bVar;
        this.m = eVar;
        this.q = i5;
        this.n = new C0102b(this, i, i2);
        this.o = new a(this, i3, i5);
        this.p = new a(this, i3, i5);
        int b = b(i4 - 1) + 1;
        this.y = b;
        this.z = (int[][]) Array.newInstance(int.class, 4, b);
        a();
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static b a(org.b.a.d.b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 != 1) {
            if (i4 == 2) {
                return new d(bVar, i, i2, i3, i5, i6, i7, i8, i9);
            }
            throw new IllegalArgumentException();
        }
        return new c(bVar, i, i2, i3, i5, i6, i7, i8, i9);
    }

    static org.b.a.d.b a(b bVar) {
        return bVar.v;
    }

    private void a(int i, int i2, int i3) {
        this.c.d();
        this.o.a(i2, i3);
        int b = b(i);
        this.v.a(this.j[a(i2)], b);
        if (b >= 4) {
            int i4 = (b >>> 1) - 1;
            int i5 = i - (((b & 1) | 2) << i4);
            if (b < 14) {
                this.v.c(this.k[b - 4], i5);
            } else {
                this.v.b(i5 >>> 4, i4 - 4);
                this.v.c(this.l, i5 & 15);
                this.x--;
            }
        }
        this.b[3] = this.b[2];
        this.b[2] = this.b[1];
        this.b[1] = this.b[0];
        this.b[0] = i;
        this.w--;
    }

    public static int b(int i) {
        int i2;
        int i3;
        if (i <= 4) {
            return i;
        }
        if (((-65536) & i) == 0) {
            i3 = i << 16;
            i2 = 15;
        } else {
            i2 = 31;
            i3 = i;
        }
        if (((-16777216) & i3) == 0) {
            i3 <<= 8;
            i2 -= 8;
        }
        if (((-268435456) & i3) == 0) {
            i3 <<= 4;
            i2 -= 4;
        }
        if (((-1073741824) & i3) == 0) {
            i3 <<= 2;
            i2 -= 2;
        }
        if ((i3 & Integer.MIN_VALUE) == 0) {
            i2--;
        }
        return (i2 << 1) + ((i >>> (i2 - 1)) & 1);
    }

    private void b(int i, int i2, int i3) {
        if (i == 0) {
            this.v.a(this.f, this.c.b(), 0);
            this.v.a(this.i[this.c.b()], i3, i2 != 1 ? 1 : 0);
        } else {
            int i4 = this.b[i];
            this.v.a(this.f, this.c.b(), 1);
            if (i == 1) {
                this.v.a(this.g, this.c.b(), 0);
            } else {
                this.v.a(this.g, this.c.b(), 1);
                this.v.a(this.h, this.c.b(), i - 2);
                if (i == 3) {
                    this.b[3] = this.b[2];
                }
                this.b[2] = this.b[1];
            }
            this.b[1] = this.b[0];
            this.b[0] = i4;
        }
        if (i2 == 1) {
            this.c.f();
            return;
        }
        this.p.a(i2, i3);
        this.c.e();
    }

    private boolean i() {
        boolean z = t;
        if (z || this.s == -1) {
            if (this.m.b(0)) {
                c(1);
                this.v.a(this.d[this.c.b()], 0, 0);
                this.n.b();
                int i = this.s - 1;
                this.s = i;
                if (z || i == -1) {
                    int i2 = this.C + 1;
                    this.C = i2;
                    if (z || i2 == 1) {
                        return true;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            return false;
        }
        throw new AssertionError();
    }

    private boolean j() {
        if (this.m.b(this.s + 1)) {
            int b = b();
            boolean z = t;
            if (z || this.s >= 0) {
                int f = (this.m.f() - this.s) & this.f1404a;
                if (this.r != -1) {
                    this.v.a(this.d[this.c.b()], f, 1);
                    int i = this.r;
                    if (i < 4) {
                        if (!z && this.m.a(-this.s, this.b[this.r], b) != b) {
                            throw new AssertionError();
                        }
                        this.v.a(this.e, this.c.b(), 1);
                        b(this.r, b, f);
                    } else if (!z && this.m.a(-this.s, i - 4, b) != b) {
                        throw new AssertionError();
                    } else {
                        this.v.a(this.e, this.c.b(), 0);
                        a(this.r - 4, b, f);
                    }
                } else if (!z && b != 1) {
                    throw new AssertionError();
                } else {
                    this.v.a(this.d[this.c.b()], f, 0);
                    this.n.c();
                }
                this.s -= b;
                this.C += b;
                return true;
            }
            throw new AssertionError();
        }
        return false;
    }

    private void k() {
        this.w = 128;
        int i = 0;
        while (true) {
            if (i >= 4) {
                break;
            }
            for (int i2 = 0; i2 < this.y; i2++) {
                this.z[i][i2] = org.b.a.d.b.b(this.j[i], i2);
            }
            for (int i3 = 14; i3 < this.y; i3++) {
                int[] iArr = this.z[i];
                iArr[i3] = iArr[i3] + org.b.a.d.b.a(((i3 >>> 1) - 1) - 4);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                this.A[i][i4] = this.z[i][i4];
            }
            i++;
        }
        int i5 = 4;
        for (int i6 = 4; i6 < 14; i6++) {
            int i7 = ((i6 & 1) | 2) << ((i6 >>> 1) - 1);
            int i8 = i6 - 4;
            int length = this.k[i8].length;
            for (int i9 = 0; i9 < length; i9++) {
                int d = org.b.a.d.b.d(this.k[i8], i5 - i7);
                for (int i10 = 0; i10 < 4; i10++) {
                    this.A[i10][i5] = this.z[i10][i6] + d;
                }
                i5++;
            }
        }
        if (!t && i5 != 128) {
            throw new AssertionError();
        }
    }

    private void l() {
        this.x = 16;
        for (int i = 0; i < 16; i++) {
            this.B[i] = org.b.a.d.b.d(this.l, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3, int i4) {
        int b = i + this.o.b(i3, i4);
        int a2 = a(i3);
        if (i2 < 128) {
            return b + this.A[a2][i2];
        }
        return b + this.z[a2][b(i2)] + this.B[i2 & 15];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, f fVar, int i3) {
        int a2;
        if (i2 == 0) {
            a2 = org.b.a.d.b.a(this.f[fVar.b()], 0) + org.b.a.d.b.a(this.i[fVar.b()][i3], 1);
        } else {
            i += org.b.a.d.b.a(this.f[fVar.b()], 1);
            if (i2 != 1) {
                return i + org.b.a.d.b.a(this.g[fVar.b()], 1) + org.b.a.d.b.a(this.h[fVar.b()], i2 - 2);
            }
            a2 = org.b.a.d.b.a(this.g[fVar.b()], 0);
        }
        return i + a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, f fVar) {
        return i + org.b.a.d.b.a(this.e[fVar.b()], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, f fVar, int i2) {
        return i + org.b.a.d.b.a(this.f[fVar.b()], 0) + org.b.a.d.b.a(this.i[fVar.b()][i2], 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(f fVar, int i) {
        return org.b.a.d.b.a(this.d[fVar.b()][i], 1);
    }

    @Override // org.b.a.c.a
    public void a() {
        super.a();
        this.n.a();
        this.o.a();
        this.p.a();
        this.w = 0;
        this.x = 0;
        this.C += this.s + 1;
        this.s = -1;
    }

    abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, int i2, f fVar, int i3) {
        return a(b(a(fVar, i3), fVar), i, fVar, i3) + this.p.b(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i, f fVar) {
        return i + org.b.a.d.b.a(this.e[fVar.b()], 1);
    }

    public org.b.a.b.e c() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        this.s += i;
        this.m.a(i);
    }

    public int d() {
        return this.C;
    }

    public void e() {
        this.C = 0;
    }

    public boolean f() {
        if (this.m.b() || i()) {
            while (this.C <= 2096879 && this.v.b() <= 65510) {
                if (!j()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public org.b.a.b.f g() {
        this.s++;
        org.b.a.b.f a2 = this.m.a();
        if (t || this.m.a(a2)) {
            return a2;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (this.w <= 0) {
            k();
        }
        if (this.x <= 0) {
            l();
        }
        this.o.b();
        this.p.b();
    }
}

package org.b.a.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends b {
    static final boolean v;
    static Class w;
    private static int x;
    private static int y;
    private int A;
    private int B;
    private org.b.a.b.f C;
    private final int[] D;
    private final f E;
    private final e[] z;

    static {
        if (w == null) {
            w = b("org.b.a.c.d");
        }
        v = true;
        x = 4096;
        y = 4096;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(org.b.a.d.b bVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(bVar, org.b.a.b.e.a(i4, Math.max(i5, x), y, i6, 273, i7, i8), i, i2, i3, i4, i6);
        this.z = new e[4096];
        this.A = 0;
        this.B = 0;
        this.D = new int[4];
        this.E = new f();
        for (int i9 = 0; i9 < 4096; i9++) {
            this.z[i9] = new e();
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i5;
        if (this.C.f1402a[this.C.c - 1] > i3) {
            this.C.c = 0;
            while (this.C.f1402a[this.C.c] < i3) {
                this.C.c++;
            }
            int[] iArr = this.C.f1402a;
            org.b.a.b.f fVar = this.C;
            int i7 = fVar.c;
            fVar.c = i7 + 1;
            iArr[i7] = i3;
        }
        if (this.C.f1402a[this.C.c - 1] < i6) {
            return;
        }
        while (this.B < this.A + this.C.f1402a[this.C.c - 1]) {
            e[] eVarArr = this.z;
            int i8 = this.B + 1;
            this.B = i8;
            eVarArr[i8].a();
        }
        int a2 = a(i4, this.z[this.A].f1409a);
        int i9 = 0;
        while (i6 > this.C.f1402a[i9]) {
            i9++;
        }
        while (true) {
            int i10 = this.C.b[i9];
            int a3 = a(a2, i10, i6, i2);
            if (a3 < this.z[this.A + i6].c) {
                e[] eVarArr2 = this.z;
                int i11 = this.A;
                eVarArr2[i11 + i6].a(a3, i11, i10 + 4);
            }
            if (i6 == this.C.f1402a[i9]) {
                int a4 = this.m.a(i6 + 1, i10, Math.min(this.q, (i3 - i6) - 1));
                if (a4 >= 2) {
                    this.E.a(this.z[this.A].f1409a);
                    this.E.d();
                    int i12 = i + i6;
                    int a5 = a3 + this.n.a(this.m.a(i6, 0), this.m.c(0), this.m.a(i6, 1), i12, this.E);
                    this.E.c();
                    int b = a5 + b(0, a4, this.E, (i12 + 1) & this.f1404a);
                    int i13 = this.A + i6 + 1 + a4;
                    while (true) {
                        int i14 = this.B;
                        if (i14 >= i13) {
                            break;
                        }
                        e[] eVarArr3 = this.z;
                        int i15 = i14 + 1;
                        this.B = i15;
                        eVarArr3[i15].a();
                    }
                    if (b < this.z[i13].c) {
                        this.z[i13].a(b, this.A, i10 + 4, i6, 0);
                    }
                }
                i9++;
                if (i9 == this.C.c) {
                    return;
                }
            }
            i6++;
        }
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        boolean z;
        int a2;
        int c = this.m.c(0);
        int c2 = this.m.c(this.z[this.A].b[0] + 1);
        int a3 = this.z[this.A].c + this.n.a(c, c2, this.m.c(1), i, this.z[this.A].f1409a);
        if (a3 < this.z[this.A + 1].c) {
            e[] eVarArr = this.z;
            int i5 = this.A;
            eVarArr[i5 + 1].a(a3, i5, -1);
            z = true;
        } else {
            z = false;
        }
        if (c2 == c) {
            int i6 = this.z[this.A + 1].d;
            int i7 = this.A;
            if ((i6 == i7 || this.z[i7 + 1].e != 0) && (a2 = a(i4, this.z[this.A].f1409a, i2)) <= this.z[this.A + 1].c) {
                e[] eVarArr2 = this.z;
                int i8 = this.A;
                eVarArr2[i8 + 1].a(a2, i8, 0);
                z = true;
            }
        }
        if (z || c2 == c || i3 <= 2) {
            return;
        }
        int a4 = this.m.a(1, this.z[this.A].b[0], Math.min(this.q, i3 - 1));
        if (a4 >= 2) {
            this.E.a(this.z[this.A].f1409a);
            this.E.c();
            int b = a3 + b(0, a4, this.E, (i + 1) & this.f1404a);
            int i9 = this.A + 1 + a4;
            while (true) {
                int i10 = this.B;
                if (i10 >= i9) {
                    break;
                }
                e[] eVarArr3 = this.z;
                int i11 = i10 + 1;
                this.B = i11;
                eVarArr3[i11].a();
            }
            if (b < this.z[i9].c) {
                this.z[i9].b(b, this.A, 0);
            }
        }
    }

    private int c(int i, int i2, int i3, int i4) {
        int i5;
        int min = Math.min(i3, this.q);
        int i6 = 2;
        for (int i7 = 0; i7 < 4; i7++) {
            int b = this.m.b(this.z[this.A].b[i7], min);
            if (b >= 2) {
                while (true) {
                    int i8 = this.B;
                    i5 = this.A;
                    if (i8 >= i5 + b) {
                        break;
                    }
                    e[] eVarArr = this.z;
                    int i9 = i8 + 1;
                    this.B = i9;
                    eVarArr[i9].a();
                }
                int a2 = a(i4, i7, this.z[i5].f1409a, i2);
                for (int i10 = b; i10 >= 2; i10--) {
                    int b2 = this.p.b(i10, i2) + a2;
                    if (b2 < this.z[this.A + i10].c) {
                        e[] eVarArr2 = this.z;
                        int i11 = this.A;
                        eVarArr2[i11 + i10].a(b2, i11, i7);
                    }
                }
                if (i7 == 0) {
                    i6 = b + 1;
                }
                int i12 = i6;
                int a3 = this.m.a(b + 1, this.z[this.A].b[i7], Math.min(this.q, (i3 - b) - 1));
                if (a3 >= 2) {
                    int b3 = a2 + this.p.b(b, i2);
                    this.E.a(this.z[this.A].f1409a);
                    this.E.e();
                    int i13 = i + b;
                    int a4 = b3 + this.n.a(this.m.a(b, 0), this.m.c(0), this.m.a(b, 1), i13, this.E);
                    this.E.c();
                    int b4 = a4 + b(0, a3, this.E, (i13 + 1) & this.f1404a);
                    int i14 = this.A + b + 1 + a3;
                    while (true) {
                        int i15 = this.B;
                        if (i15 >= i14) {
                            break;
                        }
                        e[] eVarArr3 = this.z;
                        int i16 = i15 + 1;
                        this.B = i16;
                        eVarArr3[i16].a();
                    }
                    if (b4 < this.z[i14].c) {
                        this.z[i14].a(b4, this.A, i7, b, 0);
                    }
                }
                i6 = i12;
            }
        }
        return i6;
    }

    private int i() {
        int i = this.A;
        this.B = i;
        int i2 = this.z[i].d;
        while (true) {
            e eVar = this.z[this.A];
            if (eVar.f) {
                this.z[i2].d = this.A;
                this.z[i2].e = -1;
                int i3 = i2 - 1;
                this.A = i2;
                if (eVar.g) {
                    this.z[i3].d = i3 + 1;
                    this.z[i3].e = eVar.i;
                    this.A = i3;
                    i2 = eVar.h;
                } else {
                    i2 = i3;
                }
            }
            int i4 = this.z[i2].d;
            this.z[i2].d = this.A;
            this.A = i2;
            if (i2 <= 0) {
                int i5 = this.z[0].d;
                this.A = i5;
                this.r = this.z[i5].e;
                return this.A;
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.b.a.c.d.j():void");
    }

    @Override // org.b.a.c.b, org.b.a.c.a
    public void a() {
        this.A = 0;
        this.B = 0;
        super.a();
    }

    @Override // org.b.a.c.b
    int b() {
        int i;
        int a2;
        int i2 = this.A;
        int i3 = this.B;
        if (i2 < i3) {
            int i4 = this.z[i2].d;
            int i5 = this.A;
            int i6 = i4 - i5;
            int i7 = this.z[i5].d;
            this.A = i7;
            this.r = this.z[i7].e;
            return i6;
        } else if (v || i2 == i3) {
            this.A = 0;
            this.B = 0;
            this.r = -1;
            if (this.s == -1) {
                this.C = g();
            }
            int min = Math.min(this.m.e(), 273);
            if (min < 2) {
                return 1;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < 4; i9++) {
                this.D[i9] = this.m.b(this.b[i9], min);
                int[] iArr = this.D;
                if (iArr[i9] < 2) {
                    iArr[i9] = 0;
                } else if (iArr[i9] > iArr[i8]) {
                    i8 = i9;
                }
            }
            if (this.D[i8] >= this.q) {
                this.r = i8;
                c(this.D[i8] - 1);
                return this.D[i8];
            }
            if (this.C.c > 0) {
                i = this.C.f1402a[this.C.c - 1];
                int i10 = this.C.b[this.C.c - 1];
                if (i >= this.q) {
                    this.r = i10 + 4;
                    c(i - 1);
                    return i;
                }
            } else {
                i = 0;
            }
            int c = this.m.c(0);
            int c2 = this.m.c(this.b[0] + 1);
            if (i >= 2 || c == c2 || this.D[i8] >= 2) {
                int f = this.m.f();
                int i11 = f & this.f1404a;
                this.z[1].a(this.n.a(c, c2, this.m.c(1), f, this.c), 0, -1);
                int a3 = a(this.c, i11);
                int b = b(a3, this.c);
                if (c2 == c && (a2 = a(b, this.c, i11)) < this.z[1].c) {
                    this.z[1].a(a2, 0, 0);
                }
                int max = Math.max(i, this.D[i8]);
                this.B = max;
                if (max < 2) {
                    if (v || max == 0) {
                        this.r = this.z[1].e;
                        return 1;
                    }
                    throw new AssertionError(this.B);
                }
                h();
                this.z[0].f1409a.a(this.c);
                System.arraycopy(this.b, 0, this.z[0].b, 0, 4);
                for (int i12 = this.B; i12 >= 2; i12--) {
                    this.z[i12].a();
                }
                for (int i13 = 0; i13 < 4; i13++) {
                    int i14 = this.D[i13];
                    if (i14 >= 2) {
                        int a4 = a(b, i13, this.c, i11);
                        do {
                            int b2 = this.p.b(i14, i11) + a4;
                            if (b2 < this.z[i14].c) {
                                this.z[i14].a(b2, 0, i13);
                            }
                            i14--;
                        } while (i14 >= 2);
                    }
                }
                int max2 = Math.max(this.D[0] + 1, 2);
                if (max2 <= i) {
                    int a5 = a(a3, this.c);
                    int i15 = 0;
                    while (max2 > this.C.f1402a[i15]) {
                        i15++;
                    }
                    while (true) {
                        int i16 = this.C.b[i15];
                        int a6 = a(a5, i16, max2, i11);
                        if (a6 < this.z[max2].c) {
                            this.z[max2].a(a6, 0, i16 + 4);
                        }
                        if (max2 == this.C.f1402a[i15] && (i15 = i15 + 1) == this.C.c) {
                            break;
                        }
                        max2++;
                    }
                }
                int min2 = Math.min(this.m.e(), 4095);
                while (true) {
                    int i17 = this.A + 1;
                    this.A = i17;
                    if (i17 >= this.B) {
                        break;
                    }
                    org.b.a.b.f g = g();
                    this.C = g;
                    if (g.c > 0 && this.C.f1402a[this.C.c - 1] >= this.q) {
                        break;
                    }
                    int i18 = min2 - 1;
                    int i19 = f + 1;
                    int i20 = i19 & this.f1404a;
                    j();
                    int a7 = this.z[this.A].c + a(this.z[this.A].f1409a, i20);
                    int b3 = b(a7, this.z[this.A].f1409a);
                    b(i19, i20, i18, b3);
                    if (i18 >= 2) {
                        int c3 = c(i19, i20, i18, b3);
                        if (this.C.c > 0) {
                            a(i19, i20, i18, a7, c3);
                        }
                    }
                    min2 = i18;
                    f = i19;
                }
                return i();
            }
            return 1;
        } else {
            throw new AssertionError();
        }
    }
}

package org.b.a.b;
/* loaded from: classes.dex */
final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private final d f1398a;
    private final int[] b;
    private final f i;
    private final int j;
    private final int k;
    private int l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.l = -1;
        int i7 = i + 1;
        this.k = i7;
        this.m = i7;
        this.f1398a = new d(i);
        this.b = new int[i7 * 2];
        this.i = new f(i4 - 1);
        this.j = i6 <= 0 ? (i4 / 2) + 16 : i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
        r13 = r12.b;
        r13[r2] = 0;
        r13[r1] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(int r13, int r14) {
        /*
            r12 = this;
            int r0 = r12.j
            int r1 = r12.l
            int r2 = r1 << 1
            int r2 = r2 + 1
            int r1 = r1 << 1
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            int r6 = r12.m
            int r6 = r6 - r14
            int r7 = r0 + (-1)
            if (r0 == 0) goto L86
            int r0 = r12.k
            if (r6 < r0) goto L1a
            goto L86
        L1a:
            int r8 = r12.l
            int r9 = r8 - r6
            if (r6 <= r8) goto L21
            goto L22
        L21:
            r0 = r3
        L22:
            int r9 = r9 + r0
            int r0 = r9 << 1
            int r8 = java.lang.Math.min(r4, r5)
            byte[] r9 = r12.e
            int r10 = r12.f
            int r10 = r10 + r8
            int r10 = r10 - r6
            r9 = r9[r10]
            byte[] r10 = r12.e
            int r11 = r12.f
            int r11 = r11 + r8
            r10 = r10[r11]
            if (r9 != r10) goto L5c
        L3a:
            int r8 = r8 + 1
            if (r8 != r13) goto L4b
            int[] r13 = r12.b
            r14 = r13[r0]
            r13[r1] = r14
            int r0 = r0 + 1
            r14 = r13[r0]
            r13[r2] = r14
            return
        L4b:
            byte[] r9 = r12.e
            int r10 = r12.f
            int r10 = r10 + r8
            int r10 = r10 - r6
            r9 = r9[r10]
            byte[] r10 = r12.e
            int r11 = r12.f
            int r11 = r11 + r8
            r10 = r10[r11]
            if (r9 == r10) goto L3a
        L5c:
            byte[] r9 = r12.e
            int r10 = r12.f
            int r10 = r10 + r8
            int r10 = r10 - r6
            r6 = r9[r10]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte[] r9 = r12.e
            int r10 = r12.f
            int r10 = r10 + r8
            r9 = r9[r10]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L7c
            int[] r5 = r12.b
            r5[r1] = r14
            int r0 = r0 + 1
            r14 = r5[r0]
            r1 = r0
            r5 = r8
            goto L84
        L7c:
            int[] r4 = r12.b
            r4[r2] = r14
            r14 = r4[r0]
            r2 = r0
            r4 = r8
        L84:
            r0 = r7
            goto Ld
        L86:
            int[] r13 = r12.b
            r13[r2] = r3
            r13[r1] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.b.a.b.a.d(int, int):void");
    }

    private int g() {
        int c = c(this.d, 4);
        if (c != 0) {
            int i = this.m + 1;
            this.m = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Integer.MAX_VALUE - this.k;
                this.f1398a.c(i2);
                a(this.b, i2);
                this.m -= i2;
            }
            int i3 = this.l + 1;
            this.l = i3;
            if (i3 == this.k) {
                this.l = 0;
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0172, code lost:
        r1 = r16.b;
        r1[r8] = 0;
        r1[r5] = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0165  */
    @Override // org.b.a.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.b.a.b.f a() {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.b.a.b.a.a():org.b.a.b.f");
    }

    @Override // org.b.a.b.e
    public void a(int i) {
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            int i3 = this.d;
            int g = g();
            if (g < i3) {
                if (g == 0) {
                    i = i2;
                } else {
                    i3 = g;
                }
            }
            this.f1398a.a(this.e, this.f);
            int c = this.f1398a.c();
            this.f1398a.b(this.m);
            d(i3, c);
            i = i2;
        }
    }
}

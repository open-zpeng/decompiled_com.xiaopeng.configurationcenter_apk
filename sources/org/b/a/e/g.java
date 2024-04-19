package org.b.a.e;
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean[] f1419a = {true, true, true, false, true, false, false, false};
    private static final int[] b = {0, 1, 2, 2, 3, 3, 3, 3};
    private final boolean c;
    private int d;
    private int e = 0;

    public g(boolean z, int i) {
        this.c = z;
        this.d = i + 5;
    }

    private static boolean a(byte b2) {
        int i = b2 & 255;
        return i == 0 || i == 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (a(r11[(r1 + 4) - org.b.a.e.g.b[r0]]) != false) goto L26;
     */
    @Override // org.b.a.e.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(byte[] r11, int r12, int r13) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.b.a.e.g.a(byte[], int, int):int");
    }
}

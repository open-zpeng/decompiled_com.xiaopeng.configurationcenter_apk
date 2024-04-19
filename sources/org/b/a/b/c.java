package org.b.a.b;
/* loaded from: classes.dex */
final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1400a;
    static Class b;
    private final d i;
    private final int[] j;
    private final f k;
    private final int l;
    private final int m;
    private int n;
    private int o;

    static {
        if (b == null) {
            b = a("org.b.a.b.c");
        }
        f1400a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i, i2, i3, i4, i5);
        this.n = -1;
        this.i = new d(i);
        int i7 = i + 1;
        this.m = i7;
        this.j = new int[i7];
        this.o = i7;
        this.k = new f(i4 - 1);
        this.l = i6 <= 0 ? (i4 / 4) + 4 : i6;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private int g() {
        int c = c(4, 4);
        if (c != 0) {
            int i = this.o + 1;
            this.o = i;
            if (i == Integer.MAX_VALUE) {
                int i2 = Integer.MAX_VALUE - this.m;
                this.i.c(i2);
                a(this.j, i2);
                this.o -= i2;
            }
            int i3 = this.n + 1;
            this.n = i3;
            if (i3 == this.m) {
                this.n = 0;
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0143, code lost:
        return r13.k;
     */
    @Override // org.b.a.b.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.b.a.b.f a() {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.b.a.b.c.a():org.b.a.b.f");
    }

    @Override // org.b.a.b.e
    public void a(int i) {
        if (!f1400a && i < 0) {
            throw new AssertionError();
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (g() != 0) {
                this.i.a(this.e, this.f);
                this.j[this.n] = this.i.c();
                this.i.b(this.o);
            }
            i = i2;
        }
    }
}

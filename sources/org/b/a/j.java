package org.b.a;
/* loaded from: classes.dex */
public class j extends f {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1421a;
    static Class b;
    private static final int[] c;
    private static final int[] d;
    private int e;
    private byte[] f = null;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    static {
        if (b == null) {
            b = a("org.b.a.j");
        }
        f1421a = true;
        c = new int[]{262144, 1048576, 2097152, 4194304, 4194304, 8388608, 8388608, 16777216, 33554432, 67108864};
        d = new int[]{4, 8, 24, 48};
    }

    public j() {
        try {
            a(6);
        } catch (p unused) {
            if (!f1421a) {
                throw new AssertionError();
            }
            throw new RuntimeException();
        }
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public int a() {
        return this.e;
    }

    @Override // org.b.a.f
    public g a(g gVar) {
        return this.j == 0 ? new o(gVar) : new k(gVar, this);
    }

    public void a(int i) throws p {
        if (i < 0 || i > 9) {
            throw new p(new StringBuffer().append("Unsupported preset: ").append(i).toString());
        }
        this.g = 3;
        this.h = 0;
        this.i = 2;
        this.e = c[i];
        if (i <= 3) {
            this.j = 1;
            this.l = 4;
            this.k = i <= 1 ? 128 : 273;
            this.m = d[i];
            return;
        }
        this.j = 2;
        this.l = 20;
        this.k = i == 4 ? 16 : i == 5 ? 32 : 64;
        this.m = 0;
    }

    public void b(int i) throws p {
        if (i < 4096) {
            throw new p(new StringBuffer().append("LZMA2 dictionary size must be at least 4 KiB: ").append(i).append(" B").toString());
        }
        if (i > 805306368) {
            throw new p(new StringBuffer().append("LZMA2 dictionary size must not exceed 768 MiB: ").append(i).append(" B").toString());
        }
        this.e = i;
    }

    public byte[] b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1421a) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public int i() {
        return this.m;
    }
}

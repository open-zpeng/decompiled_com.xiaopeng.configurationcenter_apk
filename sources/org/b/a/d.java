package org.b.a;
/* loaded from: classes.dex */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1411a;
    static Class b;
    private int c = 1;

    static {
        if (b == null) {
            b = a("org.b.a.d");
        }
        f1411a = true;
    }

    public d() {
    }

    public d(int i) throws p {
        a(i);
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public int a() {
        return this.c;
    }

    @Override // org.b.a.f
    public g a(g gVar) {
        return new e(gVar, this);
    }

    public void a(int i) throws p {
        if (i < 1 || i > 256) {
            throw new p(new StringBuffer().append("Delta distance must be in the range [1, 256]: ").append(i).toString());
        }
        this.c = i;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f1411a) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}

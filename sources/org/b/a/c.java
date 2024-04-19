package org.b.a;
/* loaded from: classes.dex */
abstract class c extends f {
    static final boolean b;
    static Class c;

    /* renamed from: a  reason: collision with root package name */
    int f1403a = 0;
    private final int d;

    static {
        if (c == null) {
            c = a("org.b.a.c");
        }
        b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        this.d = i;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (b) {
                throw new RuntimeException();
            }
            throw new AssertionError();
        }
    }
}

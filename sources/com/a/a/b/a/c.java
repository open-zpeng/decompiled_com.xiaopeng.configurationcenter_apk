package com.a.a.b.a;

import com.a.a.n;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class c extends com.a.a.c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Reader f986a = new Reader() { // from class: com.a.a.b.a.c.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };
    private static final Object b = new Object();
    private final List<Object> c;

    private void a(com.a.a.c.c cVar) throws IOException {
        if (f() != cVar) {
            throw new IllegalStateException("Expected " + cVar + " but was " + f());
        }
    }

    private Object q() {
        List<Object> list = this.c;
        return list.get(list.size() - 1);
    }

    private Object r() {
        List<Object> list = this.c;
        return list.remove(list.size() - 1);
    }

    @Override // com.a.a.c.a
    public void a() throws IOException {
        a(com.a.a.c.c.BEGIN_ARRAY);
        this.c.add(((com.a.a.h) q()).iterator());
    }

    @Override // com.a.a.c.a
    public void b() throws IOException {
        a(com.a.a.c.c.END_ARRAY);
        r();
        r();
    }

    @Override // com.a.a.c.a
    public void c() throws IOException {
        a(com.a.a.c.c.BEGIN_OBJECT);
        this.c.add(((com.a.a.l) q()).g().iterator());
    }

    @Override // com.a.a.c.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.clear();
        this.c.add(b);
    }

    @Override // com.a.a.c.a
    public void d() throws IOException {
        a(com.a.a.c.c.END_OBJECT);
        r();
        r();
    }

    @Override // com.a.a.c.a
    public boolean e() throws IOException {
        com.a.a.c.c f = f();
        return (f == com.a.a.c.c.END_OBJECT || f == com.a.a.c.c.END_ARRAY) ? false : true;
    }

    @Override // com.a.a.c.a
    public com.a.a.c.c f() throws IOException {
        if (this.c.isEmpty()) {
            return com.a.a.c.c.END_DOCUMENT;
        }
        Object q = q();
        if (q instanceof Iterator) {
            List<Object> list = this.c;
            boolean z = list.get(list.size() - 2) instanceof com.a.a.l;
            Iterator it = (Iterator) q;
            if (!it.hasNext()) {
                return z ? com.a.a.c.c.END_OBJECT : com.a.a.c.c.END_ARRAY;
            } else if (z) {
                return com.a.a.c.c.NAME;
            } else {
                this.c.add(it.next());
                return f();
            }
        } else if (q instanceof com.a.a.l) {
            return com.a.a.c.c.BEGIN_OBJECT;
        } else {
            if (q instanceof com.a.a.h) {
                return com.a.a.c.c.BEGIN_ARRAY;
            }
            if (!(q instanceof n)) {
                if (q instanceof com.a.a.j) {
                    return com.a.a.c.c.NULL;
                }
                if (q == b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
            n nVar = (n) q;
            if (nVar.j()) {
                return com.a.a.c.c.STRING;
            }
            if (nVar.g()) {
                return com.a.a.c.c.BOOLEAN;
            }
            if (nVar.i()) {
                return com.a.a.c.c.NUMBER;
            }
            throw new AssertionError();
        }
    }

    @Override // com.a.a.c.a
    public String g() throws IOException {
        a(com.a.a.c.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.a.a.c.a
    public String h() throws IOException {
        com.a.a.c.c f = f();
        if (f == com.a.a.c.c.STRING || f == com.a.a.c.c.NUMBER) {
            return ((n) r()).b();
        }
        throw new IllegalStateException("Expected " + com.a.a.c.c.STRING + " but was " + f);
    }

    @Override // com.a.a.c.a
    public boolean i() throws IOException {
        a(com.a.a.c.c.BOOLEAN);
        return ((n) r()).f();
    }

    @Override // com.a.a.c.a
    public void j() throws IOException {
        a(com.a.a.c.c.NULL);
        r();
    }

    @Override // com.a.a.c.a
    public double k() throws IOException {
        com.a.a.c.c f = f();
        if (f == com.a.a.c.c.NUMBER || f == com.a.a.c.c.STRING) {
            double c = ((n) q()).c();
            if (p() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                r();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + com.a.a.c.c.NUMBER + " but was " + f);
    }

    @Override // com.a.a.c.a
    public long l() throws IOException {
        com.a.a.c.c f = f();
        if (f == com.a.a.c.c.NUMBER || f == com.a.a.c.c.STRING) {
            long d = ((n) q()).d();
            r();
            return d;
        }
        throw new IllegalStateException("Expected " + com.a.a.c.c.NUMBER + " but was " + f);
    }

    @Override // com.a.a.c.a
    public int m() throws IOException {
        com.a.a.c.c f = f();
        if (f == com.a.a.c.c.NUMBER || f == com.a.a.c.c.STRING) {
            int e = ((n) q()).e();
            r();
            return e;
        }
        throw new IllegalStateException("Expected " + com.a.a.c.c.NUMBER + " but was " + f);
    }

    @Override // com.a.a.c.a
    public void n() throws IOException {
        if (f() == com.a.a.c.c.NAME) {
            g();
        } else {
            r();
        }
    }

    public void o() throws IOException {
        a(com.a.a.c.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        this.c.add(new n((String) entry.getKey()));
    }

    @Override // com.a.a.c.a
    public String toString() {
        return getClass().getSimpleName();
    }
}

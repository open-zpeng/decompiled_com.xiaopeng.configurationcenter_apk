package com.a.a;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class s {
    public Number a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean k() {
        return this instanceof h;
    }

    public boolean l() {
        return this instanceof l;
    }

    public boolean m() {
        return this instanceof n;
    }

    public boolean n() {
        return this instanceof j;
    }

    public l o() {
        if (l()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public h p() {
        if (k()) {
            return (h) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public n q() {
        if (m()) {
            return (n) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.a.a.c.b bVar = new com.a.a.c.b(stringWriter);
            bVar.b(true);
            com.a.a.b.j.a(this, bVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

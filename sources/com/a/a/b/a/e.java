package com.a.a.b.a;

import com.a.a.n;
import com.a.a.s;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class e extends com.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f988a = new Writer() { // from class: com.a.a.b.a.e.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    private static final n b = new n("closed");
    private final List<s> c;
    private String d;
    private s e;

    public e() {
        super(f988a);
        this.c = new ArrayList();
        this.e = com.a.a.j.f1053a;
    }

    private void a(s sVar) {
        if (this.d != null) {
            if (!sVar.n() || i()) {
                ((com.a.a.l) j()).a(this.d, sVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = sVar;
        } else {
            s j = j();
            if (!(j instanceof com.a.a.h)) {
                throw new IllegalStateException();
            }
            ((com.a.a.h) j).a(sVar);
        }
    }

    private s j() {
        List<s> list = this.c;
        return list.get(list.size() - 1);
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b a(long j) throws IOException {
        a(new n(Long.valueOf(j)));
        return this;
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new n(number));
        return this;
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b a(String str) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.a.a.l) {
            this.d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b a(boolean z) throws IOException {
        a(new n(Boolean.valueOf(z)));
        return this;
    }

    public s a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b b() throws IOException {
        com.a.a.h hVar = new com.a.a.h();
        a(hVar);
        this.c.add(hVar);
        return this;
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        a(new n(str));
        return this;
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.a.a.h) {
            List<s> list = this.c;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.c.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b d() throws IOException {
        com.a.a.l lVar = new com.a.a.l();
        a(lVar);
        this.c.add(lVar);
        return this;
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.a.a.l) {
            List<s> list = this.c;
            list.remove(list.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.c.b
    public com.a.a.c.b f() throws IOException {
        a(com.a.a.j.f1053a);
        return this;
    }

    @Override // com.a.a.c.b, java.io.Flushable
    public void flush() throws IOException {
    }
}

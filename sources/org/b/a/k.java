package org.b.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
class k extends g {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f1422a;
    static Class b;
    private g c;
    private final DataOutputStream d;
    private final org.b.a.b.e e;
    private final org.b.a.d.b f;
    private final org.b.a.c.b g;
    private final int h;
    private boolean i;
    private boolean j = true;
    private boolean k = true;
    private int l = 0;
    private boolean m = false;
    private IOException n = null;
    private final byte[] o = new byte[1];

    static {
        if (b == null) {
            b = a("org.b.a.k");
        }
        f1422a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, j jVar) {
        this.i = true;
        Objects.requireNonNull(gVar);
        this.c = gVar;
        this.d = new DataOutputStream(gVar);
        org.b.a.d.b bVar = new org.b.a.d.b(65536);
        this.f = bVar;
        int a2 = jVar.a();
        org.b.a.c.b a3 = org.b.a.c.b.a(bVar, jVar.c(), jVar.d(), jVar.e(), jVar.f(), a2, a(a2), jVar.g(), jVar.h(), jVar.i());
        this.g = a3;
        org.b.a.b.e c = a3.c();
        this.e = c;
        byte[] b2 = jVar.b();
        if (b2 != null && b2.length > 0) {
            c.a(a2, b2);
            this.i = false;
        }
        this.h = (((jVar.e() * 5) + jVar.d()) * 9) + jVar.c();
    }

    private static int a(int i) {
        if (65536 > i) {
            return 65536 - i;
        }
        return 0;
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void a() throws IOException {
        int c = this.f.c();
        int d = this.g.d();
        boolean z = f1422a;
        if (!z && c <= 0) {
            throw new AssertionError(c);
        }
        if (!z && d <= 0) {
            throw new AssertionError(d);
        }
        if (c + 2 < d) {
            a(d, c);
        } else {
            this.g.a();
            d = this.g.d();
            if (!z && d <= 0) {
                throw new AssertionError(d);
            }
            b(d);
        }
        this.l -= d;
        this.g.e();
        this.f.a();
    }

    private void a(int i, int i2) throws IOException {
        int i3 = i - 1;
        this.d.writeByte((this.k ? this.i ? 224 : 192 : this.j ? 160 : 128) | (i3 >>> 16));
        this.d.writeShort(i3);
        this.d.writeShort(i2 - 1);
        if (this.k) {
            this.d.writeByte(this.h);
        }
        this.f.a(this.c);
        this.k = false;
        this.j = false;
        this.i = false;
    }

    private void b() throws IOException {
        if (!f1422a && this.m) {
            throw new AssertionError();
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        this.e.d();
        while (this.l > 0) {
            try {
                this.g.f();
                a();
            } catch (IOException e) {
                this.n = e;
                throw e;
            }
        }
        this.c.write(0);
        this.m = true;
    }

    private void b(int i) throws IOException {
        while (true) {
            int i2 = 1;
            if (i <= 0) {
                this.j = true;
                return;
            }
            int min = Math.min(i, 65536);
            DataOutputStream dataOutputStream = this.d;
            if (!this.i) {
                i2 = 2;
            }
            dataOutputStream.writeByte(i2);
            this.d.writeShort(min - 1);
            this.e.a(this.c, i, min);
            i -= min;
            this.i = false;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c != null) {
            if (!this.m) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
            try {
                this.c.close();
            } catch (IOException e) {
                if (this.n == null) {
                    this.n = e;
                }
            }
            this.c = null;
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        if (this.m) {
            throw new r("Stream finished or closed");
        }
        try {
            this.e.c();
            while (this.l > 0) {
                this.g.f();
                a();
            }
            this.c.flush();
        } catch (IOException e) {
            this.n = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.o;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        if (this.m) {
            throw new r("Stream finished or closed");
        }
        while (i2 > 0) {
            try {
                int a2 = this.e.a(bArr, i, i2);
                i += a2;
                i2 -= a2;
                this.l += a2;
                if (this.g.f()) {
                    a();
                }
            } catch (IOException e) {
                this.n = e;
                throw e;
            }
        }
    }
}

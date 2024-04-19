package org.b.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;
/* loaded from: classes.dex */
class o extends g {

    /* renamed from: a  reason: collision with root package name */
    private g f1424a;
    private final DataOutputStream b;
    private final byte[] c = new byte[65536];
    private int d = 0;
    private boolean e = true;
    private boolean f = false;
    private IOException g = null;
    private final byte[] h = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        Objects.requireNonNull(gVar);
        this.f1424a = gVar;
        this.b = new DataOutputStream(gVar);
    }

    private void a() throws IOException {
        this.b.writeByte(this.e ? 1 : 2);
        this.b.writeShort(this.d - 1);
        this.b.write(this.c, 0, this.d);
        this.d = 0;
        this.e = false;
    }

    private void b() throws IOException {
        IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f) {
            throw new r("Stream finished or closed");
        }
        try {
            if (this.d > 0) {
                a();
            }
            this.f1424a.write(0);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1424a != null) {
            if (!this.f) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
            try {
                this.f1424a.close();
            } catch (IOException e) {
                if (this.g == null) {
                    this.g = e;
                }
            }
            this.f1424a = null;
        }
        IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f) {
            throw new r("Stream finished or closed");
        }
        try {
            if (this.d > 0) {
                a();
            }
            this.f1424a.flush();
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.h;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.g;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f) {
            throw new r("Stream finished or closed");
        }
        while (i2 > 0) {
            try {
                int min = Math.min(this.c.length - this.d, i2);
                System.arraycopy(bArr, i, this.c, this.d, min);
                i2 -= min;
                int i4 = this.d + min;
                this.d = i4;
                if (i4 == this.c.length) {
                    a();
                }
            } catch (IOException e) {
                this.g = e;
                throw e;
            }
        }
    }
}

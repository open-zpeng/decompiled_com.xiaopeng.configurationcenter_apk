package org.b.a;

import java.io.IOException;
/* loaded from: classes.dex */
class e extends g {

    /* renamed from: a  reason: collision with root package name */
    private g f1413a;
    private final org.b.a.a.b b;
    private final byte[] c = new byte[4096];
    private boolean d = false;
    private IOException e = null;
    private final byte[] f = new byte[1];

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, d dVar) {
        this.f1413a = gVar;
        this.b = new org.b.a.a.b(dVar.a());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        g gVar = this.f1413a;
        if (gVar != null) {
            try {
                gVar.close();
            } catch (IOException e) {
                if (this.e == null) {
                    this.e = e;
                }
            }
            this.f1413a = null;
        }
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
        if (this.d) {
            throw new r("Stream finished or closed");
        }
        try {
            this.f1413a.flush();
        } catch (IOException e) {
            this.e = e;
            throw e;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i < 0 || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.e;
        if (iOException != null) {
            throw iOException;
        }
        if (this.d) {
            throw new r("Stream finished");
        }
        while (i2 > 4096) {
            try {
                this.b.a(bArr, i, 4096, this.c);
                this.f1413a.write(this.c);
                i += 4096;
                i2 -= 4096;
            } catch (IOException e) {
                this.e = e;
                throw e;
            }
        }
        this.b.a(bArr, i, i2, this.c);
        this.f1413a.write(this.c, 0, i2);
    }
}

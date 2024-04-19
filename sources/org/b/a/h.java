package org.b.a;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: a  reason: collision with root package name */
    protected OutputStream f1420a;

    public h(OutputStream outputStream) {
        this.f1420a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1420a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f1420a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f1420a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f1420a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f1420a.write(bArr, i, i2);
    }
}

package org.b.a.e;
/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1414a;
    private int b;

    public a(boolean z, int i) {
        this.f1414a = z;
        this.b = i + 8;
    }

    @Override // org.b.a.e.f
    public int a(byte[] bArr, int i, int i2) {
        int i3 = (i2 + i) - 4;
        int i4 = i;
        while (i4 <= i3) {
            if ((bArr[i4 + 3] & 255) == 235) {
                int i5 = i4 + 2;
                int i6 = i4 + 1;
                int i7 = ((((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8)) | (bArr[i4] & 255)) << 2;
                int i8 = (this.f1414a ? i7 + ((this.b + i4) - i) : i7 - ((this.b + i4) - i)) >>> 2;
                bArr[i5] = (byte) (i8 >>> 16);
                bArr[i6] = (byte) (i8 >>> 8);
                bArr[i4] = (byte) i8;
            }
            i4 += 4;
        }
        int i9 = i4 - i;
        this.b += i9;
        return i9;
    }
}

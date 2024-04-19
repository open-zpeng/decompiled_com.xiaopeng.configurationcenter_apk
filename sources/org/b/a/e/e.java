package org.b.a.e;
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1418a;
    private int b;

    public e(boolean z, int i) {
        this.f1418a = z;
        this.b = i;
    }

    @Override // org.b.a.e.f
    public int a(byte[] bArr, int i, int i2) {
        int i3 = (i2 + i) - 4;
        int i4 = i;
        while (i4 <= i3) {
            if ((bArr[i4] == 64 && (bArr[i4 + 1] & 192) == 0) || (bArr[i4] == Byte.MAX_VALUE && (bArr[i4 + 1] & 192) == 192)) {
                int i5 = i4 + 1;
                int i6 = i4 + 2;
                int i7 = i4 + 3;
                int i8 = (((((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 16)) | ((bArr[i6] & 255) << 8)) | (bArr[i7] & 255)) << 2;
                int i9 = (this.f1418a ? i8 + ((this.b + i4) - i) : i8 - ((this.b + i4) - i)) >>> 2;
                int i10 = (i9 & 4194303) | (((0 - ((i9 >>> 22) & 1)) << 22) & 1073741823) | 1073741824;
                bArr[i4] = (byte) (i10 >>> 24);
                bArr[i5] = (byte) (i10 >>> 16);
                bArr[i6] = (byte) (i10 >>> 8);
                bArr[i7] = (byte) i10;
            }
            i4 += 4;
        }
        int i11 = i4 - i;
        this.b += i11;
        return i11;
    }
}

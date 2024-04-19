package com.ta.utdid2.b.a;

import java.io.UnsupportedEncodingException;
/* compiled from: Base64.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f1279a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1280a;
        public byte[] b;

        a() {
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C0086b c0086b = new C0086b(i3, new byte[(i2 * 3) / 4]);
        if (!c0086b.a(bArr, i, i2, f1279a)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (c0086b.f1280a == c0086b.b.length) {
            return c0086b.b;
        }
        byte[] bArr2 = new byte[c0086b.f1280a];
        System.arraycopy(c0086b.b, 0, bArr2, 0, c0086b.f1280a);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* renamed from: com.ta.utdid2.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086b extends a {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f1281a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private final int[] c;
        private int state;
        private int value;

        public C0086b(int i, byte[] bArr) {
            this.b = bArr;
            this.c = (i & 8) == 0 ? f1281a : b;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.state;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.value;
            byte[] bArr2 = this.b;
            int[] iArr = this.c;
            int i6 = 0;
            int i7 = i5;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4) {
                            break;
                        }
                        i7 = iArr[bArr[i9 + 3] & 255] | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 2] & 255] << 6);
                        if (i7 < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i7;
                        bArr2[i6 + 1] = (byte) (i7 >> 8);
                        bArr2[i6] = (byte) (i7 >> 16);
                        i6 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i7 = (i7 << 6) | i12;
                        i8++;
                    } else if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                if (i12 != -2) {
                                    if (i12 != -1) {
                                        this.state = 6;
                                        return false;
                                    }
                                }
                                i8++;
                            } else if (i8 == 5 && i12 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i12 >= 0) {
                            i7 = (i7 << 6) | i12;
                            bArr2[i6 + 2] = (byte) i7;
                            bArr2[i6 + 1] = (byte) (i7 >> 8);
                            bArr2[i6] = (byte) (i7 >> 16);
                            i6 += 3;
                            i8 = 0;
                        } else if (i12 == -2) {
                            bArr2[i6 + 1] = (byte) (i7 >> 2);
                            bArr2[i6] = (byte) (i7 >> 10);
                            i6 += 2;
                            i9 = i11;
                            i8 = 5;
                        } else if (i12 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        i7 = (i7 << 6) | i12;
                        i8++;
                    } else if (i12 == -2) {
                        bArr2[i6] = (byte) (i7 >> 4);
                        i6++;
                        i9 = i11;
                        i8 = 4;
                    } else if (i12 != -1) {
                        this.state = 6;
                        return false;
                    }
                } else if (i12 >= 0) {
                    i8++;
                    i7 = i12;
                } else if (i12 != -1) {
                    this.state = 6;
                    return false;
                }
                i9 = i11;
            }
            if (!z) {
                this.state = i8;
                this.value = i7;
                this.f1280a = i6;
                return b.f1279a;
            } else if (i8 == 1) {
                this.state = 6;
                return false;
            } else {
                if (i8 == 2) {
                    bArr2[i6] = (byte) (i7 >> 4);
                    i6++;
                } else if (i8 == 3) {
                    int i13 = i6 + 1;
                    bArr2[i6] = (byte) (i7 >> 10);
                    i6 = i13 + 1;
                    bArr2[i13] = (byte) (i7 >> 2);
                } else if (i8 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i8;
                this.f1280a = i6;
                return b.f1279a;
            }
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (cVar.f109b) {
            if (i2 % 3 > 0) {
                i4 += 4;
            }
        } else {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        }
        if (cVar.f110c && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.f111d ? 2 : 1);
        }
        cVar.b = new byte[i4];
        cVar.a(bArr, i, i2, f1279a);
        if (f1279a || cVar.f1280a == i4) {
            return cVar.b;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Base64.java */
    /* loaded from: classes.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f1282a = b.f1279a;
        private static final byte[] c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        int b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f109b;

        /* renamed from: c  reason: collision with other field name */
        public final boolean f110c;
        private int count;

        /* renamed from: d  reason: collision with other field name */
        public final boolean f111d;
        private final byte[] e;
        private final byte[] f;

        public c(int i, byte[] bArr) {
            this.b = bArr;
            int i2 = i & 1;
            boolean z = b.f1279a;
            this.f109b = i2 == 0;
            boolean z2 = (i & 2) == 0;
            this.f110c = z2;
            this.f111d = (i & 4) == 0 ? false : z;
            this.f = (i & 8) == 0 ? c : d;
            this.e = new byte[2];
            this.b = 0;
            this.count = z2 ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:73:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0178 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0094 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01fa -> B:22:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 517
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    private b() {
    }
}

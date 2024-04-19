package com.a.a.c;

import com.a.a.b.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1041a = ")]}'\n".toCharArray();
    private final Reader b;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m;
    private int n;

    static {
        e.f1026a = new e() { // from class: com.a.a.c.a.1
            @Override // com.a.a.b.e
            public void a(a aVar) throws IOException {
                int i;
                if (aVar instanceof com.a.a.b.a.c) {
                    ((com.a.a.b.a.c) aVar).o();
                    return;
                }
                int i2 = aVar.i;
                if (i2 == 0) {
                    i2 = aVar.o();
                }
                if (i2 == 13) {
                    i = 9;
                } else if (i2 == 12) {
                    i = 8;
                } else if (i2 != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + "  at line " + aVar.u() + " column " + aVar.v());
                } else {
                    i = 10;
                }
                aVar.i = i;
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.m = iArr;
        this.n = 0;
        this.n = 0 + 1;
        iArr[0] = 6;
        Objects.requireNonNull(reader, "in == null");
        this.b = reader;
    }

    private void a(int i) {
        int i2 = this.n;
        int[] iArr = this.m;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.m = iArr2;
        }
        int[] iArr3 = this.m;
        int i3 = this.n;
        this.n = i3 + 1;
        iArr3[i3] = i;
    }

    private boolean a(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    private boolean a(String str) throws IOException {
        while (true) {
            if (this.e + str.length() > this.f && !b(str.length())) {
                return false;
            }
            char[] cArr = this.d;
            int i = this.e;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < str.length(); i2++) {
                    if (this.d[this.e + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.g++;
            this.h = i + 1;
            this.e++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
        r7.e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
        r7.e = r4 - 1;
        r2 = b(2);
        r7.e++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
        w();
        r2 = r7.e;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        r7.e = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0091, code lost:
        r7.e = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
        if (a("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        throw b("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
        r7.e = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
        w();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int b(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.d
        L2:
            int r1 = r7.e
        L4:
            int r2 = r7.f
        L6:
            r3 = 1
            if (r1 != r2) goto L44
            r7.e = r1
            boolean r1 = r7.b(r3)
            if (r1 != 0) goto L40
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input at line "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r7.u()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " column "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r7.v()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L40:
            int r1 = r7.e
            int r2 = r7.f
        L44:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L54
            int r1 = r7.g
            int r1 = r1 + r3
            r7.g = r1
            r7.h = r4
            goto Lb4
        L54:
            r5 = 32
            if (r1 == r5) goto Lb4
            r5 = 13
            if (r1 == r5) goto Lb4
            r5 = 9
            if (r1 != r5) goto L61
            goto Lb4
        L61:
            r5 = 47
            if (r1 != r5) goto La9
            r7.e = r4
            r6 = 2
            if (r4 != r2) goto L7a
            int r4 = r4 + (-1)
            r7.e = r4
            boolean r2 = r7.b(r6)
            int r4 = r7.e
            int r4 = r4 + r3
            r7.e = r4
            if (r2 != 0) goto L7a
            return r1
        L7a:
            r7.w()
            int r2 = r7.e
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L91
            if (r3 == r5) goto L88
            return r1
        L88:
            int r2 = r2 + 1
            r7.e = r2
        L8c:
            r7.x()
            goto L2
        L91:
            int r2 = r2 + 1
            r7.e = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.a(r1)
            if (r1 == 0) goto La2
            int r1 = r7.e
            int r1 = r1 + r6
            goto L4
        La2:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.b(r8)
            throw r8
        La9:
            r2 = 35
            r7.e = r4
            if (r1 != r2) goto Lb3
            r7.w()
            goto L8c
        Lb3:
            return r1
        Lb4:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.a.b(boolean):int");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + " at line " + u() + " column " + v());
    }

    private String b(char c) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.e = i3;
                        sb.append(cArr, i, (i3 - i) - 1);
                        sb.append(y());
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    sb.append(cArr, i, i - i);
                    this.e = i;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean b(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.d;
        int i4 = this.h;
        int i5 = this.e;
        this.h = i4 - i5;
        int i6 = this.f;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.b;
            int i8 = this.f;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.f + read;
            this.f = i2;
            if (this.g == 0 && (i3 = this.h) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    private void c(char c) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.e = i3;
                        y();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.e = i;
                    if (!b(1)) {
                        throw b("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() throws IOException {
        int i;
        int b;
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 != 2) {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (b = b(true)) != 44) {
                    if (b != 59) {
                        if (b == 125) {
                            this.i = 2;
                            return 2;
                        }
                        throw b("Unterminated object");
                    }
                    w();
                }
                int b2 = b(true);
                if (b2 == 34) {
                    i = 13;
                } else if (b2 == 39) {
                    w();
                    i = 12;
                } else if (b2 == 125) {
                    if (i3 != 5) {
                        this.i = 2;
                        return 2;
                    }
                    throw b("Expected name");
                } else {
                    w();
                    this.e--;
                    if (!a((char) b2)) {
                        throw b("Expected name");
                    }
                    i = 14;
                }
            } else if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int b3 = b(true);
                if (b3 != 58) {
                    if (b3 != 61) {
                        throw b("Expected ':'");
                    }
                    w();
                    if (this.e < this.f || b(1)) {
                        char[] cArr = this.d;
                        int i4 = this.e;
                        if (cArr[i4] == '>') {
                            this.e = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.c) {
                    z();
                }
                this.m[this.n - 1] = 7;
            } else if (i3 == 7) {
                if (b(false) == -1) {
                    i = 17;
                } else {
                    w();
                    this.e--;
                }
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.i = i;
            return i;
        } else {
            int b4 = b(true);
            if (b4 != 44) {
                if (b4 != 59) {
                    if (b4 == 93) {
                        this.i = 4;
                        return 4;
                    }
                    throw b("Unterminated array");
                }
                w();
            }
        }
        int b5 = b(true);
        if (b5 != 34) {
            if (b5 == 39) {
                w();
                this.i = 8;
                return 8;
            }
            if (b5 != 44 && b5 != 59) {
                if (b5 == 91) {
                    this.i = 3;
                    return 3;
                } else if (b5 != 93) {
                    if (b5 == 123) {
                        this.i = 1;
                        return 1;
                    }
                    this.e--;
                    if (this.n == 1) {
                        w();
                    }
                    int q = q();
                    if (q != 0) {
                        return q;
                    }
                    int r = r();
                    if (r != 0) {
                        return r;
                    }
                    if (!a(this.d[this.e])) {
                        throw b("Expected value");
                    }
                    w();
                    i = 10;
                } else if (i3 == 1) {
                    this.i = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                w();
                this.e--;
                this.i = 7;
                return 7;
            }
            throw b("Unexpected value");
        }
        if (this.n == 1) {
            w();
        }
        i = 9;
        this.i = i;
        return i;
    }

    private int q() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.d[this.e];
        if (c == 't' || c == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.e + i2 >= this.f && !b(i2 + 1)) {
                return 0;
            }
            char c2 = this.d[this.e + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.e + length < this.f || b(length + 1)) && a(this.d[this.e + length])) {
            return 0;
        }
        this.e += length;
        this.i = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (a(r14) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (r9 != 2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r10 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009d, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r13 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a4, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a5, code lost:
        r18.j = r11;
        r18.e += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
        r18.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b0, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
        if (r9 == 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b4, code lost:
        if (r9 == 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
        if (r9 != 7) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ba, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
        r18.k = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c1, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int r() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.a.r():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        w();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String s() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r6.e
            int r4 = r3 + r2
            int r5 = r6.f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.w()
            goto L5c
        L4e:
            char[] r3 = r6.d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L78
        L5e:
            if (r1 != 0) goto L65
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L65:
            char[] r3 = r6.d
            int r4 = r6.e
            r1.append(r3, r4, r2)
            int r3 = r6.e
            int r3 = r3 + r2
            r6.e = r3
            r2 = 1
            boolean r2 = r6.b(r2)
            if (r2 != 0) goto L2
        L78:
            if (r1 != 0) goto L84
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.d
            int r3 = r6.e
            r1.<init>(r2, r3, r0)
            goto L8f
        L84:
            char[] r2 = r6.d
            int r3 = r6.e
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L8f:
            int r2 = r6.e
            int r2 = r2 + r0
            r6.e = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.a.s():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        w();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void t() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.e
            int r2 = r1 + r0
            int r3 = r4.f
            if (r2 >= r3) goto L51
            char[] r2 = r4.d
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.w()
        L4b:
            int r1 = r4.e
            int r1 = r1 + r0
            r4.e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.e = r1
            r0 = 1
            boolean r0 = r4.b(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.a.t():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        return this.g + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        return (this.e - this.h) + 1;
    }

    private void w() throws IOException {
        if (!this.c) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c;
        do {
            if (this.e >= this.f && !b(1)) {
                return;
            }
            char[] cArr = this.d;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = i2;
                return;
            }
        } while (c != '\r');
    }

    private char y() throws IOException {
        int i;
        int i2;
        if (this.e != this.f || b(1)) {
            char[] cArr = this.d;
            int i3 = this.e;
            int i4 = i3 + 1;
            this.e = i4;
            char c = cArr[i3];
            if (c == '\n') {
                this.g++;
                this.h = i4;
            } else if (c == 'b') {
                return '\b';
            } else {
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c == 'u') {
                    if (i4 + 4 <= this.f || b(4)) {
                        char c2 = 0;
                        int i5 = this.e;
                        int i6 = i5 + 4;
                        while (i5 < i6) {
                            char c3 = this.d[i5];
                            char c4 = (char) (c2 << 4);
                            if (c3 < '0' || c3 > '9') {
                                if (c3 >= 'a' && c3 <= 'f') {
                                    i = c3 - 'a';
                                } else if (c3 < 'A' || c3 > 'F') {
                                    throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                                } else {
                                    i = c3 - 'A';
                                }
                                i2 = i + 10;
                            } else {
                                i2 = c3 - '0';
                            }
                            c2 = (char) (c4 + i2);
                            i5++;
                        }
                        this.e += 4;
                        return c2;
                    }
                    throw b("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw b("Unterminated escape sequence");
    }

    private void z() throws IOException {
        b(true);
        int i = this.e - 1;
        this.e = i;
        char[] cArr = f1041a;
        if (i + cArr.length > this.f && !b(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = f1041a;
            if (i2 >= cArr2.length) {
                this.e += cArr2.length;
                return;
            } else if (this.d[this.e + i2] != cArr2[i2]) {
                return;
            } else {
                i2++;
            }
        }
    }

    public void a() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i != 3) {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + u() + " column " + v());
        }
        a(1);
        this.i = 0;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public void b() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + u() + " column " + v());
        }
        this.n--;
        this.i = 0;
    }

    public void c() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i != 1) {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + u() + " column " + v());
        }
        a(3);
        this.i = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.b.close();
    }

    public void d() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + u() + " column " + v());
        }
        this.n--;
        this.i = 0;
    }

    public boolean e() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public c f() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        switch (i) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String g() throws IOException {
        char c;
        String b;
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 14) {
            b = s();
        } else {
            if (i == 12) {
                c = '\'';
            } else if (i != 13) {
                throw new IllegalStateException("Expected a name but was " + f() + " at line " + u() + " column " + v());
            } else {
                c = '\"';
            }
            b = b(c);
        }
        this.i = 0;
        return b;
    }

    public String h() throws IOException {
        String str;
        char c;
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 10) {
            str = s();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = '\"';
            } else if (i == 11) {
                str = this.l;
                this.l = null;
            } else if (i == 15) {
                str = Long.toString(this.j);
            } else if (i != 16) {
                throw new IllegalStateException("Expected a string but was " + f() + " at line " + u() + " column " + v());
            } else {
                str = new String(this.d, this.e, this.k);
                this.e += this.k;
            }
            str = b(c);
        }
        this.i = 0;
        return str;
    }

    public boolean i() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 5) {
            this.i = 0;
            return true;
        } else if (i == 6) {
            this.i = 0;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + u() + " column " + v());
        }
    }

    public void j() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i != 7) {
            throw new IllegalStateException("Expected null but was " + f() + " at line " + u() + " column " + v());
        }
        this.i = 0;
    }

    public double k() throws IOException {
        String b;
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            this.i = 0;
            return this.j;
        }
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else {
            if (i == 8 || i == 9) {
                b = b(i == 8 ? '\'' : '\"');
            } else if (i == 10) {
                b = s();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + f() + " at line " + u() + " column " + v());
            }
            this.l = b;
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        if (this.c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.l = null;
            this.i = 0;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + " at line " + u() + " column " + v());
    }

    public long l() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            this.i = 0;
            return this.j;
        }
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected a long but was " + f() + " at line " + u() + " column " + v());
        } else {
            String b = b(i == 8 ? '\'' : '\"');
            this.l = b;
            try {
                long parseLong = Long.parseLong(b);
                this.i = 0;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.l = null;
            this.i = 0;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.l + " at line " + u() + " column " + v());
    }

    public int m() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = o();
        }
        if (i == 15) {
            long j = this.j;
            int i2 = (int) j;
            if (j == i2) {
                this.i = 0;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + " at line " + u() + " column " + v());
        }
        if (i == 16) {
            this.l = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else if (i != 8 && i != 9) {
            throw new IllegalStateException("Expected an int but was " + f() + " at line " + u() + " column " + v());
        } else {
            String b = b(i == 8 ? '\'' : '\"');
            this.l = b;
            try {
                int parseInt = Integer.parseInt(b);
                this.i = 0;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.i = 11;
        double parseDouble = Double.parseDouble(this.l);
        int i3 = (int) parseDouble;
        if (i3 == parseDouble) {
            this.l = null;
            this.i = 0;
            return i3;
        }
        throw new NumberFormatException("Expected an int but was " + this.l + " at line " + u() + " column " + v());
    }

    public void n() throws IOException {
        char c;
        int i = 0;
        do {
            int i2 = this.i;
            if (i2 == 0) {
                i2 = o();
            }
            if (i2 == 3) {
                a(1);
            } else if (i2 == 1) {
                a(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.n--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    t();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = '\"';
                    } else if (i2 == 16) {
                        this.e += this.k;
                    }
                    c(c);
                }
                this.i = 0;
            }
            i++;
            this.i = 0;
        } while (i != 0);
    }

    public final boolean p() {
        return this.c;
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + u() + " column " + v();
    }
}

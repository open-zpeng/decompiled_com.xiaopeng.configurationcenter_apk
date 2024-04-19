package com.a.a.c;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1042a = new String[128];
    private static final String[] b;
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            f1042a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f1042a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        a(6);
        this.g = ":";
        this.k = true;
        Objects.requireNonNull(writer, "out == null");
        this.c = writer;
    }

    private int a() {
        int i = this.e;
        if (i != 0) {
            return this.d[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private b a(int i, int i2, String str) throws IOException {
        int a2 = a();
        if (a2 == i2 || a2 == i) {
            if (this.j == null) {
                this.e--;
                if (a2 == i2) {
                    k();
                }
                this.c.write(str);
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private b a(int i, String str) throws IOException {
        e(true);
        a(i);
        this.c.write(str);
        return this;
    }

    private void a(int i) {
        int i2 = this.e;
        int[] iArr = this.d;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.d = iArr2;
        }
        int[] iArr3 = this.d;
        int i3 = this.e;
        this.e = i3 + 1;
        iArr3[i3] = i;
    }

    private void b(int i) {
        this.d[this.e - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.a.a.c.b.b
            goto L9
        L7:
            java.lang.String[] r0 = com.a.a.c.b.f1042a
        L9:
            java.io.Writer r1 = r8.c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.c.b.d(java.lang.String):void");
    }

    private void e(boolean z) throws IOException {
        int a2 = a();
        if (a2 == 1) {
            b(2);
        } else if (a2 != 2) {
            if (a2 == 4) {
                this.c.append((CharSequence) this.g);
                b(5);
                return;
            }
            if (a2 != 6) {
                if (a2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            if (!this.h && !z) {
                throw new IllegalStateException("JSON must start with an array or an object.");
            }
            b(7);
            return;
        } else {
            this.c.append(',');
        }
        k();
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    private void k() throws IOException {
        if (this.f == null) {
            return;
        }
        this.c.write("\n");
        int i = this.e;
        for (int i2 = 1; i2 < i; i2++) {
            this.c.write(this.f);
        }
    }

    private void l() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.c.write(44);
        } else if (a2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    public b a(long j) throws IOException {
        j();
        e(false);
        this.c.write(Long.toString(j));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String obj = number.toString();
        if (this.h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            e(false);
            this.c.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public b a(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.j == null) {
            if (this.e != 0) {
                this.j = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public b a(boolean z) throws IOException {
        j();
        e(false);
        this.c.write(z ? "true" : "false");
        return this;
    }

    public b b() throws IOException {
        j();
        return a(1, "[");
    }

    public b b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        e(false);
        d(str);
        return this;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public b c() throws IOException {
        return a(1, 2, "]");
    }

    public final void c(String str) {
        String str2;
        if (str.length() == 0) {
            this.f = null;
            str2 = ":";
        } else {
            this.f = str;
            str2 = ": ";
        }
        this.g = str2;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public b d() throws IOException {
        j();
        return a(3, "{");
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public b e() throws IOException {
        return a(3, 5, "}");
    }

    public b f() throws IOException {
        if (this.j != null) {
            if (!this.k) {
                this.j = null;
                return this;
            }
            j();
        }
        e(false);
        this.c.write("null");
        return this;
    }

    public void flush() throws IOException {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}

package com.a.a.b;

import com.a.a.b.a.l;
import com.a.a.s;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class j {

    /* compiled from: Streams.java */
    /* loaded from: classes.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f1037a;
        private final C0066a b;

        /* compiled from: Streams.java */
        /* renamed from: com.a.a.b.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0066a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f1038a;

            C0066a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f1038a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f1038a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f1038a, i, i2 - i);
            }
        }

        private a(Appendable appendable) {
            this.b = new C0066a();
            this.f1037a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f1037a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.f1038a = cArr;
            this.f1037a.append(this.b, i, i2 + i);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    public static void a(s sVar, com.a.a.c.b bVar) throws IOException {
        l.P.a(bVar, sVar);
    }
}

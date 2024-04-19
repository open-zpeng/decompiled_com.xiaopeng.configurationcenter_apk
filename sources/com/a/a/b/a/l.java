package com.a.a.b.a;

import com.a.a.n;
import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import com.a.a.s;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
/* compiled from: TypeAdapters.java */
/* loaded from: classes.dex */
public final class l {
    public static final r<StringBuffer> A;
    public static final q B;
    public static final r<URL> C;
    public static final q D;
    public static final r<URI> E;
    public static final q F;
    public static final r<InetAddress> G;
    public static final q H;
    public static final r<UUID> I;
    public static final q J;
    public static final q K;
    public static final r<Calendar> L;
    public static final q M;
    public static final r<Locale> N;
    public static final q O;
    public static final r<s> P;
    public static final q Q;
    public static final q R;

    /* renamed from: a  reason: collision with root package name */
    public static final r<Class> f999a;
    public static final q b;
    public static final r<BitSet> c;
    public static final q d;
    public static final r<Boolean> e;
    public static final r<Boolean> f;
    public static final q g;
    public static final r<Number> h;
    public static final q i;
    public static final r<Number> j;
    public static final q k;
    public static final r<Number> l;
    public static final q m;
    public static final r<Number> n;
    public static final r<Number> o;
    public static final r<Number> p;
    public static final r<Number> q;
    public static final q r;
    public static final r<Character> s;
    public static final q t;
    public static final r<String> u;
    public static final r<BigDecimal> v;
    public static final r<BigInteger> w;
    public static final q x;
    public static final r<StringBuilder> y;
    public static final q z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* renamed from: com.a.a.b.a.l$18  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass18 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1004a;

        static {
            int[] iArr = new int[com.a.a.c.c.values().length];
            f1004a = iArr;
            try {
                iArr[com.a.a.c.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1004a[com.a.a.c.c.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1004a[com.a.a.c.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1004a[com.a.a.c.c.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1004a[com.a.a.c.c.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1004a[com.a.a.c.c.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1004a[com.a.a.c.c.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1004a[com.a.a.c.c.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1004a[com.a.a.c.c.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1004a[com.a.a.c.c.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes.dex */
    private static final class a<T extends Enum<T>> extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f1006a = new HashMap();
        private final Map<T, String> b = new HashMap();

        public a(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.a.a.a.b bVar = (com.a.a.a.b) cls.getField(name).getAnnotation(com.a.a.a.b.class);
                    name = bVar != null ? bVar.a() : name;
                    this.f1006a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        public void a(com.a.a.c.b bVar, T t) throws IOException {
            bVar.b(t == null ? null : this.b.get(t));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.a.a.r
        public /* bridge */ /* synthetic */ void a(com.a.a.c.b bVar, Object obj) throws IOException {
            a(bVar, (com.a.a.c.b) ((Enum) obj));
        }

        @Override // com.a.a.r
        /* renamed from: b */
        public T a(com.a.a.c.a aVar) throws IOException {
            if (aVar.f() == com.a.a.c.c.NULL) {
                aVar.j();
                return null;
            }
            return this.f1006a.get(aVar.h());
        }
    }

    static {
        r<Class> rVar = new r<Class>() { // from class: com.a.a.b.a.l.1
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Class cls) throws IOException {
                if (cls != null) {
                    throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
                }
                bVar.f();
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Class a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        };
        f999a = rVar;
        b = a(Class.class, rVar);
        r<BitSet> rVar2 = new r<BitSet>() { // from class: com.a.a.b.a.l.4
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    bVar.f();
                    return;
                }
                bVar.b();
                for (int i2 = 0; i2 < bitSet.length(); i2++) {
                    bVar.a(bitSet.get(i2) ? 1L : 0L);
                }
                bVar.c();
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
                r5 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
                if (r8.m() != 0) goto L20;
             */
            @Override // com.a.a.r
            /* renamed from: b */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.BitSet a(com.a.a.c.a r8) throws java.io.IOException {
                /*
                    r7 = this;
                    com.a.a.c.c r0 = r8.f()
                    com.a.a.c.c r1 = com.a.a.c.c.NULL
                    if (r0 != r1) goto Ld
                    r8.j()
                    r8 = 0
                    return r8
                Ld:
                    java.util.BitSet r0 = new java.util.BitSet
                    r0.<init>()
                    r8.a()
                    com.a.a.c.c r1 = r8.f()
                    r2 = 0
                    r3 = r2
                L1b:
                    com.a.a.c.c r4 = com.a.a.c.c.END_ARRAY
                    if (r1 == r4) goto L86
                    int[] r4 = com.a.a.b.a.l.AnonymousClass18.f1004a
                    int r5 = r1.ordinal()
                    r4 = r4[r5]
                    r5 = 1
                    if (r4 == r5) goto L74
                    r6 = 2
                    if (r4 == r6) goto L6f
                    r6 = 3
                    if (r4 != r6) goto L56
                    java.lang.String r1 = r8.h()
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L3d
                    if (r1 == 0) goto L3b
                    goto L7a
                L3b:
                    r5 = r2
                    goto L7a
                L3d:
                    com.a.a.o r8 = new com.a.a.o
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                    java.lang.StringBuilder r0 = r0.append(r2)
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    r8.<init>(r0)
                    throw r8
                L56:
                    com.a.a.o r8 = new com.a.a.o
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r2 = "Invalid bitset value type: "
                    java.lang.StringBuilder r0 = r0.append(r2)
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    r8.<init>(r0)
                    throw r8
                L6f:
                    boolean r5 = r8.i()
                    goto L7a
                L74:
                    int r1 = r8.m()
                    if (r1 == 0) goto L3b
                L7a:
                    if (r5 == 0) goto L7f
                    r0.set(r3)
                L7f:
                    int r3 = r3 + 1
                    com.a.a.c.c r1 = r8.f()
                    goto L1b
                L86:
                    r8.b()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.a.l.AnonymousClass4.a(com.a.a.c.a):java.util.BitSet");
            }
        };
        c = rVar2;
        d = a(BitSet.class, rVar2);
        r<Boolean> rVar3 = new r<Boolean>() { // from class: com.a.a.b.a.l.15
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Boolean bool) throws IOException {
                if (bool == null) {
                    bVar.f();
                } else {
                    bVar.a(bool.booleanValue());
                }
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Boolean a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() != com.a.a.c.c.NULL) {
                    return aVar.f() == com.a.a.c.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.h())) : Boolean.valueOf(aVar.i());
                }
                aVar.j();
                return null;
            }
        };
        e = rVar3;
        f = new r<Boolean>() { // from class: com.a.a.b.a.l.19
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Boolean bool) throws IOException {
                bVar.b(bool == null ? "null" : bool.toString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Boolean a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Boolean.valueOf(aVar.h());
            }
        };
        g = a(Boolean.TYPE, Boolean.class, rVar3);
        r<Number> rVar4 = new r<Number>() { // from class: com.a.a.b.a.l.20
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        h = rVar4;
        i = a(Byte.TYPE, Byte.class, rVar4);
        r<Number> rVar5 = new r<Number>() { // from class: com.a.a.b.a.l.21
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Short.valueOf((short) aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        j = rVar5;
        k = a(Short.TYPE, Short.class, rVar5);
        r<Number> rVar6 = new r<Number>() { // from class: com.a.a.b.a.l.23
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.m());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        l = rVar6;
        m = a(Integer.TYPE, Integer.class, rVar6);
        n = new r<Number>() { // from class: com.a.a.b.a.l.24
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.l());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        o = new r<Number>() { // from class: com.a.a.b.a.l.25
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        };
        p = new r<Number>() { // from class: com.a.a.b.a.l.12
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        };
        r<Number> rVar7 = new r<Number>() { // from class: com.a.a.b.a.l.22
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                com.a.a.c.c f2 = aVar.f();
                int i2 = AnonymousClass18.f1004a[f2.ordinal()];
                if (i2 != 1) {
                    if (i2 == 4) {
                        aVar.j();
                        return null;
                    }
                    throw new o("Expecting number, got: " + f2);
                }
                return new com.a.a.b.f(aVar.h());
            }
        };
        q = rVar7;
        r = a(Number.class, rVar7);
        r<Character> rVar8 = new r<Character>() { // from class: com.a.a.b.a.l.26
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Character ch) throws IOException {
                bVar.b(ch == null ? null : String.valueOf(ch));
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Character a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if (h2.length() == 1) {
                    return Character.valueOf(h2.charAt(0));
                }
                throw new o("Expecting character, got: " + h2);
            }
        };
        s = rVar8;
        t = a(Character.TYPE, Character.class, rVar8);
        r<String> rVar9 = new r<String>() { // from class: com.a.a.b.a.l.27
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, String str) throws IOException {
                bVar.b(str);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public String a(com.a.a.c.a aVar) throws IOException {
                com.a.a.c.c f2 = aVar.f();
                if (f2 != com.a.a.c.c.NULL) {
                    return f2 == com.a.a.c.c.BOOLEAN ? Boolean.toString(aVar.i()) : aVar.h();
                }
                aVar.j();
                return null;
            }
        };
        u = rVar9;
        v = new r<BigDecimal>() { // from class: com.a.a.b.a.l.28
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, BigDecimal bigDecimal) throws IOException {
                bVar.a(bigDecimal);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public BigDecimal a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigDecimal(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        w = new r<BigInteger>() { // from class: com.a.a.b.a.l.29
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, BigInteger bigInteger) throws IOException {
                bVar.a(bigInteger);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public BigInteger a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    return new BigInteger(aVar.h());
                } catch (NumberFormatException e2) {
                    throw new o(e2);
                }
            }
        };
        x = a(String.class, rVar9);
        r<StringBuilder> rVar10 = new r<StringBuilder>() { // from class: com.a.a.b.a.l.30
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, StringBuilder sb) throws IOException {
                bVar.b(sb == null ? null : sb.toString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public StringBuilder a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuilder(aVar.h());
            }
        };
        y = rVar10;
        z = a(StringBuilder.class, rVar10);
        r<StringBuffer> rVar11 = new r<StringBuffer>() { // from class: com.a.a.b.a.l.31
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, StringBuffer stringBuffer) throws IOException {
                bVar.b(stringBuffer == null ? null : stringBuffer.toString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public StringBuffer a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return new StringBuffer(aVar.h());
            }
        };
        A = rVar11;
        B = a(StringBuffer.class, rVar11);
        r<URL> rVar12 = new r<URL>() { // from class: com.a.a.b.a.l.2
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, URL url) throws IOException {
                bVar.b(url == null ? null : url.toExternalForm());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public URL a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                String h2 = aVar.h();
                if ("null".equals(h2)) {
                    return null;
                }
                return new URL(h2);
            }
        };
        C = rVar12;
        D = a(URL.class, rVar12);
        r<URI> rVar13 = new r<URI>() { // from class: com.a.a.b.a.l.3
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, URI uri) throws IOException {
                bVar.b(uri == null ? null : uri.toASCIIString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public URI a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                try {
                    String h2 = aVar.h();
                    if ("null".equals(h2)) {
                        return null;
                    }
                    return new URI(h2);
                } catch (URISyntaxException e2) {
                    throw new com.a.a.i(e2);
                }
            }
        };
        E = rVar13;
        F = a(URI.class, rVar13);
        r<InetAddress> rVar14 = new r<InetAddress>() { // from class: com.a.a.b.a.l.5
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, InetAddress inetAddress) throws IOException {
                bVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public InetAddress a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return InetAddress.getByName(aVar.h());
            }
        };
        G = rVar14;
        H = b(InetAddress.class, rVar14);
        r<UUID> rVar15 = new r<UUID>() { // from class: com.a.a.b.a.l.6
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, UUID uuid) throws IOException {
                bVar.b(uuid == null ? null : uuid.toString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public UUID a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return UUID.fromString(aVar.h());
            }
        };
        I = rVar15;
        J = a(UUID.class, rVar15);
        K = new q() { // from class: com.a.a.b.a.l.7
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                if (aVar.a() != Timestamp.class) {
                    return null;
                }
                final r<T> a2 = eVar.a((Class) Date.class);
                return (r<T>) new r<Timestamp>() { // from class: com.a.a.b.a.l.7.1
                    @Override // com.a.a.r
                    public void a(com.a.a.c.b bVar, Timestamp timestamp) throws IOException {
                        a2.a(bVar, timestamp);
                    }

                    @Override // com.a.a.r
                    /* renamed from: b */
                    public Timestamp a(com.a.a.c.a aVar2) throws IOException {
                        Date date = (Date) a2.a(aVar2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }
                };
            }
        };
        r<Calendar> rVar16 = new r<Calendar>() { // from class: com.a.a.b.a.l.8
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    bVar.f();
                    return;
                }
                bVar.d();
                bVar.a("year");
                bVar.a(calendar.get(1));
                bVar.a("month");
                bVar.a(calendar.get(2));
                bVar.a("dayOfMonth");
                bVar.a(calendar.get(5));
                bVar.a("hourOfDay");
                bVar.a(calendar.get(11));
                bVar.a("minute");
                bVar.a(calendar.get(12));
                bVar.a("second");
                bVar.a(calendar.get(13));
                bVar.e();
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Calendar a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                aVar.c();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (aVar.f() != com.a.a.c.c.END_OBJECT) {
                    String g2 = aVar.g();
                    int m2 = aVar.m();
                    if ("year".equals(g2)) {
                        i2 = m2;
                    } else if ("month".equals(g2)) {
                        i3 = m2;
                    } else if ("dayOfMonth".equals(g2)) {
                        i4 = m2;
                    } else if ("hourOfDay".equals(g2)) {
                        i5 = m2;
                    } else if ("minute".equals(g2)) {
                        i6 = m2;
                    } else if ("second".equals(g2)) {
                        i7 = m2;
                    }
                }
                aVar.d();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }
        };
        L = rVar16;
        M = b(Calendar.class, GregorianCalendar.class, rVar16);
        r<Locale> rVar17 = new r<Locale>() { // from class: com.a.a.b.a.l.9
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Locale locale) throws IOException {
                bVar.b(locale == null ? null : locale.toString());
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Locale a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }
        };
        N = rVar17;
        O = a(Locale.class, rVar17);
        r<s> rVar18 = new r<s>() { // from class: com.a.a.b.a.l.10
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, s sVar) throws IOException {
                if (sVar == null || sVar.n()) {
                    bVar.f();
                } else if (sVar.m()) {
                    n q2 = sVar.q();
                    if (q2.i()) {
                        bVar.a(q2.a());
                    } else if (q2.g()) {
                        bVar.a(q2.f());
                    } else {
                        bVar.b(q2.b());
                    }
                } else if (sVar.k()) {
                    bVar.b();
                    Iterator<s> it = sVar.p().iterator();
                    while (it.hasNext()) {
                        a(bVar, it.next());
                    }
                    bVar.c();
                } else if (!sVar.l()) {
                    throw new IllegalArgumentException("Couldn't write " + sVar.getClass());
                } else {
                    bVar.d();
                    for (Map.Entry<String, s> entry : sVar.o().g()) {
                        bVar.a(entry.getKey());
                        a(bVar, entry.getValue());
                    }
                    bVar.e();
                }
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public s a(com.a.a.c.a aVar) throws IOException {
                switch (AnonymousClass18.f1004a[aVar.f().ordinal()]) {
                    case 1:
                        return new n(new com.a.a.b.f(aVar.h()));
                    case 2:
                        return new n(Boolean.valueOf(aVar.i()));
                    case 3:
                        return new n(aVar.h());
                    case 4:
                        aVar.j();
                        return com.a.a.j.f1053a;
                    case 5:
                        com.a.a.h hVar = new com.a.a.h();
                        aVar.a();
                        while (aVar.e()) {
                            hVar.a(a(aVar));
                        }
                        aVar.b();
                        return hVar;
                    case 6:
                        com.a.a.l lVar = new com.a.a.l();
                        aVar.c();
                        while (aVar.e()) {
                            lVar.a(aVar.g(), a(aVar));
                        }
                        aVar.d();
                        return lVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        };
        P = rVar18;
        Q = b(s.class, rVar18);
        R = a();
    }

    public static q a() {
        return new q() { // from class: com.a.a.b.a.l.11
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                Class a2 = aVar.a();
                if (!Enum.class.isAssignableFrom(a2) || a2 == Enum.class) {
                    return null;
                }
                if (!a2.isEnum()) {
                    a2 = (Class<? super Object>) a2.getSuperclass();
                }
                return new a(a2);
            }
        };
    }

    public static <TT> q a(final Class<TT> cls, final r<TT> rVar) {
        return new q() { // from class: com.a.a.b.a.l.13
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                if (aVar.a() == cls) {
                    return rVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + rVar + "]";
            }
        };
    }

    public static <TT> q a(final Class<TT> cls, final Class<TT> cls2, final r<? super TT> rVar) {
        return new q() { // from class: com.a.a.b.a.l.14
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return rVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + rVar + "]";
            }
        };
    }

    public static <TT> q b(final Class<TT> cls, final r<TT> rVar) {
        return new q() { // from class: com.a.a.b.a.l.17
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                if (cls.isAssignableFrom(aVar.a())) {
                    return rVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + rVar + "]";
            }
        };
    }

    public static <TT> q b(final Class<TT> cls, final Class<? extends TT> cls2, final r<? super TT> rVar) {
        return new q() { // from class: com.a.a.b.a.l.16
            @Override // com.a.a.q
            public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
                Class<? super T> a2 = aVar.a();
                if (a2 == cls || a2 == cls2) {
                    return rVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + rVar + "]";
            }
        };
    }
}

package com.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    final g f1045a;
    final m b;
    private final ThreadLocal<Map<com.a.a.d.a<?>, a<?>>> c;
    private final Map<com.a.a.d.a<?>, r<?>> d;
    private final List<q> e;
    private final com.a.a.b.d f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Gson.java */
    /* loaded from: classes.dex */
    public static class a<T> extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private r<T> f1051a;

        a() {
        }

        @Override // com.a.a.r
        public T a(com.a.a.c.a aVar) throws IOException {
            r<T> rVar = this.f1051a;
            if (rVar != null) {
                return rVar.a(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.a.a.r
        public void a(com.a.a.c.b bVar, T t) throws IOException {
            r<T> rVar = this.f1051a;
            if (rVar == null) {
                throw new IllegalStateException();
            }
            rVar.a(bVar, t);
        }

        public void a(r<T> rVar) {
            if (this.f1051a != null) {
                throw new AssertionError();
            }
            this.f1051a = rVar;
        }
    }

    public e() {
        this(com.a.a.b.c.f1011a, b.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, p.DEFAULT, Collections.emptyList());
    }

    e(com.a.a.b.c cVar, d dVar, Map<Type, f<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, p pVar, List<q> list) {
        this.c = new ThreadLocal<>();
        this.d = Collections.synchronizedMap(new HashMap());
        this.f1045a = new g() { // from class: com.a.a.e.1
        };
        this.b = new m() { // from class: com.a.a.e.2
        };
        com.a.a.b.d dVar2 = new com.a.a.b.d(map);
        this.f = dVar2;
        this.g = z;
        this.i = z3;
        this.h = z4;
        this.j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.a.a.b.a.l.Q);
        arrayList.add(com.a.a.b.a.h.f994a);
        arrayList.add(cVar);
        arrayList.addAll(list);
        arrayList.add(com.a.a.b.a.l.x);
        arrayList.add(com.a.a.b.a.l.m);
        arrayList.add(com.a.a.b.a.l.g);
        arrayList.add(com.a.a.b.a.l.i);
        arrayList.add(com.a.a.b.a.l.k);
        arrayList.add(com.a.a.b.a.l.a(Long.TYPE, Long.class, a(pVar)));
        arrayList.add(com.a.a.b.a.l.a(Double.TYPE, Double.class, a(z6)));
        arrayList.add(com.a.a.b.a.l.a(Float.TYPE, Float.class, b(z6)));
        arrayList.add(com.a.a.b.a.l.r);
        arrayList.add(com.a.a.b.a.l.t);
        arrayList.add(com.a.a.b.a.l.z);
        arrayList.add(com.a.a.b.a.l.B);
        arrayList.add(com.a.a.b.a.l.a(BigDecimal.class, com.a.a.b.a.l.v));
        arrayList.add(com.a.a.b.a.l.a(BigInteger.class, com.a.a.b.a.l.w));
        arrayList.add(com.a.a.b.a.l.D);
        arrayList.add(com.a.a.b.a.l.F);
        arrayList.add(com.a.a.b.a.l.J);
        arrayList.add(com.a.a.b.a.l.O);
        arrayList.add(com.a.a.b.a.l.H);
        arrayList.add(com.a.a.b.a.l.d);
        arrayList.add(com.a.a.b.a.d.f987a);
        arrayList.add(com.a.a.b.a.l.M);
        arrayList.add(com.a.a.b.a.j.f997a);
        arrayList.add(com.a.a.b.a.k.f998a);
        arrayList.add(com.a.a.b.a.l.K);
        arrayList.add(com.a.a.b.a.a.f983a);
        arrayList.add(com.a.a.b.a.l.R);
        arrayList.add(com.a.a.b.a.l.b);
        arrayList.add(new com.a.a.b.a.b(dVar2));
        arrayList.add(new com.a.a.b.a.f(dVar2, z2));
        arrayList.add(new com.a.a.b.a.g(dVar2, dVar, cVar));
        this.e = Collections.unmodifiableList(arrayList);
    }

    private com.a.a.c.b a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        com.a.a.c.b bVar = new com.a.a.c.b(writer);
        if (this.j) {
            bVar.c("  ");
        }
        bVar.d(this.g);
        return bVar;
    }

    private r<Number> a(p pVar) {
        return pVar == p.DEFAULT ? com.a.a.b.a.l.n : new r<Number>() { // from class: com.a.a.e.5
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.f();
                } else {
                    bVar.b(number.toString());
                }
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Number a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Long.valueOf(aVar.l());
            }
        };
    }

    private r<Number> a(boolean z) {
        return z ? com.a.a.b.a.l.p : new r<Number>() { // from class: com.a.a.e.3
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.f();
                    return;
                }
                e.this.a(number.doubleValue());
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Double a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object obj, com.a.a.c.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() == com.a.a.c.c.END_DOCUMENT) {
                    return;
                }
                throw new i("JSON document was not fully consumed.");
            } catch (com.a.a.c.d e) {
                throw new o(e);
            } catch (IOException e2) {
                throw new i(e2);
            }
        }
    }

    private r<Number> b(boolean z) {
        return z ? com.a.a.b.a.l.o : new r<Number>() { // from class: com.a.a.e.4
            @Override // com.a.a.r
            public void a(com.a.a.c.b bVar, Number number) throws IOException {
                if (number == null) {
                    bVar.f();
                    return;
                }
                e.this.a(number.floatValue());
                bVar.a(number);
            }

            @Override // com.a.a.r
            /* renamed from: b */
            public Float a(com.a.a.c.a aVar) throws IOException {
                if (aVar.f() == com.a.a.c.c.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> r<T> a(com.a.a.d.a<T> aVar) {
        r<T> rVar = (r<T>) this.d.get(aVar);
        if (rVar != null) {
            return rVar;
        }
        Map<com.a.a.d.a<?>, a<?>> map = this.c.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.c.set(map);
            z = true;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            for (q qVar : this.e) {
                r rVar2 = (r<T>) qVar.a(this, aVar);
                if (rVar2 != null) {
                    aVar3.a((r<?>) rVar2);
                    this.d.put(aVar, rVar2);
                    return rVar2;
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.c.remove();
            }
        }
    }

    public <T> r<T> a(q qVar, com.a.a.d.a<T> aVar) {
        boolean z = false;
        for (q qVar2 : this.e) {
            if (z) {
                r<T> a2 = qVar2.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (qVar2 == qVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> r<T> a(Class<T> cls) {
        return a((com.a.a.d.a) com.a.a.d.a.b(cls));
    }

    public <T> T a(com.a.a.c.a aVar, Type type) throws i, o {
        boolean p = aVar.p();
        boolean z = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    T a2 = a((com.a.a.d.a) com.a.a.d.a.a(type)).a(aVar);
                    aVar.a(p);
                    return a2;
                } catch (IOException e) {
                    throw new o(e);
                }
            } catch (EOFException e2) {
                if (z) {
                    aVar.a(p);
                    return null;
                }
                throw new o(e2);
            } catch (IllegalStateException e3) {
                throw new o(e3);
            }
        } catch (Throwable th) {
            aVar.a(p);
            throw th;
        }
    }

    public <T> T a(Reader reader, Type type) throws i, o {
        com.a.a.c.a aVar = new com.a.a.c.a(reader);
        T t = (T) a(aVar, type);
        a(t, aVar);
        return t;
    }

    public <T> T a(String str, Class<T> cls) throws o {
        return (T) com.a.a.b.k.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws o {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public String a(s sVar) {
        StringWriter stringWriter = new StringWriter();
        a(sVar, stringWriter);
        return stringWriter.toString();
    }

    public String a(Object obj) {
        return obj == null ? a((s) j.f1053a) : a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(s sVar, com.a.a.c.b bVar) throws i {
        boolean g = bVar.g();
        bVar.b(true);
        boolean h = bVar.h();
        bVar.c(this.h);
        boolean i = bVar.i();
        bVar.d(this.g);
        try {
            try {
                com.a.a.b.j.a(sVar, bVar);
            } catch (IOException e) {
                throw new i(e);
            }
        } finally {
            bVar.b(g);
            bVar.c(h);
            bVar.d(i);
        }
    }

    public void a(s sVar, Appendable appendable) throws i {
        try {
            a(sVar, a(com.a.a.b.j.a(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void a(Object obj, Type type, com.a.a.c.b bVar) throws i {
        r a2 = a((com.a.a.d.a) com.a.a.d.a.a(type));
        boolean g = bVar.g();
        bVar.b(true);
        boolean h = bVar.h();
        bVar.c(this.h);
        boolean i = bVar.i();
        bVar.d(this.g);
        try {
            try {
                a2.a(bVar, obj);
            } catch (IOException e) {
                throw new i(e);
            }
        } finally {
            bVar.b(g);
            bVar.c(h);
            bVar.d(i);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) throws i {
        try {
            a(obj, type, a(com.a.a.b.j.a(appendable)));
        } catch (IOException e) {
            throw new i(e);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }
}

package com.a.a.b.a;

import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.a.a.b.d f991a;
    private final com.a.a.d b;
    private final com.a.a.b.c c;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends r<T> {

        /* renamed from: a  reason: collision with root package name */
        private final com.a.a.b.g<T> f993a;
        private final Map<String, b> b;

        private a(com.a.a.b.g<T> gVar, Map<String, b> map) {
            this.f993a = gVar;
            this.b = map;
        }

        @Override // com.a.a.r
        public T a(com.a.a.c.a aVar) throws IOException {
            if (aVar.f() == com.a.a.c.c.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.f993a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.b.get(aVar.g());
                    if (bVar != null && bVar.i) {
                        bVar.a(aVar, a2);
                    }
                    aVar.n();
                }
                aVar.d();
                return a2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new o(e2);
            }
        }

        @Override // com.a.a.r
        public void a(com.a.a.c.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.f();
                return;
            }
            bVar.d();
            try {
                for (b bVar2 : this.b.values()) {
                    if (bVar2.h) {
                        bVar.a(bVar2.g);
                        bVar2.a(bVar, t);
                    }
                }
                bVar.e();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        protected b(String str, boolean z, boolean z2) {
            this.g = str;
            this.h = z;
            this.i = z2;
        }

        abstract void a(com.a.a.c.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void a(com.a.a.c.b bVar, Object obj) throws IOException, IllegalAccessException;
    }

    public g(com.a.a.b.d dVar, com.a.a.d dVar2, com.a.a.b.c cVar) {
        this.f991a = dVar;
        this.b = dVar2;
        this.c = cVar;
    }

    private b a(com.a.a.e eVar, Field field, String str, com.a.a.d.a<?> aVar, boolean z, boolean z2) {
        return new b(str, z, z2, eVar, aVar, field, com.a.a.b.k.a((Type) aVar.a())) { // from class: com.a.a.b.a.g.1

            /* renamed from: a  reason: collision with root package name */
            final r<?> f992a;
            final /* synthetic */ com.a.a.e b;
            final /* synthetic */ com.a.a.d.a c;
            final /* synthetic */ Field d;
            final /* synthetic */ boolean e;

            {
                this.b = eVar;
                this.c = aVar;
                this.d = field;
                this.e = r8;
                this.f992a = eVar.a(aVar);
            }

            @Override // com.a.a.b.a.g.b
            void a(com.a.a.c.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object a2 = this.f992a.a(aVar2);
                if (a2 == null && this.e) {
                    return;
                }
                this.d.set(obj, a2);
            }

            @Override // com.a.a.b.a.g.b
            void a(com.a.a.c.b bVar, Object obj) throws IOException, IllegalAccessException {
                new i(this.b, this.f992a, this.c.b()).a(bVar, (com.a.a.c.b) this.d.get(obj));
            }
        };
    }

    private String a(Field field) {
        com.a.a.a.b bVar = (com.a.a.a.b) field.getAnnotation(com.a.a.a.b.class);
        return bVar == null ? this.b.O000000o(field) : bVar.a();
    }

    private Map<String, b> a(com.a.a.e eVar, com.a.a.d.a<?> aVar, Class<?> cls) {
        Field[] declaredFields;
        b bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        com.a.a.d.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            for (Field field : cls2.getDeclaredFields()) {
                boolean a2 = a(field, true);
                boolean a3 = a(field, false);
                if (a2 || a3) {
                    field.setAccessible(true);
                    b a4 = a(eVar, field, a(field), com.a.a.d.a.a(com.a.a.b.b.a(aVar2.b(), cls2, field.getGenericType())), a2, a3);
                    if (((b) linkedHashMap.put(a4.g, a4)) != null) {
                        throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.g);
                    }
                }
            }
            aVar2 = com.a.a.d.a.a(com.a.a.b.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }

    @Override // com.a.a.q
    public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new a(this.f991a.a(aVar), a(eVar, aVar, a2));
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        return (this.c.a(field.getType(), z) || this.c.a(field, z)) ? false : true;
    }
}

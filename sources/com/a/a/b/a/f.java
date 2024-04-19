package com.a.a.b.a;

import com.a.a.n;
import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import com.a.a.s;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class f implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.a.a.b.d f989a;
    private final boolean b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private final class a<K, V> extends r<Map<K, V>> {
        private final r<K> b;
        private final r<V> c;
        private final com.a.a.b.g<? extends Map<K, V>> d;

        public a(com.a.a.e eVar, Type type, r<K> rVar, Type type2, r<V> rVar2, com.a.a.b.g<? extends Map<K, V>> gVar) {
            this.b = new i(eVar, rVar, type);
            this.c = new i(eVar, rVar2, type2);
            this.d = gVar;
        }

        private String a(s sVar) {
            if (!sVar.m()) {
                if (sVar.n()) {
                    return "null";
                }
                throw new AssertionError();
            }
            n q = sVar.q();
            if (q.i()) {
                return String.valueOf(q.a());
            }
            if (q.g()) {
                return Boolean.toString(q.f());
            }
            if (q.j()) {
                return q.b();
            }
            throw new AssertionError();
        }

        @Override // com.a.a.r
        public /* bridge */ /* synthetic */ void a(com.a.a.c.b bVar, Object obj) throws IOException {
            a(bVar, (Map) ((Map) obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.a.a.c.b bVar, Map<K, V> map) throws IOException {
            if (map == null) {
                bVar.f();
            } else if (!f.this.b) {
                bVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.a(String.valueOf(entry.getKey()));
                    this.c.a(bVar, entry.getValue());
                }
                bVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    s a2 = this.b.a((r<K>) entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= a2.k() || a2.l();
                }
                if (!z) {
                    bVar.d();
                    while (i < arrayList.size()) {
                        bVar.a(a((s) arrayList.get(i)));
                        this.c.a(bVar, arrayList2.get(i));
                        i++;
                    }
                    bVar.e();
                    return;
                }
                bVar.b();
                while (i < arrayList.size()) {
                    bVar.b();
                    com.a.a.b.j.a((s) arrayList.get(i), bVar);
                    this.c.a(bVar, arrayList2.get(i));
                    bVar.c();
                    i++;
                }
                bVar.c();
            }
        }

        @Override // com.a.a.r
        /* renamed from: b */
        public Map<K, V> a(com.a.a.c.a aVar) throws IOException {
            com.a.a.c.c f = aVar.f();
            if (f == com.a.a.c.c.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> a2 = this.d.a();
            if (f == com.a.a.c.c.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K a3 = this.b.a(aVar);
                    if (a2.put(a3, this.c.a(aVar)) != null) {
                        throw new o("duplicate key: " + a3);
                    }
                    aVar.b();
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.a.a.b.e.f1026a.a(aVar);
                    K a4 = this.b.a(aVar);
                    if (a2.put(a4, this.c.a(aVar)) != null) {
                        throw new o("duplicate key: " + a4);
                    }
                }
                aVar.d();
            }
            return a2;
        }
    }

    public f(com.a.a.b.d dVar, boolean z) {
        this.f989a = dVar;
        this.b = z;
    }

    private r<?> a(com.a.a.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? l.f : eVar.a((com.a.a.d.a) com.a.a.d.a.a(type));
    }

    @Override // com.a.a.q
    public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
        Type b = aVar.b();
        if (Map.class.isAssignableFrom(aVar.a())) {
            Type[] b2 = com.a.a.b.b.b(b, com.a.a.b.b.e(b));
            return new a(eVar, b2[0], a(eVar, b2[0]), b2[1], eVar.a((com.a.a.d.a) com.a.a.d.a.a(b2[1])), this.f989a.a(aVar));
        }
        return null;
    }
}

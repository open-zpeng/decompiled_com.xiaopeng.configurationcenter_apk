package com.a.a.b.a;

import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    private final com.a.a.b.d f984a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes.dex */
    private static final class a<E> extends r<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final r<E> f985a;
        private final com.a.a.b.g<? extends Collection<E>> b;

        public a(com.a.a.e eVar, Type type, r<E> rVar, com.a.a.b.g<? extends Collection<E>> gVar) {
            this.f985a = new i(eVar, rVar, type);
            this.b = gVar;
        }

        @Override // com.a.a.r
        public /* bridge */ /* synthetic */ void a(com.a.a.c.b bVar, Object obj) throws IOException {
            a(bVar, (Collection) ((Collection) obj));
        }

        public void a(com.a.a.c.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.f();
                return;
            }
            bVar.b();
            for (E e : collection) {
                this.f985a.a(bVar, e);
            }
            bVar.c();
        }

        @Override // com.a.a.r
        /* renamed from: b */
        public Collection<E> a(com.a.a.c.a aVar) throws IOException {
            if (aVar.f() == com.a.a.c.c.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> a2 = this.b.a();
            aVar.a();
            while (aVar.e()) {
                a2.add(this.f985a.a(aVar));
            }
            aVar.b();
            return a2;
        }
    }

    public b(com.a.a.b.d dVar) {
        this.f984a = dVar;
    }

    @Override // com.a.a.q
    public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
        Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (Collection.class.isAssignableFrom(a2)) {
            Type a3 = com.a.a.b.b.a(b, (Class<?>) a2);
            return new a(eVar, a3, eVar.a((com.a.a.d.a) com.a.a.d.a.a(a3)), this.f984a.a(aVar));
        }
        return null;
    }
}

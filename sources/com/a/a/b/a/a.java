package com.a.a.b.a;

import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends r<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f983a = new q() { // from class: com.a.a.b.a.a.1
        @Override // com.a.a.q
        public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
            Type b = aVar.b();
            if ((b instanceof GenericArrayType) || ((b instanceof Class) && ((Class) b).isArray())) {
                Type g = com.a.a.b.b.g(b);
                return new a(eVar, eVar.a((com.a.a.d.a) com.a.a.d.a.a(g)), com.a.a.b.b.e(g));
            }
            return null;
        }
    };
    private final Class<E> b;
    private final r<E> c;

    public a(com.a.a.e eVar, r<E> rVar, Class<E> cls) {
        this.c = new i(eVar, rVar, cls);
        this.b = cls;
    }

    @Override // com.a.a.r
    public Object a(com.a.a.c.a aVar) throws IOException {
        if (aVar.f() == com.a.a.c.c.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.a(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance((Class<?>) this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.a.a.r
    public void a(com.a.a.c.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.f();
            return;
        }
        bVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(bVar, Array.get(obj, i));
        }
        bVar.c();
    }
}

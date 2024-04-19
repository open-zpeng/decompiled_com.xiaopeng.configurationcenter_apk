package com.a.a.b.a;

import com.a.a.b.a.g;
import com.a.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class i<T> extends r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final com.a.a.e f996a;
    private final r<T> b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.a.a.e eVar, r<T> rVar, Type type) {
        this.f996a = eVar;
        this.b = rVar;
        this.c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.a.a.r
    public T a(com.a.a.c.a aVar) throws IOException {
        return this.b.a(aVar);
    }

    @Override // com.a.a.r
    public void a(com.a.a.c.b bVar, T t) throws IOException {
        r<T> rVar = this.b;
        Type a2 = a(this.c, t);
        if (a2 != this.c) {
            rVar = this.f996a.a((com.a.a.d.a) com.a.a.d.a.a(a2));
            if (rVar instanceof g.a) {
                r<T> rVar2 = this.b;
                if (!(rVar2 instanceof g.a)) {
                    rVar = rVar2;
                }
            }
        }
        rVar.a(bVar, t);
    }
}

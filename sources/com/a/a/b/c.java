package com.a.a.b;

import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class c implements q, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final c f1011a = new c();
    private boolean e;
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List<com.a.a.a> f = Collections.emptyList();
    private List<com.a.a.a> g = Collections.emptyList();

    private boolean a(com.a.a.a.c cVar) {
        return cVar == null || cVar.a() > this.b;
    }

    private boolean a(com.a.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.b;
    }

    private boolean a(com.a.a.a.d dVar, com.a.a.a.c cVar) {
        return a(dVar) && a(cVar);
    }

    private boolean a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.a.a.q
    public <T> r<T> a(final com.a.a.e eVar, final com.a.a.d.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        final boolean a3 = a((Class<?>) a2, true);
        final boolean a4 = a((Class<?>) a2, false);
        if (a3 || a4) {
            return new r<T>() { // from class: com.a.a.b.c.1
                private r<T> f;

                private r<T> a() {
                    r<T> rVar = this.f;
                    if (rVar != null) {
                        return rVar;
                    }
                    r<T> a5 = eVar.a(c.this, aVar);
                    this.f = a5;
                    return a5;
                }

                @Override // com.a.a.r
                public T a(com.a.a.c.a aVar2) throws IOException {
                    if (a4) {
                        aVar2.n();
                        return null;
                    }
                    return a().a(aVar2);
                }

                @Override // com.a.a.r
                public void a(com.a.a.c.b bVar, T t) throws IOException {
                    if (a3) {
                        bVar.f();
                    } else {
                        a().a(bVar, t);
                    }
                }
            };
        }
        return null;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.b == -1.0d || a((com.a.a.a.d) cls.getAnnotation(com.a.a.a.d.class), (com.a.a.a.c) cls.getAnnotation(com.a.a.a.c.class))) {
            if ((this.d || !b(cls)) && !a(cls)) {
                for (com.a.a.a aVar : z ? this.f : this.g) {
                    if (aVar.a(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean a(Field field, boolean z) {
        com.a.a.a.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.b == -1.0d || a((com.a.a.a.d) field.getAnnotation(com.a.a.a.d.class), (com.a.a.a.c) field.getAnnotation(com.a.a.a.c.class))) && !field.isSynthetic()) {
            if (!this.e || ((aVar = (com.a.a.a.a) field.getAnnotation(com.a.a.a.a.class)) != null && (!z ? !aVar.b() : !aVar.a()))) {
                if ((this.d || !b(field.getType())) && !a(field.getType())) {
                    List<com.a.a.a> list = z ? this.f : this.g;
                    if (list.isEmpty()) {
                        return false;
                    }
                    com.a.a.c cVar = new com.a.a.c(field);
                    for (com.a.a.a aVar2 : list) {
                        if (aVar2.a(cVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}

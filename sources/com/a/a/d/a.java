package com.a.a.d;

import com.a.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* compiled from: TypeToken.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<? super T> f1044a;
    final Type b;
    final int c;

    protected a() {
        Type a2 = a(getClass());
        this.b = a2;
        this.f1044a = (Class<? super T>) b.e(a2);
        this.c = a2.hashCode();
    }

    a(Type type) {
        Type d = b.d((Type) com.a.a.b.a.a(type));
        this.b = d;
        this.f1044a = (Class<? super T>) b.e(d);
        this.c = d.hashCode();
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public final Class<? super T> a() {
        return this.f1044a;
    }

    public final Type b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.f(this.b);
    }
}

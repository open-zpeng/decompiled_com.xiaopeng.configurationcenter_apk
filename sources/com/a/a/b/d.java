package com.a.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* compiled from: ConstructorConstructor.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Type, com.a.a.f<?>> f1013a;

    public d(Map<Type, com.a.a.f<?>> map) {
        this.f1013a = map;
    }

    private <T> g<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new g<T>() { // from class: com.a.a.b.d.9
                @Override // com.a.a.b.g
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> g<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new g<T>() { // from class: com.a.a.b.d.10
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(cls) ? new g<T>() { // from class: com.a.a.b.d.11
                @Override // com.a.a.b.g
                public T a() {
                    Type type2 = type;
                    if (type2 instanceof ParameterizedType) {
                        Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        if (type3 instanceof Class) {
                            return (T) EnumSet.noneOf((Class) type3);
                        }
                        throw new com.a.a.i("Invalid EnumSet type: " + type.toString());
                    }
                    throw new com.a.a.i("Invalid EnumSet type: " + type.toString());
                }
            } : Set.class.isAssignableFrom(cls) ? new g<T>() { // from class: com.a.a.b.d.12
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new g<T>() { // from class: com.a.a.b.d.2
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new LinkedList();
                }
            } : new g<T>() { // from class: com.a.a.b.d.3
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new g<T>() { // from class: com.a.a.b.d.4
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.a.a.d.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new g<T>() { // from class: com.a.a.b.d.6
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new h();
                }
            } : new g<T>() { // from class: com.a.a.b.d.5
                @Override // com.a.a.b.g
                public T a() {
                    return (T) new LinkedHashMap();
                }
            };
        } else {
            return null;
        }
    }

    private <T> g<T> b(final Type type, final Class<? super T> cls) {
        return new g<T>() { // from class: com.a.a.b.d.7
            private final i d = i.a();

            @Override // com.a.a.b.g
            public T a() {
                try {
                    return (T) this.d.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public <T> g<T> a(com.a.a.d.a<T> aVar) {
        final Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        final com.a.a.f<?> fVar = this.f1013a.get(b);
        if (fVar != null) {
            return new g<T>() { // from class: com.a.a.b.d.1
                @Override // com.a.a.b.g
                public T a() {
                    return (T) fVar.a(b);
                }
            };
        }
        final com.a.a.f<?> fVar2 = this.f1013a.get(a2);
        if (fVar2 != null) {
            return new g<T>() { // from class: com.a.a.b.d.8
                @Override // com.a.a.b.g
                public T a() {
                    return (T) fVar2.a(b);
                }
            };
        }
        g<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        g<T> a4 = a(b, a2);
        return a4 != null ? a4 : b(b, a2);
    }

    public String toString() {
        return this.f1013a.toString();
    }
}

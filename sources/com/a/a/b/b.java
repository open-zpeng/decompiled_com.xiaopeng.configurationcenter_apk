package com.a.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
/* compiled from: $Gson$Types.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final Type[] f1007a = new Type[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* loaded from: classes.dex */
    public static final class a implements Serializable, GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f1008a;

        public a(Type type) {
            this.f1008a = b.d(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) ((GenericArrayType) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f1008a;
        }

        public int hashCode() {
            return this.f1008a.hashCode();
        }

        public String toString() {
            return b.f(this.f1008a) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* renamed from: com.a.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0065b implements Serializable, ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f1009a;
        private final Type b;
        private final Type[] c;

        public C0065b(Type type, Type type2, Type... typeArr) {
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                com.a.a.b.a.a(type != null || cls.getEnclosingClass() == null);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                com.a.a.b.a.a(z);
            }
            this.f1009a = type == null ? null : b.d(type);
            this.b = b.d(type2);
            this.c = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.c;
                if (i >= typeArr2.length) {
                    return;
                }
                com.a.a.b.a.a(typeArr2[i]);
                b.i(this.c[i]);
                Type[] typeArr3 = this.c;
                typeArr3[i] = b.d(typeArr3[i]);
                i++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) ((ParameterizedType) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f1009a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ b.b((Object) this.f1009a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.c.length + 1) * 30);
            sb.append(b.f(this.b));
            if (this.c.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(b.f(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                sb.append(", ").append(b.f(this.c[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: $Gson$Types.java */
    /* loaded from: classes.dex */
    public static final class c implements Serializable, WildcardType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f1010a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            Type d;
            com.a.a.b.a.a(typeArr2.length <= 1);
            com.a.a.b.a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                com.a.a.b.a.a(typeArr2[0]);
                b.i(typeArr2[0]);
                com.a.a.b.a.a(typeArr[0] == Object.class);
                this.b = b.d(typeArr2[0]);
                d = Object.class;
            } else {
                com.a.a.b.a.a(typeArr[0]);
                b.i(typeArr[0]);
                this.b = null;
                d = b.d(typeArr[0]);
            }
            this.f1010a = d;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.a((Type) this, (Type) ((WildcardType) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.b;
            return type != null ? new Type[]{type} : b.f1007a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f1010a};
        }

        public int hashCode() {
            Type type = this.b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f1010a.hashCode() + 31);
        }

        public String toString() {
            StringBuilder append;
            Type type;
            if (this.b != null) {
                append = new StringBuilder().append("? super ");
                type = this.b;
            } else if (this.f1010a == Object.class) {
                return "?";
            } else {
                append = new StringBuilder().append("? extends ");
                type = this.f1010a;
            }
            return append.append(b.f(type)).toString();
        }
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static ParameterizedType a(Type type, Type type2, Type... typeArr) {
        return new C0065b(type, type2, typeArr);
    }

    public static Type a(Type type, Class<?> cls) {
        Type b = b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments()[0] : Object.class;
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto Lf
            java.lang.reflect.TypeVariable r10 = (java.lang.reflect.TypeVariable) r10
            java.lang.reflect.Type r0 = a(r8, r9, r10)
            if (r0 != r10) goto Ld
            return r0
        Ld:
            r10 = r0
            goto L0
        Lf:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L2c
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L2c
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r10)
            if (r10 != r8) goto L27
            goto L2b
        L27:
            java.lang.reflect.GenericArrayType r0 = a(r8)
        L2b:
            return r0
        L2c:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L42
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r0)
            if (r0 != r8) goto L3d
            goto L41
        L3d:
            java.lang.reflect.GenericArrayType r10 = a(r8)
        L41:
            return r10
        L42:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L82
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = a(r8, r9, r0)
            if (r3 == r0) goto L56
            r0 = r1
            goto L57
        L56:
            r0 = r2
        L57:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L5c:
            if (r2 >= r5) goto L77
            r6 = r4[r2]
            java.lang.reflect.Type r6 = a(r8, r9, r6)
            r7 = r4[r2]
            if (r6 == r7) goto L74
            if (r0 != 0) goto L72
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r1
        L72:
            r4[r2] = r6
        L74:
            int r2 = r2 + 1
            goto L5c
        L77:
            if (r0 == 0) goto L81
            java.lang.reflect.Type r8 = r10.getRawType()
            java.lang.reflect.ParameterizedType r10 = a(r3, r8, r4)
        L81:
            return r10
        L82:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto Lb4
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto La2
            r1 = r0[r2]
            java.lang.reflect.Type r8 = a(r8, r9, r1)
            r9 = r0[r2]
            if (r8 == r9) goto Lb4
            java.lang.reflect.WildcardType r8 = c(r8)
            return r8
        La2:
            int r0 = r3.length
            if (r0 != r1) goto Lb4
            r0 = r3[r2]
            java.lang.reflect.Type r8 = a(r8, r9, r0)
            r9 = r3[r2]
            if (r8 == r9) goto Lb4
            java.lang.reflect.WildcardType r8 = b(r8)
            return r8
        Lb4:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.b.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (a3 instanceof ParameterizedType) {
            return ((ParameterizedType) a3).getActualTypeArguments()[a((Object[]) a2.getTypeParameters(), (Object) typeVariable)];
        }
        return typeVariable;
    }

    static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                return a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static Type b(Type type, Class<?> cls, Class<?> cls2) {
        com.a.a.b.a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static WildcardType b(Type type) {
        return new c(new Type[]{type}, f1007a);
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = b(type, cls, Map.class);
        return b instanceof ParameterizedType ? ((ParameterizedType) b).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(d(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0065b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    public static Class<?> e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            com.a.a.b.a.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return e(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    public static String f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static Type g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Type type) {
        com.a.a.b.a.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }
}

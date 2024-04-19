package com.a.a.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class i {
    public static i a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            return new i() { // from class: com.a.a.b.i.1
                @Override // com.a.a.b.i
                public <T> T a(Class<T> cls2) throws Exception {
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod.setAccessible(true);
                    return new i() { // from class: com.a.a.b.i.2
                        @Override // com.a.a.b.i
                        public <T> T a(Class<T> cls2) throws Exception {
                            return (T) declaredMethod.invoke(null, cls2, Object.class);
                        }
                    };
                } catch (Exception unused2) {
                    return new i() { // from class: com.a.a.b.i.4
                        @Override // com.a.a.b.i
                        public <T> T a(Class<T> cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2);
                        }
                    };
                }
            } catch (Exception unused3) {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                final int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                final Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod3.setAccessible(true);
                return new i() { // from class: com.a.a.b.i.3
                    @Override // com.a.a.b.i
                    public <T> T a(Class<T> cls2) throws Exception {
                        return (T) declaredMethod3.invoke(null, cls2, Integer.valueOf(intValue));
                    }
                };
            }
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}

package com.ta.utdid2.b.a;

import java.lang.reflect.Method;
/* compiled from: DebugUtils.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f1283a;

    /* renamed from: a  reason: collision with other field name */
    private static Method f112a;
    private static Method b;
    public static boolean e;

    public static int getInt(String str, int i) {
        a();
        try {
            return ((Integer) b.invoke(f1283a, str, Integer.valueOf(i))).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }

    static {
        e = getInt("alidebug", 0) == 1;
        f1283a = null;
        f112a = null;
        b = null;
    }

    private static void a() {
        try {
            if (f1283a == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f1283a = cls;
                f112a = cls.getDeclaredMethod("get", String.class);
                b = f1283a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

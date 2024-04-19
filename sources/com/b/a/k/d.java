package com.b.a.k;

import android.util.Log;
/* compiled from: OkLogger.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1273a = true;
    private static String b = "OkGo";

    public static void a(String str, String str2) {
        if (f1273a) {
            Log.v(str, str2);
        }
    }

    public static void a(Throwable th) {
        if (!f1273a || th == null) {
            return;
        }
        th.printStackTrace();
    }
}

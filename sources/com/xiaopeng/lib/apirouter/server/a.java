package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* compiled from: AutoCodeMatcher.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Pair<IBinder, String>> f1372a;
    private static List<b> b = new LinkedList();
    private static Object c = new Object();

    public Pair<IBinder, String> a(String str) {
        if (f1372a == null) {
            f1372a = f.a();
            a();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = f1372a;
        Pair<IBinder, String> pair = hashMap == null ? null : hashMap.get(str);
        return pair == null ? new Pair<>(null, null) : pair;
    }

    private void a() {
        synchronized (c) {
            if (!b.isEmpty()) {
                for (b bVar : b) {
                    a(bVar);
                }
            }
        }
    }

    private void a(b bVar) {
        c[] a2;
        if (bVar == null || (a2 = bVar.a()) == null || a2.length == 0) {
            return;
        }
        if (f1372a == null) {
            f1372a = new HashMap<>();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = f1372a;
        for (c cVar : a2) {
            try {
                HashMap<String, Pair<IBinder, String>> a3 = cVar.a();
                if (a3 != null && !a3.isEmpty()) {
                    hashMap.putAll(a3);
                }
            } catch (Exception e) {
                Log.e("AutoCodeMatcher", "initManifestHandler:" + cVar.getClass(), e);
            }
        }
    }
}

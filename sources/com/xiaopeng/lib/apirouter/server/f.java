package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.lang.reflect.Field;
import java.util.HashMap;
/* compiled from: ManifestHelperMapping.java */
/* loaded from: classes.dex */
class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap<String, Pair<IBinder, String>> a() {
        Field field;
        try {
            Class<?> cls = Class.forName("com.xiaopeng.lib.apirouter.server.ManifestHelper");
            if (cls == null || (field = cls.getField("mapping")) == null) {
                return null;
            }
            return (HashMap) field.get(cls);
        } catch (Exception e) {
            Log.e("AutoCodeMatcher", "reflectMapping", e);
            return null;
        }
    }
}

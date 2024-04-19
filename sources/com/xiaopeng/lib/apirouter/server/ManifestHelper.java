package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Pair;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ManifestHelper {
    public static HashMap<String, Pair<IBinder, String>> mapping = new HashMap<>();

    static {
        Pair<IBinder, String> pair = new Pair<>(new e(), d.a());
        for (String str : d.b()) {
            mapping.put(str, pair);
        }
    }
}

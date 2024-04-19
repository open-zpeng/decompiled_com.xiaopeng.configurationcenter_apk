package com.xiaopeng.datalog;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: StatEvent.java */
/* loaded from: classes.dex */
public class d implements IStatEvent {
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with root package name */
    private String f1369a;
    private Map<String, Object> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.b.put(IStatEvent.CUSTOM_MODULE_VERSION, a(context));
        this.b.put(IStatEvent.CUSTOM_NETWORK, b(context));
        this.b.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.b.put(IStatEvent.CUSTOM_DEVICE_MCUVER, a());
        this.b.put(IStatEvent.CUSTOM_UID, Long.valueOf(SystemPropertyUtil.getAccountUid()));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String getEventName() {
        return this.f1369a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void setEventName(String str) {
        this.f1369a = str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public String toJson() {
        this.b.put(IStatEvent.CUSTOM_MODULE, a(this.f1369a));
        this.b.put(IStatEvent.CUSTOM_EVENT, this.f1369a);
        return com.xiaopeng.datalog.b.b.a().b().toJson(this.b, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.datalog.d.1
        }.getType());
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.b.put(str, number);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.b.put(str, bool);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent
    public void put(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.b.put(str, ch);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("_")) == null || split.length <= 0) ? "" : split[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        if (TextUtils.isEmpty(d)) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                Log.w("StatEvent", "getVersion fail!", e);
                return "Unknown";
            }
        }
        return d;
    }

    public String toString() {
        return "StatEvent{eventName='" + this.f1369a + "'}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        if (TextUtils.isEmpty(c)) {
            c = SystemProperties.get("persist.sys.mcu.version");
        }
        if (TextUtils.isEmpty(c)) {
            c = SystemProperties.get("sys.mcu.version");
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 1 ? "WIFI" : "";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 11:
                default:
                    return "";
                case 13:
                    return "4G";
            }
        }
        return "";
    }
}

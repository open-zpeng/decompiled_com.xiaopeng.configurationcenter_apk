package com.ut.mini.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.a.b;
import com.alibaba.mtl.a.c.c;
import com.alibaba.mtl.a.d.p;
import com.alibaba.mtl.appmonitor.a;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;
/* loaded from: classes.dex */
public class UTTeamWork {

    /* renamed from: a  reason: collision with root package name */
    private static UTTeamWork f1308a;

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public void initialized() {
    }

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (f1308a == null) {
                f1308a = new UTTeamWork();
            }
            uTTeamWork = f1308a;
        }
        return uTTeamWork;
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        a.a(map);
    }

    public void turnOffRealTimeDebug() {
        a.a();
    }

    public void saveCacheDataToLocal() {
        c.a().b();
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public String getUtsid() {
        try {
            String a2 = com.alibaba.mtl.a.a.d() != null ? com.alibaba.mtl.a.a.d().a() : null;
            String utdid = UTDevice.getUtdid(b.a().d());
            long longValue = Long.valueOf(com.alibaba.mtl.a.a.f).longValue();
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(utdid)) {
                return utdid + "_" + a2 + "_" + longValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeAuto1010Track() {
        com.alibaba.mtl.a.c.a().b();
    }

    public void enableUpload(boolean z) {
        com.alibaba.mtl.a.a.j = z;
    }

    public void setHost4Https(Context context, String str) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTTeamWork", "host or port is empty");
        } else {
            com.alibaba.mtl.a.a.a.a(str);
            p.a(context, "utanalytics_https_host", str);
        }
    }

    public void clearHost4Https(Context context) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
            return;
        }
        com.alibaba.mtl.a.a.a.a("");
        p.a(context, "utanalytics_https_host", null);
    }
}

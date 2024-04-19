package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.mtl.a.b;
import com.alibaba.mtl.a.c;
import com.alibaba.mtl.a.d.i;
import com.alibaba.mtl.appmonitor.a;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UTAnalytics {

    /* renamed from: a  reason: collision with root package name */
    private static UTAnalytics f1296a;
    private boolean M;
    private boolean N;

    /* renamed from: a  reason: collision with other field name */
    private UTTracker f128a;
    private Map<String, UTTracker> w = new HashMap();
    private Map<String, UTTracker> x = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    @Deprecated
    public void setContext(Context context) {
        b.a().a(context);
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    @Deprecated
    public void setAppApplicationInstance(Application application) {
        b.a().a(application);
        a.a(application);
    }

    public void setAppApplicationInstance(Application application, IUTApplication iUTApplication) {
        try {
            if (this.M) {
                return;
            }
            if (application != null && iUTApplication != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                this.M = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                i.a((String) null, th);
            } catch (Throwable unused) {
            }
        }
    }

    public void setAppApplicationInstance4sdk(Application application, IUTApplication iUTApplication) {
        try {
            if (this.N) {
                return;
            }
            if (application != null && iUTApplication != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                i.a((String) null, th);
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            if (f1296a == null) {
                f1296a = new UTAnalytics();
            }
            uTAnalytics = f1296a;
        }
        return uTAnalytics;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f128a == null) {
            this.f128a = new UTTracker();
        }
        if (this.f128a == null) {
            i.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f128a;
    }

    @Deprecated
    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            i.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            String appkey = iUTRequestAuthentication.getAppkey();
            UTBaseRequestAuthentication uTBaseRequestAuthentication = (UTBaseRequestAuthentication) iUTRequestAuthentication;
            a.a(false, appkey, uTBaseRequestAuthentication.getAppSecret(), uTBaseRequestAuthentication.isEncode() ? "1" : "0");
            return;
        }
        a.a(true, iUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
    }

    @Deprecated
    public void setAppVersion(String str) {
        b.a().a(str);
    }

    public synchronized UTTracker getTracker(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.w.containsKey(str)) {
                return this.w.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.q(str);
            this.w.put(str, uTTracker);
            return uTTracker;
        }
        i.a("getTracker", "TrackId is null.");
        return null;
    }

    public synchronized UTTracker getTrackerByAppkey(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.x.containsKey(str)) {
                return this.x.get(str);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.r(str);
            this.x.put(str, uTTracker);
            return uTTracker;
        }
        i.a("getTracker", "TrackId is null.");
        return null;
    }

    @Deprecated
    public void setChannel(String str) {
        a.a(str);
    }

    @Deprecated
    public void turnOnDebug() {
        b.a().c();
    }

    public void updateUserAccount(String str, String str2) {
        b.a().a(str, str2);
    }

    public void userRegister(String str) {
        if (!TextUtils.isEmpty(str)) {
            UTTracker defaultTracker = getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
                return;
            } else {
                i.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
                return;
            }
        }
        i.a("userRegister", "Fatal Error,usernick can not be null or empty!");
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map<String, String> d = c.a().d();
        HashMap hashMap = new HashMap();
        if (d != null) {
            hashMap.putAll(d);
        }
        hashMap.putAll(map);
        c.a().a(hashMap);
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }
}

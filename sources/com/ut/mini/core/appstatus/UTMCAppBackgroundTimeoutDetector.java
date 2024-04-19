package com.ut.mini.core.appstatus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.mtl.a.c;
import java.util.HashMap;
/* loaded from: classes.dex */
public class UTMCAppBackgroundTimeoutDetector implements UTMCAppStatusCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static UTMCAppBackgroundTimeoutDetector f1303a;
    private long B = 0;

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    private UTMCAppBackgroundTimeoutDetector() {
    }

    public static synchronized UTMCAppBackgroundTimeoutDetector getInstance() {
        UTMCAppBackgroundTimeoutDetector uTMCAppBackgroundTimeoutDetector;
        synchronized (UTMCAppBackgroundTimeoutDetector.class) {
            if (f1303a == null) {
                f1303a = new UTMCAppBackgroundTimeoutDetector();
            }
            uTMCAppBackgroundTimeoutDetector = f1303a;
        }
        return uTMCAppBackgroundTimeoutDetector;
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        this.B = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        if (0 != this.B && SystemClock.elapsedRealtime() - this.B > 30000) {
            c.a().a(new HashMap());
        }
        this.B = 0L;
    }
}

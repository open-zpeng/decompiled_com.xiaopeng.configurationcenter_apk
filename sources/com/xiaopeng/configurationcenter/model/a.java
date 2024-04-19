package com.xiaopeng.configurationcenter.model;

import a.a.l;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaopeng.configurationcenter.App;
import com.xiaopeng.configurationcenter.ConfigurationService;
import com.xiaopeng.configurationcenter.model.data.c;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.SharedPreferencesUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ConfigurationManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f1321a;
    public static final l b;
    public static final l c;
    private static final long d = l();
    private com.xiaopeng.configurationcenter.model.a.a e;
    private com.xiaopeng.configurationcenter.model.b.a f;

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        f1321a = newSingleThreadExecutor;
        b = a.a.i.a.a(newSingleThreadExecutor);
        c = a.a.a.b.a.a(ThreadUtils.getLooper(2));
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConfigurationManager.java */
    /* renamed from: com.xiaopeng.configurationcenter.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0091a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f1325a = new a();
    }

    public static a a() {
        return C0091a.f1325a;
    }

    public void b() {
        this.e = new com.xiaopeng.configurationcenter.model.a.a();
        this.f = new com.xiaopeng.configurationcenter.model.b.a();
        this.e.a(App.b().b());
        this.f.a(this.e);
        this.f.a(App.b().c());
        com.xiaopeng.configurationcenter.a.a().a(this.e);
        com.xiaopeng.configurationcenter.a.a().a(this.f);
    }

    public void c() {
        this.e.a(new a.a.d.a() { // from class: com.xiaopeng.configurationcenter.model.a.1
            @Override // a.a.d.a
            public void run() {
                a.this.h();
            }
        });
        EventBus.getDefault().register(this);
    }

    public void d() {
        EventBus.getDefault().unregister(this);
    }

    public void e() {
        ThreadUtils.postNormal(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.k();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onIPCMessageEvent(IIpcService.IpcMessageEvent ipcMessageEvent) {
        LogUtils.v("ConfigurationManager", "onIPCMessageEvent event:" + ipcMessageEvent);
        if (ipcMessageEvent == null) {
            return;
        }
        String senderPackageName = ipcMessageEvent.getSenderPackageName();
        if (TextUtils.isEmpty(senderPackageName)) {
            return;
        }
        int msgID = ipcMessageEvent.getMsgID();
        senderPackageName.hashCode();
        if (senderPackageName.equals(IpcConfig.App.DEVICE_COMMUNICATION)) {
            a(msgID, ipcMessageEvent.getPayloadData());
        }
    }

    public void f() {
        if (NetUtils.isNetworkAvailable(App.a())) {
            j();
        }
    }

    public void g() {
        LogUtils.d("ConfigurationManager", "onPMNormal");
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        LogUtils.d("ConfigurationManager", "all app info loaded, size:" + this.e.a().size());
        j();
    }

    private long i() {
        long j = SharedPreferencesUtils.getInstance(App.a()).getLong("key_scheduled_query_start_elapsed", 0L);
        LogUtils.i("ConfigurationManager", "getScheduledQueryTimeLeft lastElapsed:" + j);
        if (j == 0) {
            return 0L;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (elapsedRealtime <= 0) {
            return 0L;
        }
        return d - elapsedRealtime;
    }

    private void j() {
        long i = i();
        AlarmManager alarmManager = (AlarmManager) App.a().getSystemService("alarm");
        if (alarmManager != null) {
            Intent intent = new Intent(App.a(), ConfigurationService.class);
            intent.setAction("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_SCHEDULED_QUERY");
            alarmManager.setInexactRepeating(3, SystemClock.elapsedRealtime() + i, d, PendingIntent.getService(App.a(), 0, intent, 268435456));
            LogUtils.i("ConfigurationManager", "scheduleQueryTask triggerAt:" + i);
            return;
        }
        LogUtils.e("ConfigurationManager", "scheduleQueryTask alarmManager is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        List<c> a2 = this.e.a();
        LogUtils.i("ConfigurationManager", "doScheduledQuery list size:" + a2.size());
        if (a2.isEmpty() || !NetUtils.isNetworkAvailable(App.a())) {
            return;
        }
        this.f.a(a2);
        SharedPreferencesUtils.getInstance(App.a()).putLong("key_scheduled_query_start_elapsed", SystemClock.elapsedRealtime());
    }

    private void a(int i, Bundle bundle) {
        LogUtils.v("ConfigurationManager", "handleDCEvent msgID:" + i + "; bundle:" + bundle);
        String string = bundle != null ? bundle.getString(IpcConfig.IPCKey.STRING_MSG) : null;
        if (i != 10010) {
            return;
        }
        a(string);
    }

    private void a(String str) {
        LogUtils.v("ConfigurationManager", "handleMessageCenterEvent event:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("scene");
            String string = jSONObject.getString("content");
            LogUtils.v("ConfigurationManager", "handleMessageCenterEvent scene:" + i);
            if (i != 11002) {
                return;
            }
            b(string);
        } catch (JSONException e) {
            LogUtils.e("ConfigurationManager", "handleMessageCenterEvent exception:" + e.getMessage() + "; event:" + str);
        }
    }

    private void b(String str) {
        LogUtils.v("ConfigurationManager", "onConfigurationUpdate content:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f.a(new JSONObject(str).getString("appId"));
        } catch (JSONException e) {
            LogUtils.e("ConfigurationManager", "onConfigurationUpdate exception:" + e.getMessage());
        }
    }

    private static long l() {
        return CommonConfig.HTTP_HOST.startsWith("https://xmart.xiaopeng.com") ? 3600000L : 600000L;
    }
}

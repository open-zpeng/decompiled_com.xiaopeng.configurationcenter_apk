package com.xiaopeng.configurationcenter;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.xiaopeng.lib.utils.LogUtils;
/* loaded from: classes.dex */
public class ConfigurationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private long f1315a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public ConfigurationService() {
        ((NotificationManager) App.a().getSystemService("notification")).createNotificationChannel(new NotificationChannel("config_channel_id", "System", 2));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f1315a = SystemClock.elapsedRealtime();
        LogUtils.d("ConfigurationService", "onCreate elapsed:" + this.f1315a);
        startForeground(1, new Notification.Builder(this, "config_channel_id").setSmallIcon(R.mipmap.ic_launcher).setWhen(System.currentTimeMillis()).setContentText("配置服务正在运行").build());
        com.xiaopeng.configurationcenter.model.a.a().c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            LogUtils.w("ConfigurationService", "onStartCommand intent null");
            return 1;
        }
        String action = intent.getAction();
        LogUtils.d("ConfigurationService", "onStartCommand action:" + action);
        if (action != null) {
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1160184968:
                    if (action.equals("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_PM_NORMAL")) {
                        c = 0;
                        break;
                    }
                    break;
                case -896463547:
                    if (action.equals("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_SCHEDULED_QUERY")) {
                        c = 1;
                        break;
                    }
                    break;
                case 697089671:
                    if (action.equals("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_CONNECTIVITY_CHANGE")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    com.xiaopeng.configurationcenter.model.a.a().g();
                    break;
                case 1:
                    com.xiaopeng.configurationcenter.model.a.a().e();
                    break;
                case 2:
                    com.xiaopeng.configurationcenter.model.a.a().f();
                    break;
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.xiaopeng.configurationcenter.model.a.a().d();
        LogUtils.d("ConfigurationService", "onDestroy life:" + (SystemClock.elapsedRealtime() - this.f1315a));
    }
}

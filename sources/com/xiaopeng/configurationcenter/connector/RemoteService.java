package com.xiaopeng.configurationcenter.connector;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceCallback;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceInterface;
import com.xiaopeng.lib.utils.LogUtils;
/* loaded from: classes.dex */
public class RemoteService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f1319a;

    @Override // android.app.Service
    public void onCreate() {
        LogUtils.v("RemoteService", "ConfigurationCenter RemoteService onCreate");
        super.onCreate();
        this.f1319a = new a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtils.v("RemoteService", "ConfigurationCenter RemoteService onBind, action:" + intent.getAction());
        if ("com.xiaopeng.configurationcenter.connector.RemoteService.CONNECT".equals(intent.getAction())) {
            return this.f1319a;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private class a extends IConfigurationServiceInterface.Stub {
        private a() {
        }

        @Override // com.xiaopeng.lib.framework.configuration.IConfigurationServiceInterface
        public void subscribe(String str, String str2, int i, IConfigurationServiceCallback iConfigurationServiceCallback) throws RemoteException {
            com.xiaopeng.configurationcenter.a.a().a(str, str2, i, iConfigurationServiceCallback);
        }

        @Override // com.xiaopeng.lib.framework.configuration.IConfigurationServiceInterface
        public void unsubscribe(String str) throws RemoteException {
            com.xiaopeng.configurationcenter.a.a().a(str);
        }

        @Override // com.xiaopeng.lib.framework.configuration.IConfigurationServiceInterface
        public String getConfiguration(String str, String str2) throws RemoteException {
            return com.xiaopeng.configurationcenter.a.a().a(str, str2);
        }
    }
}

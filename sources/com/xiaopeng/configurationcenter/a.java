package com.xiaopeng.configurationcenter;

import android.os.RemoteException;
import com.xiaopeng.lib.framework.configuration.ConfigurationDataImpl;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceCallback;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.List;
/* compiled from: ConfigurationProvider.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.xiaopeng.configurationcenter.model.a.b f1317a;
    private com.xiaopeng.configurationcenter.model.b.b b;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConfigurationProvider.java */
    /* renamed from: com.xiaopeng.configurationcenter.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0090a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f1318a = new a();
    }

    public static a a() {
        return C0090a.f1318a;
    }

    public void a(com.xiaopeng.configurationcenter.model.a.b bVar) {
        this.f1317a = bVar;
    }

    public void a(com.xiaopeng.configurationcenter.model.b.b bVar) {
        this.b = bVar;
    }

    public void a(String str, List<ConfigurationDataImpl> list) {
        com.xiaopeng.configurationcenter.model.a.b bVar = this.f1317a;
        if (bVar == null) {
            LogUtils.e("ConfigurationProvider", "notify appID:" + str + "; but appInfoHolder is null");
            return;
        }
        IConfigurationServiceCallback b = bVar.b(str);
        if (b == null) {
            LogUtils.w("ConfigurationProvider", "notify appID:" + str + "; but callback is nul");
            return;
        }
        try {
            b.onConfigurationChanged(list);
        } catch (RemoteException e) {
            LogUtils.e("ConfigurationProvider", "notify appID:" + str + "; but get remoteException:" + e.getMessage());
            a(str);
        }
    }

    public String a(String str, String str2) {
        LogUtils.v("ConfigurationProvider", "getConfiguration appID:" + str + "; key:" + str2);
        if (str == null) {
            LogUtils.e("ConfigurationProvider", "getConfiguration appID is null; key:" + str2);
            return null;
        } else if (str2 == null) {
            LogUtils.e("ConfigurationProvider", "getConfiguration key is null; appID:" + str);
            return null;
        } else {
            com.xiaopeng.configurationcenter.model.b.b bVar = this.b;
            if (bVar == null) {
                LogUtils.e("ConfigurationProvider", "getConfiguration key:" + str2 + "; but configurationHolder is null");
                return null;
            }
            return bVar.a(str, str2);
        }
    }

    public void a(String str, String str2, int i, IConfigurationServiceCallback iConfigurationServiceCallback) {
        LogUtils.v("ConfigurationProvider", "subscribe appID:" + str + "; version:" + str2 + "; versionCode:" + i);
        if (str == null) {
            LogUtils.e("ConfigurationProvider", "subscribe appID is null");
            return;
        }
        if (iConfigurationServiceCallback == null) {
            LogUtils.w("ConfigurationProvider", "subscribe callback is null");
        }
        com.xiaopeng.configurationcenter.model.a.b bVar = this.f1317a;
        if (bVar != null) {
            bVar.a(str, str2, i, iConfigurationServiceCallback);
        } else {
            LogUtils.e("ConfigurationProvider", "subscribe appID:" + str + "; but appInfoHolder is null");
        }
    }

    public void a(String str) {
        LogUtils.v("ConfigurationProvider", "unsubscribe appID" + str);
        if (str == null) {
            LogUtils.e("ConfigurationProvider", "unsubscribe appID is null");
            return;
        }
        com.xiaopeng.configurationcenter.model.a.b bVar = this.f1317a;
        if (bVar != null) {
            bVar.a(str);
        } else {
            LogUtils.e("ConfigurationProvider", "unsubscribe appID:" + str + "; but appInfoHolder is null");
        }
    }
}

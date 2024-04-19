package com.xiaopeng.configurationcenter;

import android.app.Application;
import android.content.Intent;
import com.xiaopeng.configurationcenter.model.data.g;
import com.xiaopeng.lib.bughunter.BugHunter;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.netchannelmodule.NetworkChannelsEntry;
import com.xiaopeng.lib.http.HttpsUtils;
import com.xiaopeng.lib.utils.LogUtils;
import org.greenrobot.eventbus.EventBus;
/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static App f1314a;
    private g b;
    private com.xiaopeng.configurationcenter.model.c.a c;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f1314a = this;
        f();
        g();
    }

    public static App a() {
        return f1314a;
    }

    public static g b() {
        return f1314a.b;
    }

    public static com.xiaopeng.configurationcenter.model.c.a c() {
        return f1314a.c;
    }

    private void f() {
        EventBus.builder().sendNoSubscriberEvent(false).logNoSubscriberMessages(false).logSubscriberExceptions(false).installDefaultEventBus();
        LogUtils.setWithStackTraceFlag(true);
        HttpsUtils.init(this, false);
        BugHunter.init(this);
        h();
        g gVar = new g();
        this.b = gVar;
        gVar.a();
        com.xiaopeng.configurationcenter.model.c.a aVar = new com.xiaopeng.configurationcenter.model.c.a();
        this.c = aVar;
        aVar.a(e());
        com.xiaopeng.configurationcenter.model.a.a().b();
    }

    private void g() {
        Intent intent = new Intent(this, ConfigurationService.class);
        intent.setAction("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_APP_CREATE");
        startForegroundService(intent);
    }

    private void h() {
        Module.register(IpcModuleEntry.class, new IpcModuleEntry(this));
        IIpcService d = d();
        if (d != null) {
            d.init();
        }
        Module.register(NetworkChannelsEntry.class, new NetworkChannelsEntry());
    }

    public IIpcService d() {
        try {
            return (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        } catch (Exception e) {
            LogUtils.e("App", "getIPCService exception:" + e.getMessage());
            return null;
        }
    }

    public IHttp e() {
        try {
            return (IHttp) Module.get(NetworkChannelsEntry.class).get(IHttp.class);
        } catch (Exception e) {
            LogUtils.e("App", "getHttp exception:" + e.getMessage());
            return null;
        }
    }
}

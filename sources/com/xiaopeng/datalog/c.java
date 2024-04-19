package com.xiaopeng.datalog;

import android.content.Context;
import android.os.SystemClock;
import com.google.gson.reflect.TypeToken;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MoleEvent.java */
/* loaded from: classes.dex */
public class c implements IMoleEvent {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f1367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1367a = concurrentHashMap;
        concurrentHashMap.put(IStatEvent.CUSTOM_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        this.f1367a.put(IStatEvent.CUSTOM_MODULE_VERSION, d.a(context));
        this.f1367a.put(IStatEvent.CUSTOM_NETWORK, d.b(context));
        this.f1367a.put(IStatEvent.CUSTOM_STARTUP, Long.valueOf(SystemClock.uptimeMillis() / 1000));
        this.f1367a.put(IStatEvent.CUSTOM_DEVICE_MCUVER, d.a());
        this.f1367a.put(IStatEvent.CUSTOM_UID, Long.valueOf(SystemPropertyUtil.getAccountUid()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f1367a.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Number number) {
        if (str == null || number == null) {
            return;
        }
        this.f1367a.put(str, number);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Boolean bool) {
        if (str == null || bool == null) {
            return;
        }
        this.f1367a.put(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Character ch) {
        if (str == null || ch == null) {
            return;
        }
        this.f1367a.put(str, ch);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent
    public String toJson() {
        return com.xiaopeng.datalog.b.b.a().b().toJson(this.f1367a, new TypeToken<Map<String, Object>>() { // from class: com.xiaopeng.datalog.c.1
        }.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (!this.f1367a.containsKey("page_id")) {
            throw new IllegalArgumentException("Please call setPageId() first");
        }
        if (!this.f1367a.containsKey("button_id")) {
            throw new IllegalArgumentException("Please call setButtonId() first");
        }
        if (!this.f1367a.containsKey(IStatEvent.CUSTOM_MODULE)) {
            throw new IllegalArgumentException("Please call setModule() first");
        }
    }
}

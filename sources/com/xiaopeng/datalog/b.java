package com.xiaopeng.datalog;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.datalog.stat.StatEventHelper;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import java.util.List;
/* compiled from: DataLogService.java */
/* loaded from: classes.dex */
public class b implements IDataLog {

    /* renamed from: a  reason: collision with root package name */
    private Context f1356a;

    public b(Context context) {
        StatEventHelper.init(context);
        this.f1356a = context;
        Module.register(com.xiaopeng.datalog.a.class, new com.xiaopeng.datalog.a(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendCanData(String str) {
        StatEventHelper.getInstance().uploadCan(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(String str, String str2) {
        StatEventHelper.getInstance().uploadLogImmediately(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatOriginData(String str, String str2) {
        StatEventHelper.getInstance().uploadLogOrigin(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent) {
        StatEventHelper.getInstance().uploadCdu(iStatEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IMoleEvent iMoleEvent) {
        StatEventHelper.getInstance().uploadCdu(iMoleEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent, List<String> list) {
        StatEventHelper.getInstance().uploadCduWithFiles(iStatEvent, list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendFiles(List<String> list) {
        StatEventHelper.getInstance().uploadFiles(list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public String sendRecentSystemLog() {
        return StatEventHelper.getInstance().uploadRecentSystemLog();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IStatEventBuilder buildStat() {
        return new C0096b(this.f1356a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IMoleEventBuilder buildMoleEvent() {
        return new a(this.f1356a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public ICounterFactory counterFactory() {
        return com.xiaopeng.datalog.a.a.a();
    }

    /* compiled from: DataLogService.java */
    /* renamed from: com.xiaopeng.datalog.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0096b implements IStatEventBuilder {
        private IStatEvent b;

        C0096b(Context context) {
            this.b = new d(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setEventName(String str) {
            this.b.setEventName(str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, String str2) {
            this.b.put(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, Number number) {
            this.b.put(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, boolean z) {
            this.b.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, char c) {
            this.b.put(str, Character.valueOf(c));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEvent build() {
            if (TextUtils.isEmpty(this.b.getEventName())) {
                throw new IllegalStateException("Please call setEventName first!");
            }
            return this.b;
        }
    }

    /* compiled from: DataLogService.java */
    /* loaded from: classes.dex */
    private class a implements IMoleEventBuilder {

        /* renamed from: a  reason: collision with root package name */
        c f1357a;

        private a(Context context) {
            this.f1357a = new c(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setPageId(String str) {
            this.f1357a.a("page_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setButtonId(String str) {
            this.f1357a.a("button_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setModule(String str) {
            this.f1357a.a(IStatEvent.CUSTOM_MODULE, str);
            this.f1357a.a(IStatEvent.CUSTOM_EVENT, str + "_page_button");
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setEvent(String str) {
            this.f1357a.a(IStatEvent.CUSTOM_MODULE, d.a(str));
            this.f1357a.a(IStatEvent.CUSTOM_EVENT, str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, String str2) {
            this.f1357a.a(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, Number number) {
            this.f1357a.a(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, boolean z) {
            this.f1357a.a(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, char c) {
            this.f1357a.a(str, Character.valueOf(c));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEvent build() {
            this.f1357a.a();
            return this.f1357a;
        }
    }
}

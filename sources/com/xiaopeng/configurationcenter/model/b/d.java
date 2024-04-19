package com.xiaopeng.configurationcenter.model.b;

import com.xiaopeng.configurationcenter.App;
import com.xiaopeng.configurationcenter.model.c.a;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.List;
/* compiled from: RemoteQueryTask.java */
/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final com.xiaopeng.configurationcenter.model.c.a f1338a = App.c();
    private static final com.xiaopeng.configurationcenter.model.data.d b = App.b().c();
    private com.xiaopeng.configurationcenter.model.data.c c;
    private a.InterfaceC0094a d;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(com.xiaopeng.configurationcenter.model.data.c cVar) {
        d dVar = new d();
        dVar.c = cVar;
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.c.f1345a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.d = interfaceC0094a;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> a2 = b.a(a());
        LogUtils.v("RemoteQueryTask", "RemoteQueryTask run, versions size:" + (a2 != null ? a2.size() : 0));
        f1338a.a(this.c, a2, this.d);
    }

    public String toString() {
        return "RemoteQueryTask{appID:" + a() + "hashCode:" + hashCode() + "};";
    }
}

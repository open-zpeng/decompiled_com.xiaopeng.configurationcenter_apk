package com.xiaopeng.configurationcenter.model.a;

import a.a.d.e;
import com.xiaopeng.configurationcenter.model.data.c;
import com.xiaopeng.lib.framework.configuration.IConfigurationServiceCallback;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AppModel.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, c> f1324a = new ConcurrentHashMap<>();
    private com.xiaopeng.configurationcenter.model.data.a b;

    public void a(com.xiaopeng.configurationcenter.model.data.a aVar) {
        this.b = aVar;
    }

    public void a(final a.a.d.a aVar) {
        this.b.a().b(a.a.i.a.b()).a(com.xiaopeng.configurationcenter.model.a.c).a(new e<List<c>>() { // from class: com.xiaopeng.configurationcenter.model.a.a.1
            @Override // a.a.d.e
            /* renamed from: a */
            public void accept(List<c> list) throws Exception {
                for (c cVar : list) {
                    ConcurrentHashMap concurrentHashMap = a.this.f1324a;
                    String str = cVar.f1345a;
                    a aVar2 = a.this;
                    concurrentHashMap.put(str, aVar2.a(cVar, aVar2.c(cVar.f1345a)));
                }
                aVar.run();
            }
        }, new e<Throwable>() { // from class: com.xiaopeng.configurationcenter.model.a.a.2
            @Override // a.a.d.e
            /* renamed from: a */
            public void accept(Throwable th) throws Exception {
                LogUtils.e("AppModel", "loadAll exception:" + th.getMessage());
            }
        }, aVar);
    }

    @Override // com.xiaopeng.configurationcenter.model.a.b
    public void a(String str, String str2, int i, IConfigurationServiceCallback iConfigurationServiceCallback) {
        c cVar = new c();
        cVar.f1345a = str;
        cVar.b = str2;
        cVar.c = i;
        cVar.d = System.currentTimeMillis();
        cVar.e = iConfigurationServiceCallback;
        this.f1324a.put(str, cVar);
        a(cVar);
    }

    @Override // com.xiaopeng.configurationcenter.model.a.b
    public void a(String str) {
        c c = c(str);
        if (c == null) {
            LogUtils.w("AppModel", "onAppUnsubscribe appID:" + str + " but appInfo is null");
        } else {
            c.e = null;
        }
    }

    @Override // com.xiaopeng.configurationcenter.model.a.b
    public IConfigurationServiceCallback b(String str) {
        c c = c(str);
        if (c != null) {
            return c.e;
        }
        return null;
    }

    public c c(String str) {
        return this.f1324a.get(str);
    }

    public List<c> a() {
        return new ArrayList(this.f1324a.values());
    }

    private void a(final c cVar) {
        com.xiaopeng.configurationcenter.model.a.f1321a.execute(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.v("AppModel", "saveAppInfoEntity id:" + a.this.b.a(cVar));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(c cVar, c cVar2) {
        return (cVar2 == null || cVar.e != null) ? cVar : cVar2;
    }
}

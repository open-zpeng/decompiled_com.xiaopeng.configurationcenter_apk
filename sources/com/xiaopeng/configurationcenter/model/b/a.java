package com.xiaopeng.configurationcenter.model.b;

import com.xiaopeng.configurationcenter.model.b.c;
import com.xiaopeng.configurationcenter.model.data.f;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ConfigurationModel.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.xiaopeng.configurationcenter.model.a.a f1329a;
    private com.xiaopeng.configurationcenter.model.data.d b;
    private c c = new c(new c.a() { // from class: com.xiaopeng.configurationcenter.model.b.a.1
        @Override // com.xiaopeng.configurationcenter.model.b.c.a
        public void a(final String str, final List<f> list, final boolean z) {
            LogUtils.v("ConfigurationModel", "onGetConfigurations appID:" + str + "; entities size:" + (list != null ? list.size() : 0) + "; notify:" + z);
            com.xiaopeng.configurationcenter.model.a.f1321a.execute(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.b.a.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.v("ConfigurationModel", "onGetConfigurations appID:" + str + "; saved to db ids:" + a.this.b.a(list).length);
                    if (z) {
                        ThreadUtils.execute(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.b.a.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (f fVar : list) {
                                    arrayList.add(fVar.a());
                                }
                                com.xiaopeng.configurationcenter.a.a().a(str, arrayList);
                            }
                        });
                    }
                }
            });
        }
    });

    public void a(com.xiaopeng.configurationcenter.model.a.a aVar) {
        this.f1329a = aVar;
    }

    public void a(com.xiaopeng.configurationcenter.model.data.d dVar) {
        this.b = dVar;
    }

    @Override // com.xiaopeng.configurationcenter.model.b.b
    public String a(String str, String str2) {
        f a2 = this.b.a(str, str2);
        if (a2 == null) {
            a(str);
            return null;
        }
        LogUtils.v("ConfigurationModel", "getConfiguration entity:" + a2);
        return a2.d;
    }

    public void a(List<com.xiaopeng.configurationcenter.model.data.c> list) {
        if (list.isEmpty()) {
            return;
        }
        for (com.xiaopeng.configurationcenter.model.data.c cVar : list) {
            a(cVar);
        }
    }

    private void a(com.xiaopeng.configurationcenter.model.data.c cVar) {
        LogUtils.i("ConfigurationModel", "appendNormalQueryTask appID:" + cVar.f1345a);
        this.c.a(d.a(cVar));
    }

    public void a(final String str) {
        LogUtils.i("ConfigurationModel", "appendPriorityQueryTask appID:" + str);
        ThreadUtils.postNormal(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.c.b(d.a(a.this.f1329a.c(str)));
            }
        });
    }
}

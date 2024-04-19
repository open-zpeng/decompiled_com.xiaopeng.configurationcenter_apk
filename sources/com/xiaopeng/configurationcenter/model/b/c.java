package com.xiaopeng.configurationcenter.model.b;

import com.xiaopeng.configurationcenter.model.c.a;
import com.xiaopeng.configurationcenter.model.data.f;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteQueryExecutor.java */
/* loaded from: classes.dex */
public class c {
    private a g;

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashMap<String, d> f1334a = new LinkedHashMap<>();
    private LinkedHashMap<String, d> b = new LinkedHashMap<>();
    private final byte[] c = new byte[0];
    private final byte[] d = new byte[0];
    private int e = 0;
    private a.InterfaceC0094a h = new a.InterfaceC0094a() { // from class: com.xiaopeng.configurationcenter.model.b.c.1
        @Override // com.xiaopeng.configurationcenter.model.c.a.InterfaceC0094a
        public void a(String str, List<f> list) {
            c.this.g.a(str, list, true);
            c.this.b();
        }

        @Override // com.xiaopeng.configurationcenter.model.c.a.InterfaceC0094a
        public void a(String str, int i, String str2) {
            LogUtils.e("RemoteQueryExecutor", "mPriorityQueryCallback appID:" + str + "; errCode:" + i + "; errMsg:" + str2);
            c.this.b();
        }
    };
    private a.InterfaceC0094a i = new a.InterfaceC0094a() { // from class: com.xiaopeng.configurationcenter.model.b.c.2
        @Override // com.xiaopeng.configurationcenter.model.c.a.InterfaceC0094a
        public void a(String str, List<f> list) {
            c.this.g.a(str, list, false);
            c.this.b();
        }

        @Override // com.xiaopeng.configurationcenter.model.c.a.InterfaceC0094a
        public void a(String str, int i, String str2) {
            LogUtils.e("RemoteQueryExecutor", "mNormalQueryCallback appID:" + str + "; errCode:" + i + "; errMsg:" + str2);
            c.this.b();
        }
    };
    private Executor f = Executors.newFixedThreadPool(4);

    /* compiled from: RemoteQueryExecutor.java */
    /* loaded from: classes.dex */
    interface a {
        void a(String str, List<f> list, boolean z);
    }

    static /* synthetic */ int c(c cVar) {
        int i = cVar.e;
        cVar.e = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        if (this.f1334a.get(dVar.a()) == null) {
            this.b.put(dVar.a(), dVar);
            dVar.a(this.i);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        String a2 = dVar.a();
        this.f1334a.put(a2, dVar);
        dVar.a(this.h);
        LogUtils.v("RemoteQueryExecutor", "appendPriority task:" + dVar + "; normalTask:" + this.b.remove(a2));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        d remove;
        if (this.e >= 4) {
            LogUtils.v("RemoteQueryExecutor", "execute running counter exceeded , return");
            return;
        }
        synchronized (this.c) {
            String a2 = a(this.f1334a);
            remove = a2 != null ? this.f1334a.remove(a2) : null;
        }
        if (remove == null) {
            synchronized (this.d) {
                String a3 = a(this.b);
                if (a3 != null) {
                    remove = this.b.remove(a3);
                }
            }
        }
        if (remove == null) {
            LogUtils.v("RemoteQueryExecutor", "execute no more tasks , return");
            return;
        }
        this.e++;
        this.f.execute(remove);
    }

    private String a(LinkedHashMap<String, d> linkedHashMap) {
        Iterator<String> it = linkedHashMap.keySet().iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ThreadUtils.postNormal(new Runnable() { // from class: com.xiaopeng.configurationcenter.model.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.c(c.this);
                c.this.a();
            }
        });
    }
}

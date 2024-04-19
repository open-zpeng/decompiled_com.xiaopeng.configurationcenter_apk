package com.xiaopeng.configurationcenter.model.data;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: AppInfoDao_Impl.java */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f1341a;
    private final androidx.room.c<c> b;
    private final androidx.room.b<c> c;

    public b(j jVar) {
        this.f1341a = jVar;
        this.b = new androidx.room.c<c>(jVar) { // from class: com.xiaopeng.configurationcenter.model.data.b.1
            @Override // androidx.room.p
            public String a() {
                return "INSERT OR REPLACE INTO `app_info` (`appID`,`version`,`versionCode`,`timestamp`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.g.a.f fVar, c cVar) {
                if (cVar.f1345a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, cVar.f1345a);
                }
                if (cVar.b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, cVar.b);
                }
                fVar.a(3, cVar.c);
                fVar.a(4, cVar.d);
            }
        };
        this.c = new androidx.room.b<c>(jVar) { // from class: com.xiaopeng.configurationcenter.model.data.b.2
            @Override // androidx.room.b, androidx.room.p
            public String a() {
                return "DELETE FROM `app_info` WHERE `appID` = ?";
            }
        };
    }

    @Override // com.xiaopeng.configurationcenter.model.data.a
    public long a(c cVar) {
        this.f1341a.f();
        this.f1341a.g();
        try {
            long a2 = this.b.a((androidx.room.c<c>) cVar);
            this.f1341a.j();
            return a2;
        } finally {
            this.f1341a.h();
        }
    }

    @Override // com.xiaopeng.configurationcenter.model.data.a
    public a.a.d<List<c>> a() {
        final m a2 = m.a("SELECT * FROM app_info ORDER BY timestamp DESC", 0);
        return a.a.d.a(new Callable<List<c>>() { // from class: com.xiaopeng.configurationcenter.model.data.b.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public List<c> call() throws Exception {
                Cursor a3 = androidx.room.b.c.a(b.this.f1341a, a2, false, null);
                try {
                    int a4 = androidx.room.b.b.a(a3, "appID");
                    int a5 = androidx.room.b.b.a(a3, "version");
                    int a6 = androidx.room.b.b.a(a3, "versionCode");
                    int a7 = androidx.room.b.b.a(a3, AccountConfig.KEY_TIMESTAMP);
                    ArrayList arrayList = new ArrayList(a3.getCount());
                    while (a3.moveToNext()) {
                        c cVar = new c();
                        cVar.f1345a = a3.getString(a4);
                        cVar.b = a3.getString(a5);
                        cVar.c = a3.getInt(a6);
                        cVar.d = a3.getLong(a7);
                        arrayList.add(cVar);
                    }
                    return arrayList;
                } finally {
                    a3.close();
                }
            }

            protected void finalize() {
                a2.a();
            }
        });
    }
}

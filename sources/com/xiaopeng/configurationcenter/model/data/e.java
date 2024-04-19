package com.xiaopeng.configurationcenter.model.data;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* compiled from: ConfigurationDataDao_Impl.java */
/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final j f1346a;
    private final androidx.room.c<f> b;
    private final androidx.room.b<f> c;
    private final androidx.room.b<f> d;

    public e(j jVar) {
        this.f1346a = jVar;
        this.b = new androidx.room.c<f>(jVar) { // from class: com.xiaopeng.configurationcenter.model.data.e.1
            @Override // androidx.room.p
            public String a() {
                return "INSERT OR REPLACE INTO `configuration_data` (`appID`,`key`,`version`,`value`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.g.a.f fVar, f fVar2) {
                if (fVar2.f1350a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, fVar2.f1350a);
                }
                if (fVar2.b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, fVar2.b);
                }
                if (fVar2.c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, fVar2.c);
                }
                if (fVar2.d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, fVar2.d);
                }
            }
        };
        this.c = new androidx.room.b<f>(jVar) { // from class: com.xiaopeng.configurationcenter.model.data.e.2
            @Override // androidx.room.b, androidx.room.p
            public String a() {
                return "DELETE FROM `configuration_data` WHERE `appID` = ? AND `key` = ?";
            }
        };
        this.d = new androidx.room.b<f>(jVar) { // from class: com.xiaopeng.configurationcenter.model.data.e.3
            @Override // androidx.room.b, androidx.room.p
            public String a() {
                return "UPDATE OR REPLACE `configuration_data` SET `appID` = ?,`key` = ?,`version` = ?,`value` = ? WHERE `appID` = ? AND `key` = ?";
            }
        };
    }

    @Override // com.xiaopeng.configurationcenter.model.data.d
    public long[] a(Collection<f> collection) {
        this.f1346a.f();
        this.f1346a.g();
        try {
            long[] a2 = this.b.a(collection);
            this.f1346a.j();
            return a2;
        } finally {
            this.f1346a.h();
        }
    }

    @Override // com.xiaopeng.configurationcenter.model.data.d
    public f a(String str, String str2) {
        m a2 = m.a("SELECT * FROM configuration_data WHERE appID = ? AND `key` = ?", 2);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        if (str2 == null) {
            a2.a(2);
        } else {
            a2.a(2, str2);
        }
        this.f1346a.f();
        f fVar = null;
        Cursor a3 = androidx.room.b.c.a(this.f1346a, a2, false, null);
        try {
            int a4 = androidx.room.b.b.a(a3, "appID");
            int a5 = androidx.room.b.b.a(a3, "key");
            int a6 = androidx.room.b.b.a(a3, "version");
            int a7 = androidx.room.b.b.a(a3, "value");
            if (a3.moveToFirst()) {
                fVar = new f();
                fVar.f1350a = a3.getString(a4);
                fVar.b = a3.getString(a5);
                fVar.c = a3.getString(a6);
                fVar.d = a3.getString(a7);
            }
            return fVar;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // com.xiaopeng.configurationcenter.model.data.d
    public List<String> a(String str) {
        m a2 = m.a("SELECT version FROM configuration_data WHERE appID = ?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f1346a.f();
        Cursor a3 = androidx.room.b.c.a(this.f1346a, a2, false, null);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(a3.getString(0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}

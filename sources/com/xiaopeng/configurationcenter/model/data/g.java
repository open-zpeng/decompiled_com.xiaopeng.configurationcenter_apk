package com.xiaopeng.configurationcenter.model.data;

import androidx.room.i;
import androidx.room.j;
import com.xiaopeng.configurationcenter.App;
import java.util.ArrayList;
/* compiled from: DataCenter.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private AppDB f1351a;

    public void a() {
        j.a a2 = i.a(App.a(), AppDB.class, "app_db_v(1)");
        androidx.room.a.a[] d = d();
        if (d != null && d.length > 0) {
            a2.a(d);
        }
        this.f1351a = (AppDB) a2.a();
    }

    public a b() {
        return this.f1351a.l();
    }

    public d c() {
        return this.f1351a.m();
    }

    private androidx.room.a.a[] d() {
        return (androidx.room.a.a[]) new ArrayList().toArray(new androidx.room.a.a[0]);
    }
}

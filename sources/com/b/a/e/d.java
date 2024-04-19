package com.b.a.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.irdeto.securesdk.core.SSUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DBHelper.java */
/* loaded from: classes.dex */
class d extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    static final Lock f1256a = new ReentrantLock();
    private f b;
    private f c;
    private f d;
    private f e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        this(com.b.a.a.a().b());
    }

    d(Context context) {
        super(context, "okgo.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = new f(SSUtils.O00000o0);
        this.c = new f("cookie");
        this.d = new f("download");
        this.e = new f("upload");
        this.b.a(new c("key", "VARCHAR", true, true)).a(new c("localExpire", "INTEGER")).a(new c("head", "BLOB")).a(new c("data", "BLOB"));
        this.c.a(new c("host", "VARCHAR")).a(new c("name", "VARCHAR")).a(new c("domain", "VARCHAR")).a(new c("cookie", "BLOB")).a(new c("host", "name", "domain"));
        this.d.a(new c("tag", "VARCHAR", true, true)).a(new c("url", "VARCHAR")).a(new c("folder", "VARCHAR")).a(new c("filePath", "VARCHAR")).a(new c("fileName", "VARCHAR")).a(new c("fraction", "VARCHAR")).a(new c("totalSize", "INTEGER")).a(new c("currentSize", "INTEGER")).a(new c(CommonConfig.KEY_VALUE_STATUS, "INTEGER")).a(new c("priority", "INTEGER")).a(new c("date", "INTEGER")).a(new c("request", "BLOB")).a(new c("extra1", "BLOB")).a(new c("extra2", "BLOB")).a(new c("extra3", "BLOB"));
        this.e.a(new c("tag", "VARCHAR", true, true)).a(new c("url", "VARCHAR")).a(new c("folder", "VARCHAR")).a(new c("filePath", "VARCHAR")).a(new c("fileName", "VARCHAR")).a(new c("fraction", "VARCHAR")).a(new c("totalSize", "INTEGER")).a(new c("currentSize", "INTEGER")).a(new c(CommonConfig.KEY_VALUE_STATUS, "INTEGER")).a(new c("priority", "INTEGER")).a(new c("date", "INTEGER")).a(new c("request", "BLOB")).a(new c("extra1", "BLOB")).a(new c("extra2", "BLOB")).a(new c("extra3", "BLOB"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.b.a());
        sQLiteDatabase.execSQL(this.c.a());
        sQLiteDatabase.execSQL(this.d.a());
        sQLiteDatabase.execSQL(this.e.a());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (e.a(sQLiteDatabase, this.b)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cache");
        }
        if (e.a(sQLiteDatabase, this.c)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS cookie");
        }
        if (e.a(sQLiteDatabase, this.d)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download");
        }
        if (e.a(sQLiteDatabase, this.e)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS upload");
        }
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}

package com.xiaopeng.configurationcenter.model.data;

import androidx.g.a.c;
import androidx.room.b.e;
import androidx.room.j;
import androidx.room.l;
import com.xiaopeng.libconfig.ipc.AccountConfig;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class AppDB_Impl extends AppDB {
    private volatile a d;
    private volatile d e;

    @Override // androidx.room.j
    protected androidx.g.a.c b(androidx.room.a aVar) {
        return aVar.f867a.a(c.b.a(aVar.b).a(aVar.c).a(new l(aVar, new l.a(1) { // from class: com.xiaopeng.configurationcenter.model.data.AppDB_Impl.1
            @Override // androidx.room.l.a
            public void h(androidx.g.a.b bVar) {
            }

            @Override // androidx.room.l.a
            public void b(androidx.g.a.b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `app_info` (`appID` TEXT NOT NULL, `version` TEXT, `versionCode` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`appID`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `configuration_data` (`appID` TEXT NOT NULL, `key` TEXT NOT NULL, `version` TEXT, `value` TEXT, PRIMARY KEY(`appID`, `key`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f883d0f10f43d0ba0f25f0df39396d68')");
            }

            @Override // androidx.room.l.a
            public void a(androidx.g.a.b bVar) {
                bVar.c("DROP TABLE IF EXISTS `app_info`");
                bVar.c("DROP TABLE IF EXISTS `configuration_data`");
                if (AppDB_Impl.this.c != null) {
                    int size = AppDB_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((j.b) AppDB_Impl.this.c.get(i)).c(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void d(androidx.g.a.b bVar) {
                if (AppDB_Impl.this.c != null) {
                    int size = AppDB_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((j.b) AppDB_Impl.this.c.get(i)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void c(androidx.g.a.b bVar) {
                AppDB_Impl.this.f890a = bVar;
                AppDB_Impl.this.a(bVar);
                if (AppDB_Impl.this.c != null) {
                    int size = AppDB_Impl.this.c.size();
                    for (int i = 0; i < size; i++) {
                        ((j.b) AppDB_Impl.this.c.get(i)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void g(androidx.g.a.b bVar) {
                androidx.room.b.c.a(bVar);
            }

            @Override // androidx.room.l.a
            protected l.b f(androidx.g.a.b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("appID", new e.a("appID", "TEXT", true, 1, null, 1));
                hashMap.put("version", new e.a("version", "TEXT", false, 0, null, 1));
                hashMap.put("versionCode", new e.a("versionCode", "INTEGER", true, 0, null, 1));
                hashMap.put(AccountConfig.KEY_TIMESTAMP, new e.a(AccountConfig.KEY_TIMESTAMP, "INTEGER", true, 0, null, 1));
                androidx.room.b.e eVar = new androidx.room.b.e("app_info", hashMap, new HashSet(0), new HashSet(0));
                androidx.room.b.e a2 = androidx.room.b.e.a(bVar, "app_info");
                if (!eVar.equals(a2)) {
                    return new l.b(false, "app_info(com.xiaopeng.configurationcenter.model.data.AppInfoEntity).\n Expected:\n" + eVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("appID", new e.a("appID", "TEXT", true, 1, null, 1));
                hashMap2.put("key", new e.a("key", "TEXT", true, 2, null, 1));
                hashMap2.put("version", new e.a("version", "TEXT", false, 0, null, 1));
                hashMap2.put("value", new e.a("value", "TEXT", false, 0, null, 1));
                androidx.room.b.e eVar2 = new androidx.room.b.e("configuration_data", hashMap2, new HashSet(0), new HashSet(0));
                androidx.room.b.e a3 = androidx.room.b.e.a(bVar, "configuration_data");
                if (!eVar2.equals(a3)) {
                    return new l.b(false, "configuration_data(com.xiaopeng.configurationcenter.model.data.ConfigurationDataEntity).\n Expected:\n" + eVar2 + "\n Found:\n" + a3);
                }
                return new l.b(true, null);
            }
        }, "f883d0f10f43d0ba0f25f0df39396d68", "f3aa906ed377a4348de4b6d6b258410b")).a());
    }

    @Override // androidx.room.j
    protected androidx.room.g c() {
        return new androidx.room.g(this, new HashMap(0), new HashMap(0), "app_info", "configuration_data");
    }

    @Override // com.xiaopeng.configurationcenter.model.data.AppDB
    public a l() {
        a aVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new b(this);
            }
            aVar = this.d;
        }
        return aVar;
    }

    @Override // com.xiaopeng.configurationcenter.model.data.AppDB
    public d m() {
        d dVar;
        if (this.e != null) {
            return this.e;
        }
        synchronized (this) {
            if (this.e == null) {
                this.e = new e(this);
            }
            dVar = this.e;
        }
        return dVar;
    }
}

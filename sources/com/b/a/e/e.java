package com.b.a.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* compiled from: DBUtils.java */
/* loaded from: classes.dex */
public class e {
    public static boolean a(SQLiteDatabase sQLiteDatabase, f fVar) {
        if (a(sQLiteDatabase, fVar.f1257a)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + fVar.f1257a, null);
            if (rawQuery == null) {
                return false;
            }
            try {
                int b = fVar.b();
                if (b == rawQuery.getColumnCount()) {
                    for (int i = 0; i < b; i++) {
                        if (fVar.a(rawQuery.getColumnName(i)) == -1) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            } finally {
                rawQuery.close();
            }
        }
        return true;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        if (str == null || sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[]{"table", str});
            } catch (Exception e) {
                com.b.a.k.d.a(e);
                if (cursor != null) {
                    cursor.close();
                }
                i = 0;
            }
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            i = cursor.getInt(0);
            if (cursor != null) {
                cursor.close();
            }
            return i > 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}

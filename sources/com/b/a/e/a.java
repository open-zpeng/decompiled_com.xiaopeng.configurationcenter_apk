package com.b.a.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
/* compiled from: BaseDao.java */
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static String f1253a;
    protected Lock b;
    protected SQLiteOpenHelper c;
    protected SQLiteDatabase d;

    public abstract T a(Cursor cursor);

    public abstract ContentValues b(T t);

    public abstract String b();

    public a(SQLiteOpenHelper sQLiteOpenHelper) {
        f1253a = getClass().getSimpleName();
        this.b = d.f1256a;
        this.c = sQLiteOpenHelper;
        this.d = a();
    }

    public SQLiteDatabase a() {
        return this.c.getWritableDatabase();
    }

    protected final void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public boolean a(String str, String[] strArr) {
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        try {
            try {
                this.d.beginTransaction();
                this.d.delete(b(), str, strArr);
                this.d.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                com.b.a.k.d.a(e);
                this.d.endTransaction();
                this.b.unlock();
                com.b.a.k.d.a(f1253a, (System.currentTimeMillis() - currentTimeMillis) + " delete");
                return false;
            }
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            com.b.a.k.d.a(f1253a, (System.currentTimeMillis() - currentTimeMillis) + " delete");
        }
    }

    public boolean a(T t) {
        if (t == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        try {
            this.d.beginTransaction();
            this.d.replace(b(), null, b(t));
            this.d.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            com.b.a.k.d.a(e);
            return false;
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            com.b.a.k.d.a(f1253a, (System.currentTimeMillis() - currentTimeMillis) + " replaceT");
        }
    }

    public List<T> b(String str, String[] strArr) {
        return a(null, str, strArr, null, null, null, null);
    }

    public List<T> a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        Cursor cursor;
        String str6;
        StringBuilder sb;
        long currentTimeMillis = System.currentTimeMillis();
        this.b.lock();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                this.d.beginTransaction();
                cursor = this.d.query(b(), strArr, str, strArr2, str2, str3, str4, str5);
                while (!cursor.isClosed() && cursor.moveToNext()) {
                    try {
                        arrayList.add(a(cursor));
                    } catch (Exception e) {
                        e = e;
                        com.b.a.k.d.a(e);
                        a((SQLiteDatabase) null, cursor);
                        this.d.endTransaction();
                        this.b.unlock();
                        str6 = f1253a;
                        sb = new StringBuilder();
                        com.b.a.k.d.a(str6, sb.append(System.currentTimeMillis() - currentTimeMillis).append(" query").toString());
                        return arrayList;
                    }
                }
                this.d.setTransactionSuccessful();
                a((SQLiteDatabase) null, cursor);
                this.d.endTransaction();
                this.b.unlock();
                str6 = f1253a;
                sb = new StringBuilder();
            } catch (Throwable th) {
                th = th;
                a((SQLiteDatabase) null, (Cursor) null);
                this.d.endTransaction();
                this.b.unlock();
                com.b.a.k.d.a(f1253a, (System.currentTimeMillis() - currentTimeMillis) + " query");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            a((SQLiteDatabase) null, (Cursor) null);
            this.d.endTransaction();
            this.b.unlock();
            com.b.a.k.d.a(f1253a, (System.currentTimeMillis() - currentTimeMillis) + " query");
            throw th;
        }
        com.b.a.k.d.a(str6, sb.append(System.currentTimeMillis() - currentTimeMillis).append(" query").toString());
        return arrayList;
    }
}

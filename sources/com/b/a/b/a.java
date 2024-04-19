package com.b.a.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.b.a.k.c;
import java.io.Serializable;
/* compiled from: CacheEntity.java */
/* loaded from: classes.dex */
public class a<T> implements Serializable {
    private static final long serialVersionUID = -4337711009801627866L;

    /* renamed from: a  reason: collision with root package name */
    private String f1232a;
    private long b;
    private com.b.a.i.a c;
    private T d;
    private boolean e;

    public String a() {
        return this.f1232a;
    }

    public void a(String str) {
        this.f1232a = str;
    }

    public com.b.a.i.a b() {
        return this.c;
    }

    public void a(com.b.a.i.a aVar) {
        this.c = aVar;
    }

    public T c() {
        return this.d;
    }

    public void a(T t) {
        this.d = t;
    }

    public long d() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public boolean e() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean a(b bVar, long j, long j2) {
        return bVar == b.DEFAULT ? d() < j2 : j != -1 && d() + j < j2;
    }

    public static <T> ContentValues a(a<T> aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", aVar.a());
        contentValues.put("localExpire", Long.valueOf(aVar.d()));
        contentValues.put("head", c.a(aVar.b()));
        contentValues.put("data", c.a(aVar.c()));
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> a<T> a(Cursor cursor) {
        a<T> aVar = (a<T>) new a();
        aVar.a(cursor.getString(cursor.getColumnIndex("key")));
        aVar.a(cursor.getLong(cursor.getColumnIndex("localExpire")));
        aVar.a((com.b.a.i.a) c.a(cursor.getBlob(cursor.getColumnIndex("head"))));
        aVar.a((a<T>) c.a(cursor.getBlob(cursor.getColumnIndex("data"))));
        return aVar;
    }

    public String toString() {
        return "CacheEntity{key='" + this.f1232a + "', responseHeaders=" + this.c + ", data=" + this.d + ", localExpire=" + this.b + '}';
    }
}

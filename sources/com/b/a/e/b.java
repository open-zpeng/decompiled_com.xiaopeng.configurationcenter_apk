package com.b.a.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.irdeto.securesdk.core.SSUtils;
import java.util.List;
/* compiled from: CacheManager.java */
/* loaded from: classes.dex */
public class b extends com.b.a.e.a<com.b.a.b.a<?>> {
    @Override // com.b.a.e.a
    public String b() {
        return SSUtils.O00000o0;
    }

    public static b c() {
        return a.f1254a;
    }

    /* compiled from: CacheManager.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f1254a = new b();
    }

    private b() {
        super(new d());
    }

    @Override // com.b.a.e.a
    /* renamed from: b */
    public com.b.a.b.a<?> a(Cursor cursor) {
        return com.b.a.b.a.a(cursor);
    }

    @Override // com.b.a.e.a
    /* renamed from: a */
    public ContentValues b(com.b.a.b.a<?> aVar) {
        return com.b.a.b.a.a((com.b.a.b.a) aVar);
    }

    public com.b.a.b.a<?> a(String str) {
        if (str == null) {
            return null;
        }
        List<com.b.a.b.a<?>> b = b("key=?", new String[]{str});
        if (b.size() > 0) {
            return b.get(0);
        }
        return null;
    }

    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        return a("key=?", new String[]{str});
    }

    public <T> com.b.a.b.a<T> a(String str, com.b.a.b.a<T> aVar) {
        aVar.a(str);
        a((b) aVar);
        return aVar;
    }
}

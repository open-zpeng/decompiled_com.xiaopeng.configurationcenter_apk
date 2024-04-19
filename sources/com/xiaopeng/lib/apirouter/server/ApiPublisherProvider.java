package com.xiaopeng.lib.apirouter.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
/* loaded from: classes.dex */
public class ApiPublisherProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static Context f1371a;
    private a b;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f1371a = getContext();
        this.b = new a();
        return true;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Pair<IBinder, String> a2 = this.b.a(str);
        Bundle bundle2 = new Bundle();
        if (a2 != null) {
            bundle2.putBinder("binder", (IBinder) a2.first);
            bundle2.putString("manifest", (String) a2.second);
        }
        return bundle2;
    }
}

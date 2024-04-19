package com.b.a;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.b.a.b.b;
import com.b.a.g.a;
import com.b.a.h.a;
import com.b.a.i.c;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okhttp3.Call;
import okhttp3.OkHttpClient;
/* compiled from: OkGo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f1228a = 300;
    private Application b;
    private Handler c;
    private OkHttpClient d;
    private c e;
    private com.b.a.i.a f;
    private int g;
    private b h;
    private long i;

    private a() {
        this.c = new Handler(Looper.getMainLooper());
        this.g = 3;
        this.i = -1L;
        this.h = b.NO_CACHE;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        com.b.a.h.a aVar = new com.b.a.h.a("OkGo");
        aVar.a(a.EnumC0085a.BODY);
        aVar.a(Level.INFO);
        builder.addInterceptor(aVar);
        builder.readTimeout(60000L, TimeUnit.MILLISECONDS);
        builder.writeTimeout(60000L, TimeUnit.MILLISECONDS);
        builder.connectTimeout(60000L, TimeUnit.MILLISECONDS);
        a.C0084a a2 = com.b.a.g.a.a();
        builder.sslSocketFactory(a2.f1259a, a2.b);
        builder.hostnameVerifier(com.b.a.g.a.b);
        this.d = builder.build();
    }

    public static a a() {
        return C0083a.f1230a;
    }

    /* compiled from: OkGo.java */
    /* renamed from: com.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0083a {

        /* renamed from: a  reason: collision with root package name */
        private static a f1230a = new a();
    }

    public a a(Application application) {
        this.b = application;
        return this;
    }

    public Context b() {
        com.b.a.k.b.a(this.b, "please call OkGo.getInstance().init() first in application!");
        return this.b;
    }

    public Handler c() {
        return this.c;
    }

    public OkHttpClient d() {
        com.b.a.k.b.a(this.d, "please call OkGo.getInstance().setOkHttpClient() first in application!");
        return this.d;
    }

    public a a(OkHttpClient okHttpClient) {
        com.b.a.k.b.a(okHttpClient, "okHttpClient == null");
        this.d = okHttpClient;
        return this;
    }

    public a a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("retryCount must > 0");
        }
        this.g = i;
        return this;
    }

    public int e() {
        return this.g;
    }

    public b f() {
        return this.h;
    }

    public long g() {
        return this.i;
    }

    public c h() {
        return this.e;
    }

    public com.b.a.i.a i() {
        return this.f;
    }

    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        for (Call call : d().dispatcher().queuedCalls()) {
            if (obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : d().dispatcher().runningCalls()) {
            if (obj.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }
}

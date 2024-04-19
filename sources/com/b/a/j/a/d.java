package com.b.a.j.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.b.a.j.a.c;
import com.b.a.j.a.d;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public abstract class d<T, R extends d> implements Serializable {
    private static final long serialVersionUID = -7174118653689916252L;
    protected String h;
    protected String i;
    protected transient OkHttpClient j;
    protected transient Object k;
    protected int l;
    protected com.b.a.b.b m;
    protected String n;
    protected long o;
    protected com.b.a.i.c p = new com.b.a.i.c();
    protected com.b.a.i.a q = new com.b.a.i.a();
    protected transient Request r;
    protected transient com.b.a.a.b<T> s;
    protected transient com.b.a.c.b<T> t;
    protected transient com.b.a.d.a<T> u;
    protected transient com.b.a.b.a.b<T> v;
    protected transient c.b w;

    public abstract Request a(RequestBody requestBody);

    protected abstract RequestBody a();

    public d(String str) {
        this.h = str;
        this.i = str;
        com.b.a.a a2 = com.b.a.a.a();
        String b = com.b.a.i.a.b();
        if (!TextUtils.isEmpty(b)) {
            a("Accept-Language", b);
        }
        String c = com.b.a.i.a.c();
        if (!TextUtils.isEmpty(c)) {
            a(HttpHeaders.USER_AGENT, c);
        }
        if (a2.h() != null) {
            a(a2.h());
        }
        if (a2.i() != null) {
            a(a2.i());
        }
        this.l = a2.e();
        this.m = a2.f();
        this.o = a2.g();
    }

    public R a(Object obj) {
        this.k = obj;
        return this;
    }

    public R a(com.b.a.b.b bVar) {
        this.m = bVar;
        return this;
    }

    public R b(String str) {
        com.b.a.k.b.a(str, "cacheKey == null");
        this.n = str;
        return this;
    }

    public R a(com.b.a.i.a aVar) {
        this.q.a(aVar);
        return this;
    }

    public R a(String str, String str2) {
        this.q.a(str, str2);
        return this;
    }

    public R c(String str) {
        this.q.b(str);
        return this;
    }

    public R b() {
        this.q.a();
        return this;
    }

    public R a(com.b.a.i.c cVar) {
        this.p.a(cVar);
        return this;
    }

    public R a(Map<String, String> map, boolean... zArr) {
        this.p.a(map, zArr);
        return this;
    }

    public R a(String str, String str2, boolean... zArr) {
        this.p.a(str, str2, zArr);
        return this;
    }

    public R a(String str, int i, boolean... zArr) {
        this.p.a(str, i, zArr);
        return this;
    }

    public R a(String str, float f, boolean... zArr) {
        this.p.a(str, f, zArr);
        return this;
    }

    public R a(String str, boolean z, boolean... zArr) {
        this.p.a(str, z, zArr);
        return this;
    }

    public R d(String str) {
        this.p.c(str);
        return this;
    }

    public R c() {
        this.p.a();
        return this;
    }

    public com.b.a.i.c d() {
        return this.p;
    }

    public com.b.a.i.a e() {
        return this.q;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public com.b.a.b.b h() {
        return this.m;
    }

    public com.b.a.b.a.b<T> i() {
        return this.v;
    }

    public String j() {
        return this.n;
    }

    public long k() {
        return this.o;
    }

    public int l() {
        return this.l;
    }

    public Request m() {
        return this.r;
    }

    public com.b.a.d.a<T> n() {
        if (this.u == null) {
            this.u = this.t;
        }
        com.b.a.k.b.a(this.u, "converter == null, do you forget to call Request#converter(Converter<T>) ?");
        return this.u;
    }

    public Call o() {
        RequestBody a2 = a();
        if (a2 != null) {
            c cVar = new c(a2, this.t);
            cVar.a(this.w);
            this.r = a((RequestBody) cVar);
        } else {
            this.r = a((RequestBody) null);
        }
        if (this.j == null) {
            this.j = com.b.a.a.a().d();
        }
        return this.j.newCall(this.r);
    }

    public com.b.a.a.b<T> p() {
        com.b.a.a.b<T> bVar = this.s;
        return bVar == null ? new com.b.a.a.a(this) : bVar;
    }

    public Response q() throws IOException {
        return o().execute();
    }

    public void a(com.b.a.c.b<T> bVar) {
        com.b.a.k.b.a(bVar, "callback == null");
        this.t = bVar;
        p().a(bVar);
    }
}

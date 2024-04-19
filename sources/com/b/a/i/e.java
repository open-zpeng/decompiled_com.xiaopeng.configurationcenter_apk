package com.b.a.i;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f1267a;
    private Throwable b;
    private boolean c;
    private Call d;
    private Response e;

    public static <T> e<T> a(boolean z, T t, Call call, Response response) {
        e<T> eVar = new e<>();
        eVar.a(z);
        eVar.a((e<T>) t);
        eVar.a(call);
        eVar.a(response);
        return eVar;
    }

    public static <T> e<T> a(boolean z, Call call, Response response, Throwable th) {
        e<T> eVar = new e<>();
        eVar.a(z);
        eVar.a(call);
        eVar.a(response);
        eVar.a(th);
        return eVar;
    }

    public int a() {
        Response response = this.e;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    public String b() {
        Response response = this.e;
        if (response == null) {
            return null;
        }
        return response.message();
    }

    public void a(T t) {
        this.f1267a = t;
    }

    public T c() {
        return this.f1267a;
    }

    public Throwable d() {
        return this.b;
    }

    public void a(Throwable th) {
        this.b = th;
    }

    public Call e() {
        return this.d;
    }

    public void a(Call call) {
        this.d = call;
    }

    public Response f() {
        return this.e;
    }

    public void a(Response response) {
        this.e = response;
    }

    public void a(boolean z) {
        this.c = z;
    }
}

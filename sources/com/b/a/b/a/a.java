package com.b.a.b.a;

import android.graphics.Bitmap;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
/* compiled from: BaseCachePolicy.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> f1233a;
    protected volatile boolean b;
    protected volatile int c = 0;
    protected boolean d;
    protected Call e;
    protected com.b.a.c.b<T> f;
    protected com.b.a.b.a<T> g;

    public boolean a(Call call, Response response) {
        return false;
    }

    public a(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        this.f1233a = dVar;
    }

    @Override // com.b.a.b.a.b
    public com.b.a.b.a<T> a() {
        if (this.f1233a.j() == null) {
            com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar = this.f1233a;
            dVar.b(com.b.a.k.b.a(dVar.g(), this.f1233a.d().d));
        }
        if (this.f1233a.h() == null) {
            this.f1233a.a(com.b.a.b.b.NO_CACHE);
        }
        com.b.a.b.b h = this.f1233a.h();
        if (h != com.b.a.b.b.NO_CACHE) {
            com.b.a.b.a<T> aVar = (com.b.a.b.a<T>) com.b.a.e.b.c().a(this.f1233a.j());
            this.g = aVar;
            com.b.a.k.a.a(this.f1233a, aVar, h);
            com.b.a.b.a<T> aVar2 = this.g;
            if (aVar2 != null && aVar2.a(h, this.f1233a.k(), System.currentTimeMillis())) {
                this.g.a(true);
            }
        }
        com.b.a.b.a<T> aVar3 = this.g;
        if (aVar3 == null || aVar3.e() || this.g.c() == null || this.g.b() == null) {
            this.g = null;
        }
        return this.g;
    }

    public synchronized Call b() throws Throwable {
        if (this.d) {
            throw com.b.a.f.b.a("Already executed!");
        }
        this.d = true;
        this.e = this.f1233a.o();
        if (this.b) {
            this.e.cancel();
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.e.enqueue(new Callback() { // from class: com.b.a.b.a.a.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if ((iOException instanceof SocketTimeoutException) && a.this.c < a.this.f1233a.l()) {
                    a.this.c++;
                    a aVar = a.this;
                    aVar.e = aVar.f1233a.o();
                    if (a.this.b) {
                        a.this.e.cancel();
                    } else {
                        a.this.e.enqueue(this);
                    }
                } else if (call.isCanceled()) {
                } else {
                    a.this.b(com.b.a.i.e.a(false, call, (Response) null, (Throwable) iOException));
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                if (code == 404 || code >= 500) {
                    a.this.b(com.b.a.i.e.a(false, call, response, (Throwable) com.b.a.f.b.a()));
                } else if (a.this.a(call, response)) {
                } else {
                    try {
                        T convertResponse = a.this.f1233a.n().convertResponse(response);
                        a.this.a(response.headers(), (Headers) convertResponse);
                        a.this.a(com.b.a.i.e.a(false, (Object) convertResponse, call, response));
                    } catch (Throwable th) {
                        a.this.b(com.b.a.i.e.a(false, call, response, th));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Headers headers, T t) {
        if (this.f1233a.h() == com.b.a.b.b.NO_CACHE || (t instanceof Bitmap)) {
            return;
        }
        com.b.a.b.a<T> a2 = com.b.a.k.a.a(headers, t, this.f1233a.h(), this.f1233a.j());
        if (a2 == null) {
            com.b.a.e.b.c().b(this.f1233a.j());
        } else {
            com.b.a.e.b.c().a(this.f1233a.j(), a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        com.b.a.a.a().c().post(runnable);
    }
}

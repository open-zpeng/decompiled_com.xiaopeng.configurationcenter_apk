package com.b.a.b.a;

import okhttp3.Call;
import okhttp3.Response;
/* compiled from: DefaultCachePolicy.java */
/* loaded from: classes.dex */
public class c<T> extends a<T> {
    public c(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        super(dVar);
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.f.onSuccess(eVar);
                c.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void b(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.f.onError(eVar);
                c.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.a
    public boolean a(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        if (this.g == null) {
            final com.b.a.i.e a2 = com.b.a.i.e.a(true, call, response, (Throwable) com.b.a.f.a.a(this.f1233a.j()));
            a(new Runnable() { // from class: com.b.a.b.a.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f.onError(a2);
                    c.this.f.onFinish();
                }
            });
        } else {
            final com.b.a.i.e a3 = com.b.a.i.e.a(true, (Object) this.g.c(), call, response);
            a(new Runnable() { // from class: com.b.a.b.a.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f.onCacheSuccess(a3);
                    c.this.f.onFinish();
                }
            });
        }
        return true;
    }

    @Override // com.b.a.b.a.b
    public void a(com.b.a.b.a<T> aVar, com.b.a.c.b<T> bVar) {
        this.f = bVar;
        a(new Runnable() { // from class: com.b.a.b.a.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.f.onStart(c.this.f1233a);
                try {
                    c.this.b();
                    c.this.c();
                } catch (Throwable th) {
                    c.this.f.onError(com.b.a.i.e.a(false, c.this.e, (Response) null, th));
                }
            }
        });
    }
}

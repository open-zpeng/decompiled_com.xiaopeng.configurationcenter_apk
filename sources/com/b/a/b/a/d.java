package com.b.a.b.a;

import okhttp3.Response;
/* compiled from: FirstCacheRequestPolicy.java */
/* loaded from: classes.dex */
public class d<T> extends a<T> {
    public d(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        super(dVar);
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.f.onSuccess(eVar);
                d.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void b(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.f.onError(eVar);
                d.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.b.a<T> aVar, com.b.a.c.b<T> bVar) {
        this.f = bVar;
        a(new Runnable() { // from class: com.b.a.b.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.f.onStart(d.this.f1233a);
                try {
                    d.this.b();
                    com.b.a.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        d.this.f.onCacheSuccess(com.b.a.i.e.a(true, aVar2.c(), d.this.e, (Response) null));
                    }
                    d.this.c();
                } catch (Throwable th) {
                    d.this.f.onError(com.b.a.i.e.a(false, d.this.e, (Response) null, th));
                }
            }
        });
    }
}

package com.b.a.b.a;

import okhttp3.Response;
/* compiled from: NoneCacheRequestPolicy.java */
/* loaded from: classes.dex */
public class f<T> extends a<T> {
    public f(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        super(dVar);
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.f.onSuccess(eVar);
                f.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void b(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.f.onError(eVar);
                f.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.b.a<T> aVar, com.b.a.c.b<T> bVar) {
        this.f = bVar;
        a(new Runnable() { // from class: com.b.a.b.a.f.3
            @Override // java.lang.Runnable
            public void run() {
                f.this.f.onStart(f.this.f1233a);
                try {
                    f.this.b();
                    com.b.a.b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        f.this.f.onCacheSuccess(com.b.a.i.e.a(true, aVar2.c(), f.this.e, (Response) null));
                        f.this.f.onFinish();
                        return;
                    }
                    f.this.c();
                } catch (Throwable th) {
                    f.this.f.onError(com.b.a.i.e.a(false, f.this.e, (Response) null, th));
                }
            }
        });
    }
}

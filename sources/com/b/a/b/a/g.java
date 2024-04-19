package com.b.a.b.a;

import okhttp3.Response;
/* compiled from: RequestFailedCachePolicy.java */
/* loaded from: classes.dex */
public class g<T> extends a<T> {
    public g(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        super(dVar);
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.f.onSuccess(eVar);
                g.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void b(final com.b.a.i.e<T> eVar) {
        if (this.g != null) {
            final com.b.a.i.e a2 = com.b.a.i.e.a(true, (Object) this.g.c(), eVar.e(), eVar.f());
            a(new Runnable() { // from class: com.b.a.b.a.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f.onCacheSuccess(a2);
                    g.this.f.onFinish();
                }
            });
            return;
        }
        a(new Runnable() { // from class: com.b.a.b.a.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.f.onError(eVar);
                g.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void a(com.b.a.b.a<T> aVar, com.b.a.c.b<T> bVar) {
        this.f = bVar;
        a(new Runnable() { // from class: com.b.a.b.a.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.f.onStart(g.this.f1233a);
                try {
                    g.this.b();
                    g.this.c();
                } catch (Throwable th) {
                    g.this.f.onError(com.b.a.i.e.a(false, g.this.e, (Response) null, th));
                }
            }
        });
    }
}

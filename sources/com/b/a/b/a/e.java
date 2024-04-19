package com.b.a.b.a;

import okhttp3.Response;
/* compiled from: NoCachePolicy.java */
/* loaded from: classes.dex */
public class e<T> extends a<T> {
    public e(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
        super(dVar);
    }

    @Override // com.b.a.b.a.b
    public void a(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.f.onSuccess(eVar);
                e.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void b(final com.b.a.i.e<T> eVar) {
        a(new Runnable() { // from class: com.b.a.b.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.f.onError(eVar);
                e.this.f.onFinish();
            }
        });
    }

    @Override // com.b.a.b.a.b
    public void a(com.b.a.b.a<T> aVar, com.b.a.c.b<T> bVar) {
        this.f = bVar;
        a(new Runnable() { // from class: com.b.a.b.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.f.onStart(e.this.f1233a);
                try {
                    e.this.b();
                    e.this.c();
                } catch (Throwable th) {
                    e.this.f.onError(com.b.a.i.e.a(false, e.this.e, (Response) null, th));
                }
            }
        });
    }
}

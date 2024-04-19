package com.b.a.c;

import com.b.a.i.d;
import com.b.a.i.e;
/* compiled from: AbsCallback.java */
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {
    public void downloadProgress(d dVar) {
    }

    @Override // com.b.a.c.b
    public void onCacheSuccess(e<T> eVar) {
    }

    @Override // com.b.a.c.b
    public void onFinish() {
    }

    @Override // com.b.a.c.b
    public void onStart(com.b.a.j.a.d<T, ? extends com.b.a.j.a.d> dVar) {
    }

    @Override // com.b.a.c.b
    public void uploadProgress(d dVar) {
    }

    @Override // com.b.a.c.b
    public void onError(e<T> eVar) {
        com.b.a.k.d.a(eVar.d());
    }
}

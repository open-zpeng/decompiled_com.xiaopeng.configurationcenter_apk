package com.b.a.c;

import com.b.a.i.e;
import com.b.a.j.a.d;
/* compiled from: Callback.java */
/* loaded from: classes.dex */
public interface b<T> extends com.b.a.d.a<T> {
    void onCacheSuccess(e<T> eVar);

    void onError(e<T> eVar);

    void onFinish();

    void onStart(d<T, ? extends d> dVar);

    void onSuccess(e<T> eVar);

    void uploadProgress(com.b.a.i.d dVar);
}

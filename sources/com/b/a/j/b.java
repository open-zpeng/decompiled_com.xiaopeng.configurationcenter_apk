package com.b.a.j;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HeadRequest.java */
/* loaded from: classes.dex */
public class b<T> extends com.b.a.j.a.b<T, b<T>> {
    public b(String str) {
        super(str);
    }

    @Override // com.b.a.j.a.d
    public Request a(RequestBody requestBody) {
        return b(requestBody).head().url(this.h).tag(this.k).build();
    }
}

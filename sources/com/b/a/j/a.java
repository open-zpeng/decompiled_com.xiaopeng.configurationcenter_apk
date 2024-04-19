package com.b.a.j;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: GetRequest.java */
/* loaded from: classes.dex */
public class a<T> extends com.b.a.j.a.b<T, a<T>> {
    public a(String str) {
        super(str);
    }

    @Override // com.b.a.j.a.d
    public Request a(RequestBody requestBody) {
        return b(requestBody).get().url(this.h).tag(this.k).build();
    }
}

package com.b.a.j;

import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: PostRequest.java */
/* loaded from: classes.dex */
public class c<T> extends com.b.a.j.a.a<T, c<T>> {
    public c(String str) {
        super(str);
    }

    @Override // com.b.a.j.a.d
    public Request a(RequestBody requestBody) {
        return b(requestBody).post(requestBody).url(this.h).tag(this.k).build();
    }
}

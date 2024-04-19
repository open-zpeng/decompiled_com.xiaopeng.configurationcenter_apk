package com.b.a.j.a;

import com.b.a.j.a.b;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: NoBodyRequest.java */
/* loaded from: classes.dex */
public abstract class b<T, R extends b> extends d<T, R> {
    private static final long serialVersionUID = 1200621102761691196L;

    @Override // com.b.a.j.a.d
    public RequestBody a() {
        return null;
    }

    public b(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder b(RequestBody requestBody) {
        this.h = com.b.a.k.b.a(this.i, this.p.d);
        return com.b.a.k.b.a(new Request.Builder(), this.q);
    }
}

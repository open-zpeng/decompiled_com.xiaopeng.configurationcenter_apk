package com.b.a.c;

import okhttp3.Response;
/* compiled from: StringCallback.java */
/* loaded from: classes.dex */
public abstract class c extends a<String> {
    private com.b.a.d.b convert = new com.b.a.d.b();

    @Override // com.b.a.d.a
    public String convertResponse(Response response) throws Throwable {
        String convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}

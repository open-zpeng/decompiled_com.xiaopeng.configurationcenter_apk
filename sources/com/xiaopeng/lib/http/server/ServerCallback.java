package com.xiaopeng.lib.http.server;

import com.b.a.c.a;
import com.b.a.c.b;
import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class ServerCallback extends a<ServerBean> implements b<ServerBean> {
    public static final int CODE_SUCCESS = 200;
    private ServerConvert convert = new ServerConvert();

    @Override // com.b.a.d.a
    public ServerBean convertResponse(Response response) throws Throwable {
        ServerBean convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}

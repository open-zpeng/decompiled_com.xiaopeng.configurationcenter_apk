package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.b.a.c.a;
import com.b.a.c.b;
import okhttp3.Response;
/* loaded from: classes.dex */
public abstract class ServerCallbackImpl extends a<ServerBean> implements b<ServerBean> {
    private ServerConverter convert = new ServerConverter();

    @Override // com.b.a.d.a
    public ServerBean convertResponse(Response response) throws Throwable {
        ServerBean convertResponse = this.convert.convertResponse(response);
        response.close();
        return convertResponse;
    }
}

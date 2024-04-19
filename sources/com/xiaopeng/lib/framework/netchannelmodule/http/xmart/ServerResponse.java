package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.b.a.i.e;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse;
/* loaded from: classes.dex */
public class ServerResponse implements IXmartResponse {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    e<ServerBean> mInternalResponse;

    public ServerResponse(e<ServerBean> eVar) {
        this.mInternalResponse = eVar;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public int code() {
        return this.mInternalResponse.a();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public ServerBean body() {
        return this.mInternalResponse.c();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public String message() {
        return this.mInternalResponse.b();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IXmartResponse
    public Throwable getException() {
        return this.mInternalResponse.d();
    }
}

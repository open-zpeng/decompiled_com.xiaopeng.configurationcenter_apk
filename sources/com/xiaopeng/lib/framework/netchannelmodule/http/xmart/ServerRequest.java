package com.xiaopeng.lib.framework.netchannelmodule.http.xmart;

import com.b.a.i.e;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerCallback;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter;
/* loaded from: classes.dex */
public class ServerRequest extends BasePostRequestAdapter<ServerBean> {
    public ServerRequest(String str) {
        super(str);
    }

    @Override // com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.BasePostRequestAdapter, com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(IServerCallback iServerCallback) {
        super.execute(new ServerCallbackImplAdapter(iServerCallback));
    }

    /* loaded from: classes.dex */
    public class ServerCallbackImplAdapter extends ServerCallbackImpl {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private IServerCallback mOuterCallback;

        public ServerCallbackImplAdapter(IServerCallback iServerCallback) {
            this.mOuterCallback = iServerCallback;
        }

        @Override // com.b.a.c.a, com.b.a.c.b
        public void onError(e<ServerBean> eVar) {
            super.onError(eVar);
            this.mOuterCallback.onFailure(new ServerResponse(eVar));
        }

        @Override // com.b.a.c.b
        public void onSuccess(e<ServerBean> eVar) {
            this.mOuterCallback.onSuccess(new ServerResponse(eVar));
        }
    }
}

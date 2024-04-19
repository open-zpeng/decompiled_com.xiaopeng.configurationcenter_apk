package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import com.b.a.c.c;
import com.b.a.i.e;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
/* loaded from: classes.dex */
public class StringCallbackAdapter extends c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Callback mOuterCallback;

    public StringCallbackAdapter(Callback callback) {
        this.mOuterCallback = callback;
    }

    @Override // com.b.a.c.a, com.b.a.c.b
    public void onError(e<String> eVar) {
        super.onError(eVar);
        this.mOuterCallback.onFailure(new ResponseAdapter(eVar));
    }

    @Override // com.b.a.c.b
    public void onSuccess(e<String> eVar) {
        this.mOuterCallback.onSuccess(new ResponseAdapter(eVar));
    }
}

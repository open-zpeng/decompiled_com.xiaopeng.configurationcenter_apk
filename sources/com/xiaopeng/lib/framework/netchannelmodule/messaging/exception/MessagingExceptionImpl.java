package com.xiaopeng.lib.framework.netchannelmodule.messaging.exception;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException;
import org.eclipse.paho.a.a.n;
/* loaded from: classes.dex */
public class MessagingExceptionImpl extends MessagingException {
    private static final long serialVersionUID = 100;
    private int mProtocolReasonCode;
    private int mReasonCode;

    public MessagingExceptionImpl(int i) {
        super("");
        this.mReasonCode = i;
        this.mProtocolReasonCode = 0;
    }

    public MessagingExceptionImpl(n nVar) {
        super(nVar.getMessage());
        this.mReasonCode = 1;
        this.mProtocolReasonCode = nVar.a();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException
    public int getReasonCode() {
        return this.mReasonCode;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging.MessagingException
    public int getProtocolReasonCode() {
        return this.mProtocolReasonCode;
    }
}

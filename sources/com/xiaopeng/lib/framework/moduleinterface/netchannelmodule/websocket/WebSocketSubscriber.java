package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import a.a.b.b;
import a.a.k;
import okio.ByteString;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements k<IWebSocketInfo> {
    private b disposable;
    private boolean hasOpened;

    protected void onClose() {
    }

    protected void onClosed(int i, String str) {
    }

    protected void onMessage(String str) {
    }

    protected void onMessage(ByteString byteString) {
    }

    protected void onOpen() {
    }

    protected void onReconnect() {
    }

    @Override // a.a.k
    public final void onNext(IWebSocketInfo iWebSocketInfo) {
        if (iWebSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (iWebSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(iWebSocketInfo.closedReasonCode(), iWebSocketInfo.closedReason());
        } else if (iWebSocketInfo.stringMessage() != null) {
            onMessage(iWebSocketInfo.stringMessage());
        } else if (iWebSocketInfo.byteStringMessage() != null) {
            onMessage(iWebSocketInfo.byteStringMessage());
        } else if (iWebSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }

    @Override // a.a.k
    public final void onSubscribe(b bVar) {
        this.disposable = bVar;
    }

    public final void dispose() {
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // a.a.k
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // a.a.k
    public void onError(Throwable th) {
        th.printStackTrace();
    }
}

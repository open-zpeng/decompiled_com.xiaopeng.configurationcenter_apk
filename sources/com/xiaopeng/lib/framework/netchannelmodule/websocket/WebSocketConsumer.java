package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import a.a.d.e;
import okhttp3.WebSocket;
import okio.ByteString;
@Deprecated
/* loaded from: classes.dex */
abstract class WebSocketConsumer implements e<WebSocketInfo> {
    public abstract void onClosed(WebSocket webSocket);

    public abstract void onMessage(String str);

    public abstract void onMessage(ByteString byteString);

    public abstract void onOpen(WebSocket webSocket);

    WebSocketConsumer() {
    }

    @Override // a.a.d.e
    public void accept(WebSocketInfo webSocketInfo) throws Exception {
        if (webSocketInfo.isOnOpen()) {
            onOpen(webSocketInfo.getWebSocket());
        } else if (webSocketInfo.isClosed()) {
            onClosed(webSocketInfo.getWebSocket());
        } else if (webSocketInfo.stringMessage() != null) {
            onMessage(webSocketInfo.stringMessage());
        } else if (webSocketInfo.byteStringMessage() != null) {
            onMessage(webSocketInfo.byteStringMessage());
        }
    }
}

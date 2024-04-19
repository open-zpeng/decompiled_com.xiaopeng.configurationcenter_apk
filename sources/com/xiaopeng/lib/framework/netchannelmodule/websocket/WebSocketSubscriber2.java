package com.xiaopeng.lib.framework.netchannelmodule.websocket;

import a.a.d.e;
import a.a.d.f;
import a.a.g;
import a.a.i.a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber2<T> extends WebSocketSubscriber {
    private static final Gson GSON = new Gson();
    protected Type type;

    public abstract void onMessage(T t);

    public WebSocketSubscriber2() {
        analysisType();
    }

    private void analysisType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("No generics found!");
        }
        this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket.WebSocketSubscriber
    public void onMessage(String str) {
        g.a(str).a((f) new f<String, T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.2
            @Override // a.a.d.f
            public T apply(String str2) throws Exception {
                try {
                    return (T) WebSocketSubscriber2.GSON.fromJson(str2, WebSocketSubscriber2.this.type);
                } catch (JsonSyntaxException unused) {
                    return (T) WebSocketSubscriber2.GSON.fromJson((String) WebSocketSubscriber2.GSON.fromJson(str2, (Class<Object>) String.class), WebSocketSubscriber2.this.type);
                }
            }
        }).b(a.b()).a(a.a.a.b.a.a()).b((e<T>) new e<T>() { // from class: com.xiaopeng.lib.framework.netchannelmodule.websocket.WebSocketSubscriber2.1
            @Override // a.a.d.e
            public void accept(T t) throws Exception {
                WebSocketSubscriber2.this.onMessage((WebSocketSubscriber2) t);
            }
        });
    }
}

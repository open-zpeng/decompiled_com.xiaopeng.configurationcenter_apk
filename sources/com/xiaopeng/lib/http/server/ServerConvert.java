package com.xiaopeng.lib.http.server;

import com.b.a.d.a;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ServerConvert implements a<ServerBean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.b.a.d.a
    public ServerBean convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            throw new IllegalStateException("null");
        }
        ServerBean serverBean = new ServerBean();
        JSONObject jSONObject = new JSONObject(body.string());
        serverBean.setCode(jSONObject.getInt("code"));
        try {
            serverBean.setData(jSONObject.getString("data"));
        } catch (Throwable unused) {
        }
        try {
            serverBean.setMsg(jSONObject.getString("msg"));
        } catch (Throwable unused2) {
        }
        return serverBean;
    }
}

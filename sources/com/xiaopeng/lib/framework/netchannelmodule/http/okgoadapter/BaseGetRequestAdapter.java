package com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter;

import com.b.a.c.b;
import com.b.a.j.a;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.xmart.IServerCallback;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.common.TrafficStatsEntry;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class BaseGetRequestAdapter<T> implements IRequest {
    private a<T> mInternalRequest;

    public BaseGetRequestAdapter(String str) {
        this.mInternalRequest = new a<>(str);
        if (GlobalConfig.getApplicationContext() != null) {
            headers(GlobalConfig.PACKAGE_IDENTIFIER, GlobalConfig.getApplicationName());
        }
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest uploadJson(String str) {
        throw new RuntimeException("GET请求不支持POST操作!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest uploadFile(String str) {
        throw new RuntimeException("GET请求不支持POST操作!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IResponse execute() throws IOException {
        TrafficStatsEntry.setTraficInfo();
        return new ResponseAdapter(this.mInternalRequest.q());
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(Callback callback) {
        throw new RuntimeException("Not supported!!!");
    }

    public void execute(b bVar) {
        this.mInternalRequest.a(bVar);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public void execute(IServerCallback iServerCallback) {
        throw new RuntimeException("Not supported!!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public String getUrl() {
        return this.mInternalRequest.f();
    }

    public com.b.a.i.a getHeaders() {
        return this.mInternalRequest.e();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest headers(String str, String str2) {
        this.mInternalRequest.a(str, str2);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest isMultipart(boolean z) {
        throw new RuntimeException("GET请求不支持Multipart设置!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeHeader(String str) {
        this.mInternalRequest.c(str);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeAllHeaders() {
        this.mInternalRequest.b();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest tag(Object obj) {
        this.mInternalRequest.a(obj);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(Map<String, String> map, boolean... zArr) {
        this.mInternalRequest.a(map, zArr);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String str, String str2) {
        this.mInternalRequest.a(str, str2, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String str, int i) {
        this.mInternalRequest.a(str, i, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String str, float f) {
        this.mInternalRequest.a(str, f, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String str, boolean z) {
        this.mInternalRequest.a(str, z, new boolean[0]);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest params(String str, File file) {
        throw new RuntimeException("GET请求不支持File参数!!");
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeParam(String str) {
        this.mInternalRequest.d(str);
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public IRequest removeAllParams() {
        this.mInternalRequest.c();
        this.mInternalRequest.m().headers();
        return this;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public String header(String str) {
        return this.mInternalRequest.e().a(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest
    public Map<String, List<String>> headers() {
        if (this.mInternalRequest.m() == null || this.mInternalRequest.m().headers() == null) {
            return null;
        }
        return this.mInternalRequest.m().headers().toMultimap();
    }
}

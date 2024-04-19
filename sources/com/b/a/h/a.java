package com.b.a.h;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.b.a.k.c;
import com.b.a.k.d;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* compiled from: HttpLoggingInterceptor.java */
/* loaded from: classes.dex */
public class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private static final Charset f1260a = Charset.forName(XmartV1Constants.UTF8_ENCODING);
    private volatile EnumC0085a b = EnumC0085a.NONE;
    private Level c;
    private Logger d;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: com.b.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0085a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public a(String str) {
        this.d = Logger.getLogger(str);
    }

    public void a(EnumC0085a enumC0085a) {
        Objects.requireNonNull(this.b, "printLevel == null. Use Level.NONE instead.");
        this.b = enumC0085a;
    }

    public void a(Level level) {
        this.c = level;
    }

    private void a(String str) {
        this.d.log(this.c, str);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (this.b == EnumC0085a.NONE) {
            return chain.proceed(request);
        }
        a(request, chain.connection());
        long nanoTime = System.nanoTime();
        try {
            return a(chain.proceed(request), TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime));
        } catch (Exception e) {
            a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    private void a(Request request, Connection connection) throws IOException {
        StringBuilder sb;
        boolean z = this.b == EnumC0085a.BODY;
        boolean z2 = this.b == EnumC0085a.BODY || this.b == EnumC0085a.HEADERS;
        RequestBody body = request.body();
        boolean z3 = body != null;
        try {
            try {
                a("--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1));
                if (z2) {
                    if (z3) {
                        if (body.contentType() != null) {
                            a("\tContent-Type: " + body.contentType());
                        }
                        if (body.contentLength() != -1) {
                            a("\tContent-Length: " + body.contentLength());
                        }
                    }
                    Headers headers = request.headers();
                    int size = headers.size();
                    for (int i = 0; i < size; i++) {
                        String name = headers.name(i);
                        if (!"Content-Type".equalsIgnoreCase(name) && !HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name)) {
                            a("\t" + name + ": " + headers.value(i));
                        }
                    }
                    a(" ");
                    if (z && z3) {
                        if (b(body.contentType())) {
                            a(request);
                        } else {
                            a("\tbody: maybe [binary body], omitted!");
                        }
                    }
                }
                sb = new StringBuilder();
            } catch (Exception e) {
                d.a(e);
                sb = new StringBuilder();
            }
            a(sb.append("--> END ").append(request.method()).toString());
        } catch (Throwable th) {
            a("--> END " + request.method());
            throw th;
        }
    }

    private Response a(Response response, long j) {
        Headers headers;
        Response build = response.newBuilder().build();
        ResponseBody body = build.body();
        boolean z = true;
        boolean z2 = this.b == EnumC0085a.BODY;
        if (this.b != EnumC0085a.BODY && this.b != EnumC0085a.HEADERS) {
            z = false;
        }
        try {
            try {
                a("<-- " + build.code() + ' ' + build.message() + ' ' + build.request().url() + " (" + j + "ms）");
                if (z) {
                    int size = build.headers().size();
                    for (int i = 0; i < size; i++) {
                        a("\t" + headers.name(i) + ": " + headers.value(i));
                    }
                    a(" ");
                    if (z2 && okhttp3.internal.http.HttpHeaders.hasBody(build)) {
                        if (body == null) {
                            return response;
                        }
                        if (b(body.contentType())) {
                            byte[] a2 = c.a(body.byteStream());
                            a("\tbody:" + new String(a2, a(body.contentType())));
                            return response.newBuilder().body(ResponseBody.create(body.contentType(), a2)).build();
                        }
                        a("\tbody: maybe [binary body], omitted!");
                    }
                }
            } catch (Exception e) {
                d.a(e);
            }
            return response;
        } finally {
            a("<-- END HTTP");
        }
    }

    private static Charset a(MediaType mediaType) {
        Charset charset = mediaType != null ? mediaType.charset(f1260a) : f1260a;
        return charset == null ? f1260a : charset;
    }

    private static boolean b(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        if (mediaType.type() == null || !mediaType.type().equals("text")) {
            String subtype = mediaType.subtype();
            if (subtype != null) {
                String lowerCase = subtype.toLowerCase();
                if (lowerCase.contains("x-www-form-urlencoded") || lowerCase.contains("json") || lowerCase.contains("xml") || lowerCase.contains("html")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void a(Request request) {
        try {
            RequestBody body = request.newBuilder().build().body();
            if (body == null) {
                return;
            }
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            a("\tbody:" + buffer.readString(a(body.contentType())));
        } catch (Exception e) {
            d.a(e);
        }
    }
}

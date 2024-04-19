package com.b.a.j.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.b.a.j.a.a;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: BodyRequest.java */
/* loaded from: classes.dex */
public abstract class a<T, R extends a> extends d<T, R> {
    private static final long serialVersionUID = -6459175248476927501L;

    /* renamed from: a  reason: collision with root package name */
    protected transient MediaType f1268a;
    protected String b;
    protected byte[] c;
    protected transient File d;
    protected boolean e;
    protected boolean f;
    protected RequestBody g;

    public a(String str) {
        super(str);
        this.e = false;
        this.f = false;
    }

    public R a(boolean z) {
        this.e = z;
        return this;
    }

    public R a(String str, File file) {
        this.p.a(str, file);
        return this;
    }

    public R a(String str) {
        this.b = str;
        this.f1268a = com.b.a.i.c.b;
        return this;
    }

    public R a(File file) {
        this.d = file;
        this.f1268a = com.b.a.k.b.a(file.getName());
        return this;
    }

    @Override // com.b.a.j.a.d
    public RequestBody a() {
        MediaType mediaType;
        MediaType mediaType2;
        MediaType mediaType3;
        if (this.f) {
            this.h = com.b.a.k.b.a(this.i, this.p.d);
        }
        RequestBody requestBody = this.g;
        if (requestBody != null) {
            return requestBody;
        }
        String str = this.b;
        if (str == null || (mediaType3 = this.f1268a) == null) {
            byte[] bArr = this.c;
            if (bArr == null || (mediaType2 = this.f1268a) == null) {
                File file = this.d;
                return (file == null || (mediaType = this.f1268a) == null) ? com.b.a.k.b.a(this.p, this.e) : RequestBody.create(mediaType, file);
            }
            return RequestBody.create(mediaType2, bArr);
        }
        return RequestBody.create(mediaType3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Request.Builder b(RequestBody requestBody) {
        try {
            a(HttpHeaders.CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            com.b.a.k.d.a(e);
        }
        return com.b.a.k.b.a(new Request.Builder(), this.q);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MediaType mediaType = this.f1268a;
        objectOutputStream.writeObject(mediaType == null ? "" : mediaType.toString());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1268a = MediaType.parse(str);
    }
}

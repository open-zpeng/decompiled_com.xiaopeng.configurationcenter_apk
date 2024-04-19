package com.b.a.f;
/* compiled from: HttpException.java */
/* loaded from: classes.dex */
public class b extends RuntimeException {
    private static final long serialVersionUID = 8773734741709178425L;

    public b(String str) {
        super(str);
    }

    public static b a() {
        return new b("network error! http response code is 404 or 5xx!");
    }

    public static b a(String str) {
        return new b(str);
    }
}

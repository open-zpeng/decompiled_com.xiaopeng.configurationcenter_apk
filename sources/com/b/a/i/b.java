package com.b.a.i;
/* compiled from: HttpMethod.java */
/* loaded from: classes.dex */
public enum b {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    HEAD("HEAD"),
    PATCH("PATCH"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f1262a;

    b(String str) {
        this.f1262a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1262a;
    }

    /* compiled from: HttpMethod.java */
    /* renamed from: com.b.a.i.b$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1263a;

        static {
            int[] iArr = new int[b.values().length];
            f1263a = iArr;
            try {
                iArr[b.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1263a[b.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1263a[b.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1263a[b.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1263a[b.OPTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean hasBody() {
        int i = AnonymousClass1.f1263a[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }
}

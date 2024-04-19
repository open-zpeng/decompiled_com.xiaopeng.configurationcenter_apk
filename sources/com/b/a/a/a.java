package com.b.a.a;

import com.b.a.b.a.c;
import com.b.a.b.a.e;
import com.b.a.b.a.f;
import com.b.a.b.a.g;
import com.b.a.j.a.d;
/* compiled from: CacheCall.java */
/* loaded from: classes.dex */
public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private com.b.a.b.a.b<T> f1229a;
    private d<T, ? extends d> b;

    public a(d<T, ? extends d> dVar) {
        this.f1229a = null;
        this.b = dVar;
        this.f1229a = b();
    }

    @Override // com.b.a.a.b
    public void a(com.b.a.c.b<T> bVar) {
        com.b.a.k.b.a(bVar, "callback == null");
        this.f1229a.a(this.f1229a.a(), bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheCall.java */
    /* renamed from: com.b.a.a.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1231a;

        static {
            int[] iArr = new int[com.b.a.b.b.values().length];
            f1231a = iArr;
            try {
                iArr[com.b.a.b.b.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1231a[com.b.a.b.b.NO_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1231a[com.b.a.b.b.IF_NONE_CACHE_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1231a[com.b.a.b.b.FIRST_CACHE_THEN_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1231a[com.b.a.b.b.REQUEST_FAILED_READ_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private com.b.a.b.a.b<T> b() {
        int i = AnonymousClass1.f1231a[this.b.h().ordinal()];
        if (i == 1) {
            this.f1229a = new c(this.b);
        } else if (i == 2) {
            this.f1229a = new e(this.b);
        } else if (i == 3) {
            this.f1229a = new f(this.b);
        } else if (i == 4) {
            this.f1229a = new com.b.a.b.a.d(this.b);
        } else if (i == 5) {
            this.f1229a = new g(this.b);
        }
        if (this.b.i() != null) {
            this.f1229a = this.b.i();
        }
        com.b.a.k.b.a(this.f1229a, "policy == null");
        return this.f1229a;
    }

    /* renamed from: a */
    public b<T> clone() {
        return new a(this.b);
    }
}

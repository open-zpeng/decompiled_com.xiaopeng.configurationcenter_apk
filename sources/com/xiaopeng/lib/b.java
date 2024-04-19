package com.xiaopeng.lib;
/* compiled from: InitEventHolder.java */
/* loaded from: classes.dex */
public class b implements a {
    private static volatile b b = new b();

    /* renamed from: a  reason: collision with root package name */
    private a f1374a;

    @Override // com.xiaopeng.lib.a
    public void a(int i, String str) {
        a aVar = this.f1374a;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    public static a a() {
        return b;
    }

    public static void a(a aVar) {
        b.f1374a = aVar;
    }
}

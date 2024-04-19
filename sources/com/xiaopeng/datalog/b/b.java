package com.xiaopeng.datalog.b;

import com.google.gson.Gson;
/* compiled from: GlobalGsonInstance.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Gson f1363a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlobalGsonInstance.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final b f1364a = new b();
    }

    public static b a() {
        return a.f1364a;
    }

    private b() {
        this.f1363a = new Gson();
    }

    public Gson b() {
        return this.f1363a;
    }
}

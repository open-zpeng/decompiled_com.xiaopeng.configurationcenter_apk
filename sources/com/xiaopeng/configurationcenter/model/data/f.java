package com.xiaopeng.configurationcenter.model.data;

import com.xiaopeng.lib.framework.configuration.ConfigurationDataImpl;
/* compiled from: ConfigurationDataEntity.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f1350a = "";
    public String b = "";
    public String c = "";
    public String d = "";

    public static f a(String str, String str2) {
        f fVar = new f();
        fVar.f1350a = str;
        fVar.b = str2;
        return fVar;
    }

    public ConfigurationDataImpl a() {
        return new ConfigurationDataImpl(this.b, this.d);
    }

    public String toString() {
        return "ConfigurationDataEntity { appID:" + this.f1350a + "; key:" + this.b + "; version:" + this.c + "; value:" + this.d + "; }";
    }
}

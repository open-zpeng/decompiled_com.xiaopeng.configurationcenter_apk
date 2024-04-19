package com.a.a;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class l extends s {

    /* renamed from: a  reason: collision with root package name */
    private final com.a.a.b.h<String, s> f1054a = new com.a.a.b.h<>();

    public void a(String str, s sVar) {
        if (sVar == null) {
            sVar = j.f1053a;
        }
        this.f1054a.put(str, sVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f1054a.equals(this.f1054a));
    }

    public Set<Map.Entry<String, s>> g() {
        return this.f1054a.entrySet();
    }

    public int hashCode() {
        return this.f1054a.hashCode();
    }
}

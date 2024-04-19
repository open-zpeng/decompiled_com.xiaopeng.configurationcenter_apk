package com.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class h extends s implements Iterable<s> {

    /* renamed from: a  reason: collision with root package name */
    private final List<s> f1052a = new ArrayList();

    @Override // com.a.a.s
    public Number a() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public void a(s sVar) {
        if (sVar == null) {
            sVar = j.f1053a;
        }
        this.f1052a.add(sVar);
    }

    @Override // com.a.a.s
    public String b() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.s
    public double c() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.s
    public long d() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.a.a.s
    public int e() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f1052a.equals(this.f1052a));
    }

    @Override // com.a.a.s
    public boolean f() {
        if (this.f1052a.size() == 1) {
            return this.f1052a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f1052a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<s> iterator() {
        return this.f1052a.iterator();
    }
}

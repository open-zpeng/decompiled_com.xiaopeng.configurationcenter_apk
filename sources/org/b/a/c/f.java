package org.b.a.c;
/* loaded from: classes.dex */
final class f {

    /* renamed from: a  reason: collision with root package name */
    private int f1410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f1410a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar) {
        this.f1410a = fVar.f1410a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1410a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int i = this.f1410a;
        this.f1410a = i <= 3 ? 0 : i <= 9 ? i - 3 : i - 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f1410a = this.f1410a >= 7 ? 10 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f1410a = this.f1410a < 7 ? 8 : 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f1410a = this.f1410a < 7 ? 9 : 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f1410a < 7;
    }
}

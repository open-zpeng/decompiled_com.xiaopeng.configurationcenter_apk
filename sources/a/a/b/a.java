package a.a.b;

import a.a.e.h.f;
import java.util.ArrayList;
/* compiled from: CompositeDisposable.java */
/* loaded from: classes.dex */
public final class a implements b, a.a.e.a.b {

    /* renamed from: a  reason: collision with root package name */
    f<b> f142a;
    volatile boolean b;

    @Override // a.a.b.b
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            f<b> fVar = this.f142a;
            this.f142a = null;
            a(fVar);
        }
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.b;
    }

    @Override // a.a.e.a.b
    public boolean a(b bVar) {
        a.a.e.b.b.a(bVar, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    f<b> fVar = this.f142a;
                    if (fVar == null) {
                        fVar = new f<>();
                        this.f142a = fVar;
                    }
                    fVar.a((f<b>) bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // a.a.e.a.b
    public boolean b(b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // a.a.e.a.b
    public boolean c(b bVar) {
        a.a.e.b.b.a(bVar, "disposables is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            f<b> fVar = this.f142a;
            if (fVar != null && fVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    void a(f<b> fVar) {
        Object[] b;
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    a.a.c.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw a.a.e.h.d.a((Throwable) arrayList.get(0));
            }
            throw new a.a.c.a(arrayList);
        }
    }
}

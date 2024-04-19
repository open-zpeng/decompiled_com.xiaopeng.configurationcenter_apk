package a.a.e.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes.dex */
public final class e implements a.a.b.b, b {

    /* renamed from: a  reason: collision with root package name */
    List<a.a.b.b> f147a;
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
            List<a.a.b.b> list = this.f147a;
            this.f147a = null;
            a(list);
        }
    }

    @Override // a.a.b.b
    public boolean isDisposed() {
        return this.b;
    }

    @Override // a.a.e.a.b
    public boolean a(a.a.b.b bVar) {
        a.a.e.b.b.a(bVar, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List list = this.f147a;
                    if (list == null) {
                        list = new LinkedList();
                        this.f147a = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // a.a.e.a.b
    public boolean b(a.a.b.b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    @Override // a.a.e.a.b
    public boolean c(a.a.b.b bVar) {
        a.a.e.b.b.a(bVar, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            List<a.a.b.b> list = this.f147a;
            if (list != null && list.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    void a(List<a.a.b.b> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (a.a.b.b bVar : list) {
            try {
                bVar.dispose();
            } catch (Throwable th) {
                a.a.c.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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

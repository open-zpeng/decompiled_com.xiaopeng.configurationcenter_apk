package a.a.e.g;

import a.a.l;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* loaded from: classes.dex */
public final class f extends a.a.l {
    private static final h c = new h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory b;

    public f() {
        this(c);
    }

    public f(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    @Override // a.a.l
    public l.b a() {
        return new g(this.b);
    }
}

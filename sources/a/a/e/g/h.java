package a.a.e.g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: RxThreadFactory.java */
/* loaded from: classes.dex */
public final class h extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;

    /* renamed from: a  reason: collision with root package name */
    final String f205a;
    final int b;
    final boolean c;

    public h(String str) {
        this(str, 5, false);
    }

    public h(String str, int i) {
        this(str, i, false);
    }

    public h(String str, int i, boolean z) {
        this.f205a = str;
        this.b = i;
        this.c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f205a + '-' + incrementAndGet();
        Thread aVar = this.c ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.b);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f205a + "]";
    }

    /* compiled from: RxThreadFactory.java */
    /* loaded from: classes.dex */
    static final class a extends Thread {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }
}

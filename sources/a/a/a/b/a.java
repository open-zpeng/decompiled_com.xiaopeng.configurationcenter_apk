package a.a.a.b;

import a.a.l;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final l f138a = a.a.a.a.a.a(new Callable<l>() { // from class: a.a.a.b.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l call() throws Exception {
            return C0000a.f139a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* renamed from: a.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0000a {

        /* renamed from: a  reason: collision with root package name */
        static final l f139a = new b(new Handler(Looper.getMainLooper()));
    }

    public static l a() {
        return a.a.a.a.a.a(f138a);
    }

    public static l a(Looper looper) {
        Objects.requireNonNull(looper, "looper == null");
        return new b(new Handler(looper));
    }

    private a() {
        throw new AssertionError("No instances.");
    }
}

package a.a.e.h;

import a.a.k;
import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* loaded from: classes.dex */
public enum e {
    COMPLETE;

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: a  reason: collision with root package name */
        final Throwable f217a;

        b(Throwable th) {
            this.f217a = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f217a + "]";
        }

        public int hashCode() {
            return this.f217a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return a.a.e.b.b.a(this.f217a, ((b) obj).f217a);
            }
            return false;
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: a  reason: collision with root package name */
        final org.a.b f218a;

        c(org.a.b bVar) {
            this.f218a = bVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f218a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.b.b f216a;

        a(a.a.b.b bVar) {
            this.f216a = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f216a + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static Object subscription(org.a.b bVar) {
        return new c(bVar);
    }

    public static Object disposable(a.a.b.b bVar) {
        return new a(bVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f217a;
    }

    public static org.a.b getSubscription(Object obj) {
        return ((c) obj).f218a;
    }

    public static a.a.b.b getDisposable(Object obj) {
        return ((a) obj).f216a;
    }

    public static <T> boolean accept(Object obj, org.a.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.a();
            return true;
        } else if (obj instanceof b) {
            aVar.a(((b) obj).f217a);
            return true;
        } else {
            aVar.a((org.a.a<? super T>) obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, k<? super T> kVar) {
        if (obj == COMPLETE) {
            kVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            kVar.onError(((b) obj).f217a);
            return true;
        } else {
            kVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, org.a.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.a();
            return true;
        } else if (obj instanceof b) {
            aVar.a(((b) obj).f217a);
            return true;
        } else if (obj instanceof c) {
            aVar.a(((c) obj).f218a);
            return false;
        } else {
            aVar.a((org.a.a<? super T>) obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, k<? super T> kVar) {
        if (obj == COMPLETE) {
            kVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            kVar.onError(((b) obj).f217a);
            return true;
        } else if (obj instanceof a) {
            kVar.onSubscribe(((a) obj).f216a);
            return false;
        } else {
            kVar.onNext(obj);
            return false;
        }
    }
}

package a.a.c;
/* compiled from: OnErrorNotImplementedException.java */
/* loaded from: classes.dex */
public final class d extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public d(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public d(Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th);
    }
}

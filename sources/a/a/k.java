package a.a;
/* compiled from: Observer.java */
/* loaded from: classes.dex */
public interface k<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(a.a.b.b bVar);
}

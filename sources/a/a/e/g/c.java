package a.a.e.g;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: DisposeOnCancel.java */
/* loaded from: classes.dex */
final class c implements Future<Object> {

    /* renamed from: a  reason: collision with root package name */
    final a.a.b.b f195a;

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a.a.b.b bVar) {
        this.f195a = bVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f195a.dispose();
        return false;
    }
}

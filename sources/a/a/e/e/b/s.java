package a.a.e.e.b;

import a.a.l;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes.dex */
public final class s<T> extends a.a.e.e.b.a<T, T> {
    final long b;
    final TimeUnit c;
    final a.a.l d;
    final a.a.j<? extends T> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public interface d {
        void b(long j);
    }

    public s(a.a.g<T> gVar, long j, TimeUnit timeUnit, a.a.l lVar, a.a.j<? extends T> jVar) {
        super(gVar);
        this.b = j;
        this.c = timeUnit;
        this.d = lVar;
        this.e = jVar;
    }

    @Override // a.a.g
    protected void b(a.a.k<? super T> kVar) {
        if (this.e == null) {
            c cVar = new c(kVar, this.b, this.c, this.d.a());
            kVar.onSubscribe(cVar);
            cVar.a(0L);
            this.f159a.a(cVar);
            return;
        }
        b bVar = new b(kVar, this.b, this.c, this.d.a(), this.e);
        kVar.onSubscribe(bVar);
        bVar.a(0L);
        this.f159a.a(bVar);
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class c<T> extends AtomicLong implements a.a.b.b, d, a.a.k<T> {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f187a;
        final long b;
        final TimeUnit c;
        final l.b d;
        final a.a.e.a.g e = new a.a.e.a.g();
        final AtomicReference<a.a.b.b> f = new AtomicReference<>();

        c(a.a.k<? super T> kVar, long j, TimeUnit timeUnit, l.b bVar) {
            this.f187a = kVar;
            this.b = j;
            this.c = timeUnit;
            this.d = bVar;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            a.a.e.a.c.setOnce(this.f, bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.f187a.onNext(t);
                    a(j2);
                }
            }
        }

        void a(long j) {
            this.e.a(this.d.a(new e(j, this), this.b, this.c));
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f187a.onError(th);
                this.d.dispose();
                return;
            }
            a.a.h.a.a(th);
        }

        @Override // a.a.k
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f187a.onComplete();
                this.d.dispose();
            }
        }

        @Override // a.a.e.e.b.s.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                a.a.e.a.c.dispose(this.f);
                this.f187a.onError(new TimeoutException(a.a.e.h.d.a(this.b, this.c)));
                this.d.dispose();
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            a.a.e.a.c.dispose(this.f);
            this.d.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return a.a.e.a.c.isDisposed(this.f.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final d f188a;
        final long b;

        e(long j, d dVar) {
            this.b = j;
            this.f188a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f188a.b(this.b);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicReference<a.a.b.b> implements a.a.b.b, d, a.a.k<T> {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f186a;
        final long b;
        final TimeUnit c;
        final l.b d;
        final a.a.e.a.g e = new a.a.e.a.g();
        final AtomicLong f = new AtomicLong();
        final AtomicReference<a.a.b.b> g = new AtomicReference<>();
        a.a.j<? extends T> h;

        b(a.a.k<? super T> kVar, long j, TimeUnit timeUnit, l.b bVar, a.a.j<? extends T> jVar) {
            this.f186a = kVar;
            this.b = j;
            this.c = timeUnit;
            this.d = bVar;
            this.h = jVar;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            a.a.e.a.c.setOnce(this.g, bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            long j = this.f.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.f.compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.f186a.onNext(t);
                    a(j2);
                }
            }
        }

        void a(long j) {
            this.e.a(this.d.a(new e(j, this), this.b, this.c));
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f186a.onError(th);
                this.d.dispose();
                return;
            }
            a.a.h.a.a(th);
        }

        @Override // a.a.k
        public void onComplete() {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.f186a.onComplete();
                this.d.dispose();
            }
        }

        @Override // a.a.e.e.b.s.d
        public void b(long j) {
            if (this.f.compareAndSet(j, Long.MAX_VALUE)) {
                a.a.e.a.c.dispose(this.g);
                a.a.j<? extends T> jVar = this.h;
                this.h = null;
                jVar.a(new a(this.f186a, this));
                this.d.dispose();
            }
        }

        @Override // a.a.b.b
        public void dispose() {
            a.a.e.a.c.dispose(this.g);
            a.a.e.a.c.dispose(this);
            this.d.dispose();
        }

        @Override // a.a.b.b
        public boolean isDisposed() {
            return a.a.e.a.c.isDisposed(get());
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes.dex */
    static final class a<T> implements a.a.k<T> {

        /* renamed from: a  reason: collision with root package name */
        final a.a.k<? super T> f185a;
        final AtomicReference<a.a.b.b> b;

        a(a.a.k<? super T> kVar, AtomicReference<a.a.b.b> atomicReference) {
            this.f185a = kVar;
            this.b = atomicReference;
        }

        @Override // a.a.k
        public void onSubscribe(a.a.b.b bVar) {
            a.a.e.a.c.replace(this.b, bVar);
        }

        @Override // a.a.k
        public void onNext(T t) {
            this.f185a.onNext(t);
        }

        @Override // a.a.k
        public void onError(Throwable th) {
            this.f185a.onError(th);
        }

        @Override // a.a.k
        public void onComplete() {
            this.f185a.onComplete();
        }
    }
}

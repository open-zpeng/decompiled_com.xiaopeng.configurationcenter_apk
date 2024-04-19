package a.a.c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
/* compiled from: CompositeException.java */
/* loaded from: classes.dex */
public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f144a;
    private final String b;
    private Throwable c;

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f144a = unmodifiableList;
        this.b = unmodifiableList.size() + " exceptions occurred. ";
    }

    public List<Throwable> a() {
        return this.f144a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.c == null) {
            C0002a c0002a = new C0002a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f144a.iterator();
            C0002a c0002a2 = c0002a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : b(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        c0002a2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    c0002a2 = a(c0002a2);
                }
            }
            this.c = c0002a;
        }
        return this.c;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    private void a(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this).append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ").append(stackTraceElement).append('\n');
        }
        int i = 1;
        for (Throwable th : this.f144a) {
            sb.append("  ComposedException ").append(i).append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        bVar.a(sb.toString());
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str).append(th).append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ").append(stackTraceElement).append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        abstract void a(Object obj);

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f145a;

        c(PrintStream printStream) {
            this.f145a = printStream;
        }

        @Override // a.a.c.a.b
        void a(Object obj) {
            this.f145a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f146a;

        d(PrintWriter printWriter) {
            this.f146a = printWriter;
        }

        @Override // a.a.c.a.b
        void a(Object obj) {
            this.f146a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0002a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        C0002a() {
        }
    }

    private List<Throwable> b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    Throwable a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || th == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }
}

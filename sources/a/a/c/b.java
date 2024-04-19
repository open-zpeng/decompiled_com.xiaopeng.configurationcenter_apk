package a.a.c;
/* compiled from: Exceptions.java */
/* loaded from: classes.dex */
public final class b {
    public static RuntimeException a(Throwable th) {
        throw a.a.e.h.d.a(th);
    }

    public static void b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}

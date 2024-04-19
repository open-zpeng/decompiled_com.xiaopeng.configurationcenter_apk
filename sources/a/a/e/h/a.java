package a.a.e.h;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f214a;
    final Object[] b;
    Object[] c;
    int d;

    public a(int i) {
        this.f214a = i;
        Object[] objArr = new Object[i + 1];
        this.b = objArr;
        this.c = objArr;
    }

    public void a(T t) {
        int i = this.f214a;
        int i2 = this.d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.c[i] = objArr;
            this.c = objArr;
            i2 = 0;
        }
        this.c[i2] = t;
        this.d = i2 + 1;
    }

    public void b(T t) {
        this.b[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean a(a.a.k<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.b
            int r1 = r4.f214a
        L4:
            r2 = 0
            if (r0 == 0) goto L20
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = a.a.e.h.e.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.e.h.a.a(a.a.k):boolean");
    }
}

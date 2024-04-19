package com.b.a.i;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Progress.java */
/* loaded from: classes.dex */
public class d implements Serializable {
    private static final long serialVersionUID = 6353658567594109891L;

    /* renamed from: a  reason: collision with root package name */
    public String f1266a;
    public String b;
    public String c;
    public String d;
    public String e;
    public float f;
    public long h;
    public transient long i;
    public int j;
    private transient long m;
    private transient long n = SystemClock.elapsedRealtime();
    public long g = -1;
    public int k = 0;
    public long l = System.currentTimeMillis();
    private transient List<Long> o = new ArrayList();

    /* compiled from: Progress.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar);
    }

    public static d a(d dVar, long j, a aVar) {
        return a(dVar, j, dVar.g, aVar);
    }

    public static d a(d dVar, long j, long j2, a aVar) {
        dVar.g = j2;
        dVar.h += j;
        dVar.m += j;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if ((elapsedRealtime - dVar.n >= com.b.a.a.f1228a) || dVar.h == j2) {
            long j3 = elapsedRealtime - dVar.n;
            if (j3 == 0) {
                j3 = 1;
            }
            dVar.f = (((float) dVar.h) * 1.0f) / ((float) j2);
            dVar.i = dVar.a((dVar.m * 1000) / j3);
            dVar.n = elapsedRealtime;
            dVar.m = 0L;
            if (aVar != null) {
                aVar.a(dVar);
            }
        }
        return dVar;
    }

    private long a(long j) {
        this.o.add(Long.valueOf(j));
        if (this.o.size() > 10) {
            this.o.remove(0);
        }
        long j2 = 0;
        for (Long l : this.o) {
            j2 = ((float) j2) + ((float) l.longValue());
        }
        return j2 / this.o.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f1266a;
        String str2 = ((d) obj).f1266a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.f1266a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress{fraction=" + this.f + ", totalSize=" + this.g + ", currentSize=" + this.h + ", speed=" + this.i + ", status=" + this.j + ", priority=" + this.k + ", folder=" + this.c + ", filePath=" + this.d + ", fileName=" + this.e + ", tag=" + this.f1266a + ", url=" + this.b + '}';
    }
}

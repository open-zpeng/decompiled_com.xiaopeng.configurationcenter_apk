package com.a.a.b.a;

import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends r<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f997a = new q() { // from class: com.a.a.b.a.j.1
        @Override // com.a.a.q
        public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new j();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.a.a.r
    public synchronized void a(com.a.a.c.b bVar, Time time) throws IOException {
        bVar.b(time == null ? null : this.b.format((Date) time));
    }

    @Override // com.a.a.r
    /* renamed from: b */
    public synchronized Time a(com.a.a.c.a aVar) throws IOException {
        if (aVar.f() == com.a.a.c.c.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Time(this.b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new o(e);
        }
    }
}

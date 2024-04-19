package com.a.a.b.a;

import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class k extends r<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f998a = new q() { // from class: com.a.a.b.a.k.1
        @Override // com.a.a.q
        public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new k();
            }
            return null;
        }
    };
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.a.a.r
    public synchronized void a(com.a.a.c.b bVar, Date date) throws IOException {
        bVar.b(date == null ? null : this.b.format((java.util.Date) date));
    }

    @Override // com.a.a.r
    /* renamed from: b */
    public synchronized Date a(com.a.a.c.a aVar) throws IOException {
        if (aVar.f() == com.a.a.c.c.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Date(this.b.parse(aVar.h()).getTime());
        } catch (ParseException e) {
            throw new o(e);
        }
    }
}

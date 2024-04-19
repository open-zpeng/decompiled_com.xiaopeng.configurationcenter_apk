package com.a.a.b.a;

import com.a.a.o;
import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class d extends r<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f987a = new q() { // from class: com.a.a.b.a.d.1
        @Override // com.a.a.q
        public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new d();
            }
            return null;
        }
    };
    private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat d = a();

    private static DateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date a(String str) {
        try {
            try {
                try {
                } catch (ParseException unused) {
                    return this.d.parse(str);
                }
            } catch (ParseException e) {
                throw new o(str, e);
            }
        } catch (ParseException unused2) {
            return this.b.parse(str);
        }
        return this.c.parse(str);
    }

    @Override // com.a.a.r
    public synchronized void a(com.a.a.c.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.f();
        } else {
            bVar.b(this.b.format(date));
        }
    }

    @Override // com.a.a.r
    /* renamed from: b */
    public Date a(com.a.a.c.a aVar) throws IOException {
        if (aVar.f() == com.a.a.c.c.NULL) {
            aVar.j();
            return null;
        }
        return a(aVar.h());
    }
}

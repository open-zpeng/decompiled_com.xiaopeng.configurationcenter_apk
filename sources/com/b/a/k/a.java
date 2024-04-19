package com.b.a.k;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;
/* compiled from: HeaderParser.java */
/* loaded from: classes.dex */
public class a {
    public static <T> com.b.a.b.a<T> a(Headers headers, T t, com.b.a.b.b bVar, String str) {
        long currentTimeMillis;
        long j;
        if (bVar == com.b.a.b.b.DEFAULT) {
            long c = com.b.a.i.a.c(headers.get("Date"));
            currentTimeMillis = com.b.a.i.a.d(headers.get(HttpHeaders.EXPIRES));
            String b = com.b.a.i.a.b(headers.get(HttpHeaders.CACHE_CONTROL), headers.get("Pragma"));
            if (TextUtils.isEmpty(b) && currentTimeMillis <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(b)) {
                j = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(b, ",");
                j = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                        return null;
                    }
                    if (lowerCase.startsWith("max-age=")) {
                        try {
                            j = Long.parseLong(lowerCase.substring(8));
                            if (j <= 0) {
                                return null;
                            }
                        } catch (Exception e) {
                            d.a(e);
                        }
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (c <= 0) {
                c = currentTimeMillis2;
            }
            if (j > 0) {
                currentTimeMillis = c + (j * 1000);
            } else if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        com.b.a.i.a aVar = new com.b.a.i.a();
        for (String str2 : headers.names()) {
            aVar.a(str2, headers.get(str2));
        }
        com.b.a.b.a<T> aVar2 = new com.b.a.b.a<>();
        aVar2.a(str);
        aVar2.a((com.b.a.b.a<T>) t);
        aVar2.a(currentTimeMillis);
        aVar2.a(aVar);
        return aVar2;
    }

    public static <T> void a(com.b.a.j.a.d dVar, com.b.a.b.a<T> aVar, com.b.a.b.b bVar) {
        com.b.a.i.a b;
        if (aVar == null || bVar != com.b.a.b.b.DEFAULT || (b = aVar.b()) == null) {
            return;
        }
        String a2 = b.a(HttpHeaders.ETAG);
        if (a2 != null) {
            dVar.a("If-None-Match", a2);
        }
        long e = com.b.a.i.a.e(b.a(HttpHeaders.LAST_MODIFIED));
        if (e > 0) {
            dVar.a("If-Modified-Since", com.b.a.i.a.a(e));
        }
    }
}

package com.b.a.k;

import com.b.a.i.c;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
/* compiled from: HttpUtils.java */
/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: UnsupportedEncodingException -> 0x007a, TryCatch #0 {UnsupportedEncodingException -> 0x007a, blocks: (B:2:0x0000, B:6:0x0014, B:9:0x001b, B:11:0x0024, B:12:0x002c, B:14:0x0032, B:15:0x0042, B:17:0x0048, B:18:0x006c, B:10:0x0021), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L7a
            r0.<init>()     // Catch: java.io.UnsupportedEncodingException -> L7a
            r0.append(r7)     // Catch: java.io.UnsupportedEncodingException -> L7a
            r1 = 38
            int r1 = r7.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r2 = "&"
            if (r1 > 0) goto L21
            r1 = 63
            int r1 = r7.indexOf(r1)     // Catch: java.io.UnsupportedEncodingException -> L7a
            if (r1 <= 0) goto L1b
            goto L21
        L1b:
            java.lang.String r1 = "?"
            r0.append(r1)     // Catch: java.io.UnsupportedEncodingException -> L7a
            goto L24
        L21:
            r0.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L7a
        L24:
            java.util.Set r8 = r8.entrySet()     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.util.Iterator r8 = r8.iterator()     // Catch: java.io.UnsupportedEncodingException -> L7a
        L2c:
            boolean r1 = r8.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L7a
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r8.next()     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.Object r3 = r1.getValue()     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.util.List r3 = (java.util.List) r3     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.util.Iterator r3 = r3.iterator()     // Catch: java.io.UnsupportedEncodingException -> L7a
        L42:
            boolean r4 = r3.hasNext()     // Catch: java.io.UnsupportedEncodingException -> L7a
            if (r4 == 0) goto L2c
            java.lang.Object r4 = r3.next()     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r5)     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.Object r5 = r1.getKey()     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.StringBuilder r5 = r0.append(r5)     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r6 = "="
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L7a
            r4.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L7a
            goto L42
        L6c:
            int r8 = r0.length()     // Catch: java.io.UnsupportedEncodingException -> L7a
            int r8 = r8 + (-1)
            r0.deleteCharAt(r8)     // Catch: java.io.UnsupportedEncodingException -> L7a
            java.lang.String r7 = r0.toString()     // Catch: java.io.UnsupportedEncodingException -> L7a
            return r7
        L7a:
            r8 = move-exception
            com.b.a.k.d.a(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.k.b.a(java.lang.String, java.util.Map):java.lang.String");
    }

    public static Request.Builder a(Request.Builder builder, com.b.a.i.a aVar) {
        if (aVar.b.isEmpty()) {
            return builder;
        }
        Headers.Builder builder2 = new Headers.Builder();
        try {
            for (Map.Entry<String, String> entry : aVar.b.entrySet()) {
                builder2.add(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            d.a(e);
        }
        builder.headers(builder2.build());
        return builder;
    }

    public static RequestBody a(com.b.a.i.c cVar, boolean z) {
        if (cVar.e.isEmpty() && !z) {
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : cVar.d.keySet()) {
                for (String str2 : cVar.d.get(str)) {
                    builder.add(str, str2);
                }
            }
            return builder.build();
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!cVar.d.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : cVar.d.entrySet()) {
                for (String str3 : entry.getValue()) {
                    type.addFormDataPart(entry.getKey(), str3);
                }
            }
        }
        for (Map.Entry<String, List<c.a>> entry2 : cVar.e.entrySet()) {
            for (c.a aVar : entry2.getValue()) {
                type.addFormDataPart(entry2.getKey(), aVar.b, RequestBody.create(aVar.c, aVar.f1265a));
            }
        }
        return type.build();
    }

    public static MediaType a(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace("#", ""));
        if (contentTypeFor == null) {
            return com.b.a.i.c.c;
        }
        return MediaType.parse(contentTypeFor);
    }

    public static <T> T a(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static void a(Runnable runnable) {
        com.b.a.a.a().c().post(runnable);
    }
}

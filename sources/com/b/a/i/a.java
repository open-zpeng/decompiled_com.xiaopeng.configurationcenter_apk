package com.b.a.i;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f1261a = TimeZone.getTimeZone("GMT");
    private static String c = null;
    private static String d = null;
    private static final long serialVersionUID = 8458647755751403873L;
    public LinkedHashMap<String, String> b;

    public static String b(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    private void d() {
        this.b = new LinkedHashMap<>();
    }

    public a() {
        d();
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    public void a(a aVar) {
        LinkedHashMap<String, String> linkedHashMap;
        if (aVar == null || (linkedHashMap = aVar.b) == null || linkedHashMap.isEmpty()) {
            return;
        }
        this.b.putAll(aVar.b);
    }

    public String a(String str) {
        return this.b.get(str);
    }

    public String b(String str) {
        return this.b.remove(str);
    }

    public void a() {
        this.b.clear();
    }

    public static long c(String str) {
        try {
            return f(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long d(String str) {
        try {
            return f(str);
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public static long e(String str) {
        try {
            return f(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(c)) {
            Locale locale = Locale.getDefault();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder(language);
            if (!TextUtils.isEmpty(country)) {
                sb.append('-').append(country).append(',').append(language).append(";q=0.8");
            }
            String sb2 = sb.toString();
            c = sb2;
            return sb2;
        }
        return c;
    }

    public static String c() {
        if (TextUtils.isEmpty(d)) {
            String str = null;
            try {
                str = com.b.a.a.a().b().getString(((Integer) Class.forName("com.android.internal.R$string").getDeclaredField("web_user_agent").get(null)).intValue());
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(str)) {
                str = "okhttp-okgo/jeasonlzy";
            }
            Locale locale = Locale.getDefault();
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = Build.VERSION.RELEASE;
            if (str2.length() > 0) {
                stringBuffer.append(str2);
            } else {
                stringBuffer.append("1.0");
            }
            stringBuffer.append("; ");
            String language = locale.getLanguage();
            if (language != null) {
                stringBuffer.append(language.toLowerCase(locale));
                String country = locale.getCountry();
                if (!TextUtils.isEmpty(country)) {
                    stringBuffer.append("-");
                    stringBuffer.append(country.toLowerCase(locale));
                }
            } else {
                stringBuffer.append("en");
            }
            if ("REL".equals(Build.VERSION.CODENAME)) {
                String str3 = Build.MODEL;
                if (str3.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str3);
                }
            }
            String str4 = Build.ID;
            if (str4.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str4);
            }
            String format = String.format(str, stringBuffer, "Mobile ");
            d = format;
            return format;
        }
        return d;
    }

    public static long f(String str) throws ParseException {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(f1261a);
        return simpleDateFormat.parse(str).getTime();
    }

    public static String a(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(f1261a);
        return simpleDateFormat.format(date);
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + this.b + '}';
    }
}

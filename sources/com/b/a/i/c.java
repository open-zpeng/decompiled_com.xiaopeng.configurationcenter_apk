package com.b.a.i;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
/* compiled from: HttpParams.java */
/* loaded from: classes.dex */
public class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f1264a = MediaType.parse("text/plain;charset=utf-8");
    public static final MediaType b = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType c = MediaType.parse(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    private static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<String>> d;
    public LinkedHashMap<String, List<a>> e;

    public c() {
        b();
    }

    private void b() {
        this.d = new LinkedHashMap<>();
        this.e = new LinkedHashMap<>();
    }

    public void a(c cVar) {
        if (cVar != null) {
            LinkedHashMap<String, List<String>> linkedHashMap = cVar.d;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.d.putAll(cVar.d);
            }
            LinkedHashMap<String, List<a>> linkedHashMap2 = cVar.e;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.e.putAll(cVar.e);
        }
    }

    public void a(Map<String, String> map, boolean... zArr) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue(), zArr);
        }
    }

    public void a(String str, String str2, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            a(str, str2, zArr[0]);
        } else {
            a(str, str2, true);
        }
    }

    public void a(String str, int i, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            a(str, String.valueOf(i), zArr[0]);
        } else {
            a(str, String.valueOf(i), true);
        }
    }

    public void a(String str, float f, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            a(str, String.valueOf(f), zArr[0]);
        } else {
            a(str, String.valueOf(f), true);
        }
    }

    public void a(String str, boolean z, boolean... zArr) {
        if (zArr != null && zArr.length > 0) {
            a(str, String.valueOf(z), zArr[0]);
        } else {
            a(str, String.valueOf(z), true);
        }
    }

    private void a(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return;
        }
        List<String> list = this.d.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.d.put(str, list);
        }
        if (z) {
            list.clear();
        }
        list.add(str2);
    }

    public void a(String str, File file) {
        a(str, file, file.getName());
    }

    public void a(String str, File file, String str2) {
        a(str, file, str2, com.b.a.k.b.a(str2));
    }

    public void a(String str, File file, String str2, MediaType mediaType) {
        if (str != null) {
            List<a> list = this.e.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.e.put(str, list);
            }
            list.add(new a(file, str2, mediaType));
        }
    }

    public void a(String str) {
        this.d.remove(str);
    }

    public void b(String str) {
        this.e.remove(str);
    }

    public void c(String str) {
        a(str);
        b(str);
    }

    public void a() {
        this.d.clear();
        this.e.clear();
    }

    /* compiled from: HttpParams.java */
    /* loaded from: classes.dex */
    public static class a implements Serializable {
        private static final long serialVersionUID = -2356139899636767776L;

        /* renamed from: a  reason: collision with root package name */
        public File f1265a;
        public String b;
        public transient MediaType c;
        public long d;

        public a(File file, String str, MediaType mediaType) {
            this.f1265a = file;
            this.b = str;
            this.c = mediaType;
            this.d = file.length();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.c.toString());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.c = MediaType.parse((String) objectInputStream.readObject());
        }

        public String toString() {
            return "FileWrapper{file=" + this.f1265a + ", fileName=" + this.b + ", contentType=" + this.c + ", fileSize=" + this.d + "}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.d.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        for (Map.Entry<String, List<a>> entry2 : this.e.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey()).append("=").append(entry2.getValue());
        }
        return sb.toString();
    }
}

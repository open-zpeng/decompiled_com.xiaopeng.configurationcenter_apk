package com.b.a.e;

import java.util.ArrayList;
import java.util.List;
/* compiled from: TableEntity.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f1257a;
    private List<c> b = new ArrayList();

    public f(String str) {
        this.f1257a = str;
    }

    public f a(c cVar) {
        this.b.add(cVar);
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.f1257a).append('(');
        for (c cVar : this.b) {
            if (cVar.c != null) {
                sb.append("PRIMARY KEY (");
                for (String str : cVar.c) {
                    sb.append(str).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            } else {
                sb.append(cVar.f1255a).append(" ").append(cVar.b);
                if (cVar.e) {
                    sb.append(" NOT NULL");
                }
                if (cVar.d) {
                    sb.append(" PRIMARY KEY");
                }
                if (cVar.f) {
                    sb.append(" AUTOINCREMENT");
                }
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int b() {
        return this.b.size();
    }

    public int a(String str) {
        int b = b();
        for (int i = 0; i < b; i++) {
            if (this.b.get(i).f1255a.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}

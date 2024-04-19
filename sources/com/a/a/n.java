package com.a.a;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class n extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f1055a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public n(Boolean bool) {
        a(bool);
    }

    public n(Number number) {
        a(number);
    }

    public n(String str) {
        a(str);
    }

    private static boolean a(n nVar) {
        Object obj = nVar.b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f1055a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.a.a.s
    public Number a() {
        Object obj = this.b;
        return obj instanceof String ? new com.a.a.b.f((String) this.b) : (Number) obj;
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            com.a.a.b.a.a((obj instanceof Number) || b(obj));
        }
        this.b = obj;
    }

    @Override // com.a.a.s
    public String b() {
        return i() ? a().toString() : g() ? h().toString() : (String) this.b;
    }

    @Override // com.a.a.s
    public double c() {
        return i() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.a.a.s
    public long d() {
        return i() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.a.a.s
    public int e() {
        return i() ? a().intValue() : Integer.parseInt(b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.b == null) {
            return nVar.b == null;
        } else if (a(this) && a(nVar)) {
            return a().longValue() == nVar.a().longValue();
        } else {
            Object obj2 = this.b;
            if ((obj2 instanceof Number) && (nVar.b instanceof Number)) {
                double doubleValue = a().doubleValue();
                double doubleValue2 = nVar.a().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(nVar.b);
        }
    }

    @Override // com.a.a.s
    public boolean f() {
        return g() ? h().booleanValue() : Boolean.parseBoolean(b());
    }

    public boolean g() {
        return this.b instanceof Boolean;
    }

    @Override // com.a.a.s
    Boolean h() {
        return (Boolean) this.b;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.b == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean i() {
        return this.b instanceof Number;
    }

    public boolean j() {
        return this.b instanceof String;
    }
}

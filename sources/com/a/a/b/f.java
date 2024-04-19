package com.a.a.b;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class f extends Number {

    /* renamed from: a  reason: collision with root package name */
    private final String f1027a;

    public f(String str) {
        this.f1027a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f1027a);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f1027a);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f1027a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f1027a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f1027a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f1027a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f1027a).longValue();
        }
    }

    public String toString() {
        return this.f1027a;
    }
}

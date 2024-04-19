package com.ut.mini.internal;
/* loaded from: classes.dex */
public class CustomDNS {

    /* renamed from: a  reason: collision with root package name */
    private IDnsResolver f1306a;

    /* loaded from: classes.dex */
    public interface IDnsResolver {
        String[] resolveUrl(String str);
    }

    public static CustomDNS instance() {
        return a.f1307a;
    }

    private CustomDNS() {
        this.f1306a = null;
    }

    public void setDnsResolver(IDnsResolver iDnsResolver) {
        this.f1306a = iDnsResolver;
    }

    public String[] resolveUrl(String str) {
        IDnsResolver iDnsResolver = this.f1306a;
        if (iDnsResolver != null) {
            return iDnsResolver.resolveUrl(str);
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final CustomDNS f1307a = new CustomDNS();
    }
}

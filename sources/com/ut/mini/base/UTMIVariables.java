package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;
/* loaded from: classes.dex */
public class UTMIVariables {

    /* renamed from: a  reason: collision with root package name */
    private static UTMIVariables f1302a = new UTMIVariables();
    private String ar = null;
    private String ao = null;
    private String as = null;

    /* renamed from: a  reason: collision with other field name */
    private UTMI1010_2001Event f131a = null;
    private boolean S = false;

    public synchronized void setToAliyunOSPlatform() {
        this.S = true;
    }

    public synchronized boolean isAliyunOSPlatform() {
        return this.S;
    }

    public synchronized void setUTMI1010_2001EventInstance(UTMI1010_2001Event uTMI1010_2001Event) {
        this.f131a = uTMI1010_2001Event;
    }

    public synchronized UTMI1010_2001Event getUTMI1010_2001EventInstance() {
        return this.f131a;
    }

    public static UTMIVariables getInstance() {
        return f1302a;
    }

    public String getH5Url() {
        return this.as;
    }

    public void setH5Url(String str) {
        this.as = str;
    }

    public String getRefPage() {
        return this.ao;
    }

    public void setRefPage(String str) {
        this.ao = str;
    }

    public String getH5RefPage() {
        return this.ar;
    }

    public void setH5RefPage(String str) {
        this.ar = str;
    }
}

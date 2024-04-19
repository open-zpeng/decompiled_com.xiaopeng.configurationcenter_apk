package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.a.d.i;
import com.alibaba.mtl.a.d.q;
import com.alibaba.mtl.a.e.a;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UTTracker {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f1301a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private String g;
    private String aq = null;
    private Map<String, String> D = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.aq = str;
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.D.put(str, str2);
        } else {
            i.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    public synchronized String getGlobalProperty(String str) {
        if (str != null) {
            return this.D.get(str);
        }
        return null;
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.D.containsKey(str)) {
                this.D.remove(str);
            }
        }
    }

    private static String d(String str) {
        return (str == null || "".equals(str)) ? str : f1301a.matcher(str).replaceAll("");
    }

    private static String b(String str) {
        return d(str);
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = map.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        hashMap.put(next, b(map.get(next)));
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.D);
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(a.APPKEY.toString(), this.g);
            }
            Map<String, String> g = g((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.aq)) {
                g.put(UTFields.TRACK_ID, this.aq);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g);
            d(g);
            m69g(g);
            h(g);
            com.alibaba.mtl.a.a.a(g.remove(a.PAGE.toString()), g.remove(a.EVENTID.toString()), g.remove(a.ARG1.toString()), g.remove(a.ARG2.toString()), g.remove(a.ARG3.toString()), g);
        }
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(a.IMEI.toString())) {
                map.remove(a.IMEI.toString());
            }
            if (map.containsKey(a.IMSI.toString())) {
                map.remove(a.IMSI.toString());
            }
            if (map.containsKey(a.CARRIER.toString())) {
                map.remove(a.CARRIER.toString());
            }
            if (map.containsKey(a.ACCESS.toString())) {
                map.remove(a.ACCESS.toString());
            }
            if (map.containsKey(a.ACCESS_SUBTYPE.toString())) {
                map.remove(a.ACCESS_SUBTYPE.toString());
            }
            if (map.containsKey(a.CHANNEL.toString())) {
                map.remove(a.CHANNEL.toString());
            }
            if (map.containsKey(a.LL_USERNICK.toString())) {
                map.remove(a.LL_USERNICK.toString());
            }
            if (map.containsKey(a.USERNICK.toString())) {
                map.remove(a.USERNICK.toString());
            }
            if (map.containsKey(a.LL_USERID.toString())) {
                map.remove(a.LL_USERID.toString());
            }
            if (map.containsKey(a.USERID.toString())) {
                map.remove(a.USERID.toString());
            }
            if (map.containsKey(a.SDKVERSION.toString())) {
                map.remove(a.SDKVERSION.toString());
            }
            if (map.containsKey(a.START_SESSION_TIMESTAMP.toString())) {
                map.remove(a.START_SESSION_TIMESTAMP.toString());
            }
            if (map.containsKey(a.UTDID.toString())) {
                map.remove(a.UTDID.toString());
            }
            if (map.containsKey(a.SDKTYPE.toString())) {
                map.remove(a.SDKTYPE.toString());
            }
            if (map.containsKey(a.RESERVE2.toString())) {
                map.remove(a.RESERVE2.toString());
            }
            if (map.containsKey(a.RESERVE3.toString())) {
                map.remove(a.RESERVE3.toString());
            }
            if (map.containsKey(a.RESERVE4.toString())) {
                map.remove(a.RESERVE4.toString());
            }
            if (map.containsKey(a.RESERVE5.toString())) {
                map.remove(a.RESERVE5.toString());
            }
            if (map.containsKey(a.RESERVES.toString())) {
                map.remove(a.RESERVES.toString());
            }
            if (map.containsKey(a.RECORD_TIMESTAMP.toString())) {
                map.remove(a.RECORD_TIMESTAMP.toString());
            }
        }
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                map.remove(UTFields.OS);
                map.put(a.OS.toString(), map.get(UTFields.OS));
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                map.remove(UTFields.OS_VERSION);
                map.put(a.OSVERSION.toString(), map.get(UTFields.OS_VERSION));
            }
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private static void m69g(Map<String, String> map) {
        map.put(a.SDKTYPE.toString(), "mini");
    }

    private static void h(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(a.RESERVES.toString(), q.b(hashMap));
        }
        if (map.containsKey(a.PAGE.toString())) {
            return;
        }
        map.put(a.PAGE.toString(), "UT");
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(String str) {
        this.g = str;
    }
}

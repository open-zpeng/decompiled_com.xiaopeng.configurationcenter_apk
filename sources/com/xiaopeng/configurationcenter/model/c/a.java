package com.xiaopeng.configurationcenter.model.c;

import android.car.Car;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.b.a.i.b;
import com.xiaopeng.configurationcenter.App;
import com.xiaopeng.configurationcenter.model.data.c;
import com.xiaopeng.configurationcenter.model.data.f;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IHttp;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.server.ServerBean;
import com.xiaopeng.lib.security.SecurityCommon;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.MD5Utils;
import com.xiaopeng.lib.utils.NetUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: HttpClient.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1339a = CommonConfig.HTTP_HOST + "/config/v2/config";
    private static String c = App.a().getPackageName();
    private static String d = Build.VERSION.RELEASE;
    private static String e = Build.BRAND;
    private static String f = Build.MODEL;
    private static String g = BuildInfoUtils.getSystemVersion().substring(1);
    private static int h = 0;
    private IHttp b;

    /* compiled from: HttpClient.java */
    /* renamed from: com.xiaopeng.configurationcenter.model.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0094a {
        void a(String str, int i, String str2);

        void a(String str, List<f> list);
    }

    private static String c() {
        return "dd004c4f0e954d529ec778e69f674dfe";
    }

    public void a(IHttp iHttp) {
        this.b = iHttp;
        iHttp.config().connectTimeout(10000).readTimeout(15000).writeTimeout(15000).dnsTimeout(5000).retryCount(1).applicationContext(App.a()).enableTrafficStats().apply();
    }

    public void a(c cVar, List<String> list, final InterfaceC0094a interfaceC0094a) {
        final String str = cVar.f1345a;
        HashMap hashMap = new HashMap(1);
        try {
            final String str2 = Car.isExportVersion() ? "https://xmart-eu.xiaopeng.com/config/v2/config" : f1339a;
            IRequest post = this.b.post(str2);
            String a2 = a(list);
            HashMap hashMap2 = new HashMap(6);
            hashMap2.put("XP-Appid", cVar.f1345a);
            hashMap2.put(BizConstants.HEADER_CLIENT_TYPE, "3");
            hashMap2.put(BizConstants.HEADER_CLIENT, a(cVar));
            hashMap2.put(BizConstants.HEADER_NONCE, b());
            hashMap2.put("XP-OTA-DATA-WITH-VERSION", "1");
            hashMap2.put(BizConstants.HEADER_SIGNATURE, a("POST", hashMap2, hashMap, a2));
            for (Map.Entry entry : hashMap2.entrySet()) {
                post.headers((String) entry.getKey(), (String) entry.getValue());
            }
            Log.i("HttpClient", "query: appInfo = [" + cVar.f1345a + "], versions = [" + list + "], body = [" + a2 + "]], url = [" + str2 + "]");
            post.uploadJson(a2);
            post.execute(new Callback() { // from class: com.xiaopeng.configurationcenter.model.c.a.1
                @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
                public void onSuccess(IResponse iResponse) {
                    ServerBean a3 = a.this.a(iResponse);
                    Log.i("HttpClient", "onSuccess: URL=" + str2 + "; bean=" + a3);
                    if (iResponse.code() != 200 || a3 == null || a3.getCode() != 200) {
                        if (a3 != null) {
                            interfaceC0094a.a(str, a3.getCode(), a3.getMsg());
                            return;
                        } else {
                            interfaceC0094a.a(str, iResponse.code(), iResponse.message());
                            return;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = new JSONArray(a3.getData());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string = jSONObject.getString("configName");
                            if (jSONObject.has("value")) {
                                String string2 = jSONObject.getString("value");
                                String string3 = jSONObject.has("version") ? jSONObject.getString("version") : "";
                                f a4 = f.a(str, string);
                                a4.d = string2;
                                a4.c = string3;
                                arrayList.add(a4);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    interfaceC0094a.a(str, arrayList);
                }

                @Override // com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.Callback
                public void onFailure(IResponse iResponse) {
                    Log.d("HttpClient", "onFailure: iResponse=" + iResponse.message());
                    interfaceC0094a.a(str, iResponse.code(), iResponse.message());
                }
            });
        } catch (Exception e2) {
            Log.d("HttpClient", "Exception: e=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private String a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            try {
                jSONObject.put("configVersions", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e("HttpClient", "buildConfigVersionsJson exception:" + e2.getMessage());
            }
        }
        return "{}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServerBean a(IResponse iResponse) {
        try {
            JSONObject jSONObject = new JSONObject(iResponse.body());
            ServerBean serverBean = new ServerBean();
            serverBean.setCode(jSONObject.getInt("code"));
            if (jSONObject.has("data")) {
                serverBean.setData(jSONObject.getString("data"));
            }
            if (jSONObject.has("msg")) {
                serverBean.setMsg(jSONObject.getString("msg"));
                return serverBean;
            }
            return serverBean;
        } catch (Exception e2) {
            LogUtils.w("HttpClient", "Failed to parser the response data. Exception:" + e2.getMessage());
            return null;
        }
    }

    private static String a(c cVar) {
        return String.format(Locale.getDefault(), "di=%s;ve=%s;pn=%s;br=%s;mo=%s;sv=%s;nt=%s;t=%d;st=%d", BuildInfoUtils.getHardwareId(), cVar.b, c, e, f, g, a(), Long.valueOf(System.currentTimeMillis()), 3);
    }

    private static String a() {
        int networkType = NetUtils.getNetworkType(App.a());
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 10 ? "NONE" : "WIFI" : "4G" : "3G" : "2G";
    }

    private static String b() {
        int i = h + 1;
        h = i;
        if (i == 10000) {
            h = 0;
        }
        return String.format(Locale.getDefault(), "%d%04d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(h));
    }

    private static String a(byte[] bArr) {
        return SecurityCommon.parseByte2HexStr(bArr);
    }

    private static String a(String str, Map<String, String> map, Map<String, String> map2, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            byte[] bytes = c().getBytes(XmartV1Constants.UTF8_ENCODING);
            mac.init(new SecretKeySpec(bytes, 0, bytes.length, "HmacSHA256"));
            return a(mac.doFinal((str + '&' + a(map2, map) + '&' + a(str, str2)).getBytes(XmartV1Constants.UTF8_ENCODING))).toLowerCase();
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            LogUtils.e("HttpClient", "getSignature exception:" + e2.getMessage());
            return null;
        }
    }

    private static String a(Map<String, String> map, Map<String, String> map2) {
        ArrayList arrayList = new ArrayList(map2.keySet());
        arrayList.addAll(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(a(map, map2, (String) arrayList.get(i)));
            if (i < arrayList.size() - 1) {
                sb.append('&');
            }
        }
        return sb.toString();
    }

    private static String a(Map<String, String> map, Map<String, String> map2, String str) {
        if (str.startsWith(BizConstants.HEADER_PREFIX)) {
            return str.toUpperCase() + "=" + map2.get(str);
        }
        return str + "=" + map.get(str);
    }

    private static String a(String str, String str2) {
        if (b.POST.toString().equals(str) || b.PUT.toString().equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "{}";
            }
            return MD5Utils.getMD5(str2);
        }
        return "";
    }
}

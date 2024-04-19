package com.xiaopeng.configurationcenter;

import android.car.Car;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IpcRouterService.java */
/* loaded from: classes.dex */
public class b implements IServicePublisher {
    public void a(int i, String str) {
        boolean z;
        Log.i("CarAccountIpcRouterService", "onReceiverData: id=" + i + "; bundle=" + str);
        String a2 = a();
        try {
            z = Car.isExportVersion();
        } catch (Exception e) {
            Log.i("CarAccountIpcRouterService", "get Car.isExportVersion() error = " + e);
            z = false;
        }
        if ((a2.equals("Q1") || a2.equals("Q8") || a2.equals("Q7")) && !z) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
                a(i, bundle, jSONObject.optString("senderPackageName"));
            } catch (JSONException e2) {
                Log.i("CarAccountIpcRouterService", "onReceiverData error = " + e2);
            }
        }
    }

    private static void a(int i, Bundle bundle, String str) {
        Log.i("CarAccountIpcRouterService", "onReceiverData: id=" + i + ";senderPackageName=" + str);
        if (TextUtils.isEmpty(str) || i <= 0) {
            Log.e("CarAccountIpcRouterService", "onReceiverData: fatal from sender. ");
            return;
        }
        IIpcService.IpcMessageEvent ipcMessageEvent = new IIpcService.IpcMessageEvent();
        ipcMessageEvent.setMsgID(i);
        ipcMessageEvent.setPayloadData(bundle);
        ipcMessageEvent.setSenderPackageName(str);
        if (EventBus.getDefault().hasSubscriberForEvent(IIpcService.IpcMessageEvent.class)) {
            EventBus.getDefault().post(ipcMessageEvent);
            return;
        }
        Log.w("CarAccountIpcRouterService", "onReceiverData: IIpcService.IpcMessageEvent has not subscriber.");
        EventBus.getDefault().postSticky(ipcMessageEvent);
    }

    public static String a() {
        try {
            return Car.getXpCduType();
        } catch (Exception unused) {
            return "Q1";
        }
    }
}

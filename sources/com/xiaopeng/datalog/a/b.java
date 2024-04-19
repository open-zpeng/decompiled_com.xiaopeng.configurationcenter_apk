package com.xiaopeng.datalog.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* loaded from: classes.dex */
public class b implements Handler.Callback, ICounter {

    /* renamed from: a  reason: collision with root package name */
    private final String f1354a;
    private final long b;
    private final Map<String, AtomicInteger> c;
    private boolean d;
    private AtomicLong e;
    private Handler f;
    private final SharedPreferences g;
    private final SharedPreferences.Editor h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, long j) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("name can't be empty!");
        }
        this.f1354a = str;
        this.b = j;
        this.c = new HashMap();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.g = defaultSharedPreferences;
        this.h = defaultSharedPreferences.edit();
        this.e = new AtomicLong(defaultSharedPreferences.getLong(a("time"), System.currentTimeMillis()));
        this.f = new Handler(ThreadUtils.getLooper(0), this);
        a();
        a(false);
    }

    private void a() {
        Map<String, ?> all = this.g.getAll();
        LogUtils.d("CounterImpl", "initValuesFromPref prefMap:" + all);
        for (String str : all.keySet()) {
            String b = b(str);
            if (!TextUtils.isEmpty(b) && !b.equals("time")) {
                Object obj = all.get(str);
                if (obj instanceof Integer) {
                    LogUtils.d("CounterImpl", "initValuesFromPref key:" + b + " value:" + obj);
                    this.c.put(b, new AtomicInteger(((Integer) obj).intValue()));
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.d) {
                LogUtils.d("CounterImpl", "mEditor.apply()");
            }
            this.h.apply();
        }
        return true;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.d = z;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.c.get(str);
        String a2 = a(str);
        if (atomicInteger == null) {
            try {
                i2 = this.g.getInt(a2, 0);
            } catch (ClassCastException e) {
                LogUtils.w("CounterImpl", "mPreferences.getInt(" + a2 + ") error!", e);
                i2 = 0;
            }
            if (this.d) {
                LogUtils.v("CounterImpl", "count " + this.f1354a + ", load key:" + a2 + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.c.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.h.putInt(a2, i3);
        if (this.d) {
            LogUtils.v("CounterImpl", "count " + this.f1354a + " " + str + ":" + i3 + ", cache is:" + this.c);
        }
        if (!this.f.hasMessages(1)) {
            this.f.sendEmptyMessageDelayed(1, 10000L);
        }
        a(i3 == Integer.MAX_VALUE);
        return i3;
    }

    private String a(String str) {
        return this.f1354a + "_" + str;
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f1354a + "_";
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    private void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        final long j = this.e.get();
        long j2 = this.b;
        if (j / j2 < currentTimeMillis / j2 || z) {
            final HashMap hashMap = new HashMap();
            for (String str : this.c.keySet()) {
                AtomicInteger atomicInteger = this.c.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.h.putInt(a(str), 0);
            }
            ThreadUtils.post(2, new Runnable() { // from class: com.xiaopeng.datalog.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.i("CounterImpl", "[" + b.this.f1354a + " counter] send count event, name:" + b.this.f1354a + " values:" + hashMap);
                    IDataLog iDataLog = (IDataLog) Module.get(com.xiaopeng.datalog.a.class).get(IDataLog.class);
                    IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(b.this.f1354a);
                    for (String str2 : hashMap.keySet()) {
                        event.setProperty(str2, (Number) hashMap.get(str2));
                    }
                    event.setProperty("time", Long.valueOf(j));
                    IMoleEvent build = event.build();
                    LogUtils.d("CounterImpl", "start sendStatData:" + build.toJson());
                    iDataLog.sendStatData(build);
                }
            });
            if (!this.f.hasMessages(1)) {
                this.f.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.e.set(currentTimeMillis);
        this.h.putLong(a("time"), currentTimeMillis);
    }
}

package com.xiaopeng.datalog.a;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
/* compiled from: CounterFactory.java */
/* loaded from: classes.dex */
public class a implements ICounterFactory {
    private a() {
    }

    /* compiled from: CounterFactory.java */
    /* renamed from: com.xiaopeng.datalog.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0095a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f1353a = new a();
    }

    public static a a() {
        return C0095a.f1353a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createHourlyCounter(Context context, String str) {
        return new b(context, str, 3600000L);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory
    public ICounter createDailyCounter(Context context, String str) {
        return new b(context, str, 86400000L);
    }
}

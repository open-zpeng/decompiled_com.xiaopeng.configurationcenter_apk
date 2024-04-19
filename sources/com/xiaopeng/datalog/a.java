package com.xiaopeng.datalog;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
/* compiled from: DataLogModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile IDataLog f1352a;
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == IDataLog.class) {
            if (this.f1352a == null) {
                synchronized (this) {
                    if (this.f1352a == null) {
                        this.f1352a = new b(this.b);
                    }
                }
            }
            return this.f1352a;
        }
        return null;
    }
}

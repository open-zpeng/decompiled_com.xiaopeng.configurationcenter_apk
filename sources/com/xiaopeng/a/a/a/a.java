package com.xiaopeng.a.a.a;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateModuleEntry.java */
/* loaded from: classes.dex */
public class a implements IModuleEntry {

    /* renamed from: a  reason: collision with root package name */
    private volatile ISystemDelegate f1312a;
    private Context b;

    public a(Context context) {
        this.b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class cls) {
        if (cls == ISystemDelegate.class) {
            if (this.f1312a == null) {
                synchronized (this) {
                    if (this.f1312a == null) {
                        this.f1312a = new b(this.b);
                    }
                }
            }
            return this.f1312a;
        }
        return null;
    }
}

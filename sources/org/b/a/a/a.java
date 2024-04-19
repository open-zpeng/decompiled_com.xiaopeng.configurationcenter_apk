package org.b.a.a;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final int f1397a;
    final byte[] b = new byte[IRadioController.TEF663x_PCHANNEL];
    int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        if (i < 1 || i > 256) {
            throw new IllegalArgumentException();
        }
        this.f1397a = i;
    }
}

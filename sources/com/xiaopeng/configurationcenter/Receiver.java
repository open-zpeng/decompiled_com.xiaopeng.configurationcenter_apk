package com.xiaopeng.configurationcenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
/* loaded from: classes.dex */
public class Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtils.v("Receiver", "onReceive action:" + action);
        if (action != null) {
            Intent intent2 = new Intent(context, ConfigurationService.class);
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1173265085:
                    if (action.equals(CommonConfig.ACTION_BROADCAST_PM_STATUS_CHANGE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1172645946:
                    if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 798292259:
                    if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    Bundle extras = intent.getExtras();
                    if (extras == null || extras.getInt(CommonConfig.KEY_VALUE_STATUS, 4) != 0) {
                        return;
                    }
                    intent2.setAction("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_PM_NORMAL");
                    context.startService(intent2);
                    return;
                case 1:
                    intent2.setAction("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_CONNECTIVITY_CHANGE");
                    context.startService(intent2);
                    return;
                case 2:
                    intent2.setAction("com.xiaopeng.configurationcenter.ConfigurationService.ACTION_BOOT_COMPLETED");
                    context.startService(intent2);
                    return;
                default:
                    return;
            }
        }
    }
}

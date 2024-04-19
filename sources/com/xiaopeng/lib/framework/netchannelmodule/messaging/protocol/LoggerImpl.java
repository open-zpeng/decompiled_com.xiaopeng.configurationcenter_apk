package com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol;

import com.xiaopeng.lib.framework.netchannelmodule.messaging.profile.AbstractChannelProfile;
import com.xiaopeng.lib.utils.LogUtils;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import org.eclipse.paho.a.a.b.b;
import org.eclipse.paho.a.a.n;
/* loaded from: classes.dex */
public class LoggerImpl implements b {
    private Set<String> mAcceptMsgId;
    private String mLogTag;

    public void dumpTrace() {
    }

    public String formatMessage(String str, Object[] objArr) {
        return str;
    }

    @Override // org.eclipse.paho.a.a.b.b
    public boolean isLoggable(int i) {
        return true;
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void setResourceName(String str) {
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void initialise(ResourceBundle resourceBundle, String str, String str2) {
        AbstractChannelProfile currentChannelProfile = MqttChannel.getCurrentChannelProfile();
        this.mAcceptMsgId = currentChannelProfile.getAcceptedLogList();
        this.mLogTag = currentChannelProfile.logTag();
    }

    public void severe(String str, String str2, String str3) {
        log(1, str, str2, str3, null, null);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void severe(String str, String str2, String str3, Object[] objArr) {
        log(1, str, str2, str3, objArr, null);
    }

    public void severe(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(1, str, str2, str3, objArr, th);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void warning(String str, String str2, String str3) {
        log(2, str, str2, str3, null, null);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void warning(String str, String str2, String str3, Object[] objArr) {
        log(2, str, str2, str3, objArr, null);
    }

    public void warning(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(2, str, str2, str3, objArr, th);
    }

    public void info(String str, String str2, String str3) {
        log(3, str, str2, str3, null, null);
    }

    public void info(String str, String str2, String str3, Object[] objArr) {
        log(3, str, str2, str3, objArr, null);
    }

    public void info(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(3, str, str2, str3, objArr, th);
    }

    public void config(String str, String str2, String str3) {
        log(4, str, str2, str3, null, null);
    }

    public void config(String str, String str2, String str3, Object[] objArr) {
        log(4, str, str2, str3, objArr, null);
    }

    public void config(String str, String str2, String str3, Object[] objArr, Throwable th) {
        log(4, str, str2, str3, objArr, th);
    }

    public void log(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        logInternal(mapJULLevel(i), str, str2, str3, objArr, th);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void fine(String str, String str2, String str3) {
        trace(5, str, str2, str3, null, null);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void fine(String str, String str2, String str3, Object[] objArr) {
        trace(5, str, str2, str3, objArr, null);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void fine(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(5, str, str2, str3, objArr, th);
    }

    @Override // org.eclipse.paho.a.a.b.b
    public void finer(String str, String str2, String str3) {
        trace(6, str, str2, str3, null, null);
    }

    public void finer(String str, String str2, String str3, Object[] objArr) {
        trace(6, str, str2, str3, objArr, null);
    }

    public void finer(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(6, str, str2, str3, objArr, th);
    }

    public void finest(String str, String str2, String str3) {
        trace(7, str, str2, str3, null, null);
    }

    public void finest(String str, String str2, String str3, Object[] objArr) {
        trace(7, str, str2, str3, objArr, null);
    }

    public void finest(String str, String str2, String str3, Object[] objArr, Throwable th) {
        trace(7, str, str2, str3, objArr, th);
    }

    public void trace(int i, String str, String str2, String str3, Object[] objArr, Throwable th) {
        logInternal(mapJULLevel(i), str, str2, str3, objArr, th);
    }

    private void logInternal(Level level, String str, String str2, String str3, Object[] objArr, Throwable th) {
        Set<String> set;
        if (str3 == null) {
            return;
        }
        if (th != null || (set = this.mAcceptMsgId) == null || set.contains(str3)) {
            String str4 = level + " " + str + "." + str2 + ":" + str3 + " " + Arrays.toString(objArr);
            checkException(objArr);
            if (th != null) {
                LogUtils.e(this.mLogTag, str4, th);
            } else {
                LogUtils.d(this.mLogTag, str4);
            }
        }
    }

    private void checkException(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            if (obj != null && (obj instanceof n)) {
                n nVar = (n) obj;
                int a2 = nVar.a();
                Throwable cause = nVar.getCause();
                if (a2 == 32101 || a2 == 32102 || a2 == 32109) {
                    MqttChannel.getInstance().disconnectedDueToException(nVar);
                    return;
                } else if (a2 != 0 || cause == null) {
                    return;
                } else {
                    MqttChannel.getInstance().disconnectedDueToException(cause);
                    return;
                }
            }
        }
    }

    private Level mapJULLevel(int i) {
        switch (i) {
            case 1:
                return Level.SEVERE;
            case 2:
                return Level.WARNING;
            case 3:
                return Level.INFO;
            case 4:
                return Level.CONFIG;
            case 5:
                return Level.FINE;
            case 6:
                return Level.FINER;
            case 7:
                return Level.FINEST;
            default:
                return null;
        }
    }
}

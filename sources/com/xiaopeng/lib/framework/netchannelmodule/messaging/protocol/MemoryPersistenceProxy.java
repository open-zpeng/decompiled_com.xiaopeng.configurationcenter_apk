package com.xiaopeng.lib.framework.netchannelmodule.messaging.protocol;

import android.util.Pair;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.info.BuildInfoUtils;
import java.util.Enumeration;
import java.util.Hashtable;
import org.eclipse.paho.a.a.k;
import org.eclipse.paho.a.a.p;
import org.eclipse.paho.a.a.q;
/* loaded from: classes.dex */
public class MemoryPersistenceProxy implements k {
    private static final int MAX_MESSAGE_NUMBER = 200;
    private static final String TAG = "MemoryPersistenceProxy";
    protected String mClientId;
    protected Hashtable<String, Pair<p, Long>> mHashTable = new Hashtable<>();
    protected String mServerURI;
    protected boolean mTraceEnabled;

    private void log(String str) {
        if (BuildInfoUtils.isEngVersion() && this.mTraceEnabled) {
            LogUtils.d(TAG, str);
        }
    }

    public MemoryPersistenceProxy() {
        log("new MemoryPersistenceProxy");
    }

    private void checkOpen() throws q {
        if (this.mHashTable == null) {
            throw new q();
        }
    }

    @Override // org.eclipse.paho.a.a.k
    public void close() throws q {
        log("close()");
    }

    @Override // org.eclipse.paho.a.a.k
    public Enumeration keys() throws q {
        checkOpen();
        Enumeration<String> keys = this.mHashTable.keys();
        log("keys():" + keys + " hasMoreElements:" + keys.hasMoreElements());
        return keys;
    }

    @Override // org.eclipse.paho.a.a.k
    public p get(String str) throws q {
        checkOpen();
        p pVar = (p) this.mHashTable.get(str).first;
        log("get key:" + str + " result:" + pVar);
        return pVar;
    }

    @Override // org.eclipse.paho.a.a.k
    public void open(String str, String str2) throws q {
        log("open clientId:" + str + " serverURI:" + str2);
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("clientId or serverURI can't be null");
        }
        if (str.equals(this.mClientId) && str2.equals(this.mServerURI)) {
            log("same config, return!");
            return;
        }
        Hashtable<String, Pair<p, Long>> hashtable = this.mHashTable;
        if (hashtable != null) {
            hashtable.clear();
        }
        this.mClientId = str;
        this.mServerURI = str2;
        this.mHashTable = new Hashtable<>();
    }

    @Override // org.eclipse.paho.a.a.k
    public void put(String str, p pVar) throws q {
        checkOpen();
        log("put key:" + str + " persistable:" + pVar + " size:" + this.mHashTable.size());
        if (this.mHashTable.size() >= 200) {
            this.mHashTable.clear();
            log("exceed max persist count");
        }
        this.mHashTable.put(str, new Pair<>(pVar, Long.valueOf(System.currentTimeMillis())));
    }

    @Override // org.eclipse.paho.a.a.k
    public void remove(String str) throws q {
        checkOpen();
        log("remove key:" + str);
        this.mHashTable.remove(str);
    }

    @Override // org.eclipse.paho.a.a.k
    public void clear() throws q {
        checkOpen();
        log("clear");
        this.mHashTable.clear();
    }

    @Override // org.eclipse.paho.a.a.k
    public boolean containsKey(String str) throws q {
        checkOpen();
        boolean containsKey = this.mHashTable.containsKey(str);
        log("containsKey key:" + str + " result:" + containsKey);
        return containsKey;
    }

    public void setTraceEnabled(boolean z) {
        this.mTraceEnabled = z;
    }
}

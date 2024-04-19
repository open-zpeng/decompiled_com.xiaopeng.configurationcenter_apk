package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* compiled from: IpcRouterService_Manifest.java */
/* loaded from: classes.dex */
public class d {
    public static String a() {
        return "{\"authority\":\"com.xiaopeng.configurationcenter.IpcRouterService\",\"DESCRIPTOR\":\"com.xiaopeng.configurationcenter.IpcRouterService\",\"TRANSACTION\":[{\"path\":\"onReceiverData\",\"METHOD\":\"onReceiverData\",\"ID\":0,\"parameter\":[{\"alias\":\"id\",\"name\":\"id\"},{\"alias\":\"bundle\",\"name\":\"bundle\"}]}]}";
    }

    public static Set<String> b() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("IpcRouterService");
        return hashSet;
    }
}

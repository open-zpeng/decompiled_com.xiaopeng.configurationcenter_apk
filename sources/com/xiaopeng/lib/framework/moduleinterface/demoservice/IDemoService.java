package com.xiaopeng.lib.framework.moduleinterface.demoservice;

import a.a.g;
/* loaded from: classes.dex */
public interface IDemoService {

    /* loaded from: classes.dex */
    public static class DemoMessageEvent {
        public String mEvent;
        public long mParam1;
        public String mParam2;
    }

    void fireMessageEventInMainThread();

    void fireMessageEventInWorkThread();

    void getPage(String str, ICallback iCallback);

    g<String> getPageObservable(String str);

    String getWelcomeMessage();
}

package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import a.a.g;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
/* loaded from: classes.dex */
public interface IAppResourceManager {

    /* loaded from: classes.dex */
    public interface IResourceObserver {
        void onChange(String str, AppResourceResponse appResourceResponse);
    }

    boolean addResource(AppResourceRequest appResourceRequest);

    g<AppResourceResponse> addResourceObSource(AppResourceRequest appResourceRequest);

    void checkUpdate(String str);

    g<AppResourceResponse> checkUpdateObSource(String str);

    g<AppResourceResponse> clearResourceObSource();

    void clearResources();

    boolean deleteResource(String str);

    g<AppResourceResponse> deleteResourceObSource(String str);

    AssetFileDescriptor getFileDescriptor(String str);

    g<AssetFileDescriptor> getFileDescriptorObSource(String str);

    Uri getFullUri(String str);

    g<Uri> getFullUrlObSource(String str);

    Status getStatus(String str);

    g<Status> getStatusObSource(String str);

    void subscribeChanges(IResourceObserver iResourceObserver);

    void unSubscribeChanges(IResourceObserver iResourceObserver);

    /* loaded from: classes.dex */
    public enum UpdatePolicy {
        LOCAL(0),
        SYNC(1),
        ASYNC(2);
        
        final int mId;

        public int id() {
            return this.mId;
        }

        UpdatePolicy(int i) {
            this.mId = i;
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_REGISTER(0),
        NOT_AUTH(1),
        NOT_AVAILABLE(2),
        OK(3),
        ERROR(4);
        
        final int mId;

        public int id() {
            return this.mId;
        }

        Status(int i) {
            this.mId = i;
        }
    }
}

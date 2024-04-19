package com.xiaopeng.datalog.b;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.utils.DateUtils;
import com.xiaopeng.lib.utils.LogUtils;
import com.xiaopeng.lib.utils.MD5Utils;
import com.xiaopeng.lib.utils.SystemPropertyUtil;
import com.xiaopeng.lib.utils.ThreadUtils;
import com.xiaopeng.lib.utils.config.CommonConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: DataBackupHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f1358a;

    private a() {
    }

    public static a a() {
        if (f1358a == null) {
            synchronized (a.class) {
                if (f1358a == null) {
                    f1358a = new a();
                }
            }
        }
        return f1358a;
    }

    public void a(final String str, final String str2, final Context context) {
        ThreadUtils.post(0, new Runnable() { // from class: com.xiaopeng.datalog.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("vehicleId", String.valueOf(SystemPropertyUtil.getVehicleId()));
                jsonObject.addProperty("message", str2);
                jsonObject.addProperty("md5", MD5Utils.getMD5(str2));
                byte[] bytes = new Gson().toJson((JsonElement) jsonObject).getBytes();
                a.this.a(str, context);
                a.this.b(str, context);
                a.this.a(str, bytes, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Context context) {
        File file = new File("/sdcard/Log/" + str + "/" + context.getPackageName());
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, Context context) {
        File file = new File("/sdcard/Log/" + str + "/" + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new FilenameFilter() { // from class: com.xiaopeng.datalog.b.a.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.contains(str) && str2.endsWith(".log");
            }
        });
        if (list == null) {
            return;
        }
        Arrays.sort(list);
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (a(str2)) {
                arrayList.add(str2);
                LogUtils.d("DataBackupHelper", "file: " + str2 + " is expired, deleted " + new File("/sdcard/Log/" + str + "/" + context.getPackageName() + "/" + str2).delete());
            }
        }
        if (arrayList.size() > 0) {
            a(arrayList, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, Context context) {
        RandomAccessFile randomAccessFile;
        File c = c(str, context);
        File file = new File(b(c.getPath()));
        if (file.exists()) {
            LogUtils.i("DataBackupHelper", "zipFile exists, delete .zip and write .log");
            file.delete();
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(c, "rw");
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(bArr);
                randomAccessFile.writeBytes("\n");
                randomAccessFile.getFD().sync();
                LogUtils.i("DataBackupHelper", "write " + c + " success, data.length:" + bArr.length);
                randomAccessFile.close();
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = randomAccessFile;
                LogUtils.w("DataBackupHelper", "write file fail!", e);
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    private boolean a(String str) {
        int lastIndexOf = str.lastIndexOf("_");
        if (DateUtils.dateToStamp(DateUtils.formatDate10(System.currentTimeMillis()).substring(0, 8) + "_000000") - DateUtils.dateToStamp(str.substring(lastIndexOf - 8, lastIndexOf) + "_000000") > 604800000) {
            LogUtils.d("DataBackupHelper", str + " EXPIRED!");
            return true;
        }
        return false;
    }

    private File c(final String str, Context context) {
        File[] listFiles = new File("/sdcard/Log/" + str + "/" + context.getPackageName()).listFiles(new FilenameFilter() { // from class: com.xiaopeng.datalog.b.a.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                return str2.contains(str) && str2.contains(".log");
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            LogUtils.d("DataBackupHelper", "create a new File");
            return d(str, context);
        }
        Arrays.sort(listFiles);
        File file = listFiles[listFiles.length - 1];
        return (!a(file) || file.length() >= CommonConfig.MAX_LOG_LENGTH) ? d(str, context) : file;
    }

    private boolean a(File file) {
        String name = file.getName();
        String formatDate10 = DateUtils.formatDate10(System.currentTimeMillis());
        return name.contains(formatDate10.substring(0, formatDate10.indexOf("_")));
    }

    private File d(String str, Context context) {
        return new File("/sdcard/Log/" + str + "/" + context.getPackageName() + "/" + str + "_" + DateUtils.formatDate10(System.currentTimeMillis()) + ".log");
    }

    private String b(String str) {
        return str.replace(".log", ".zip");
    }

    private void a(List<String> list, String[] strArr) {
        String c;
        int size = list.size();
        String c2 = c(list.get(0));
        if (strArr.length > size) {
            c = c(strArr[size]);
        } else {
            c = c(list.get(size - 1));
        }
        IDataLog iDataLog = (IDataLog) Module.get(com.xiaopeng.datalog.a.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildStat().setEventName("data_expire").setProperty("startTime", c2).setProperty("endTime", c).build());
    }

    private String c(String str) {
        return str.substring(str.lastIndexOf("_") - 8, str.lastIndexOf("."));
    }
}

package com.xiaopeng.lib.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.a.a.a.a;
import org.apache.a.a.a.a.n;
/* loaded from: classes.dex */
public class Zip7zUtils {
    public static void zip7z(String str, String str2) {
        File file;
        n nVar;
        n nVar2 = null;
        try {
            try {
                File file2 = new File(str2);
                file = new File(str);
                nVar = new n(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            if (file.isDirectory()) {
                zip7zDirectory(file, nVar, "");
            } else {
                zip7zFile(file, nVar, "");
            }
            FileUtils.closeQuietly(nVar);
        } catch (IOException e2) {
            e = e2;
            nVar2 = nVar;
            System.out.println(e.toString());
            FileUtils.closeQuietly(nVar2);
        } catch (Throwable th2) {
            th = th2;
            nVar2 = nVar;
            FileUtils.closeQuietly(nVar2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    private static void zip7zFile(File file, n nVar, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = 0;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            StringBuilder append = new StringBuilder().append(str);
            String name = file.getName();
            nVar.a((a) nVar.a(file, append.append(name).toString()));
            byte[] bArr = new byte[4096];
            String str2 = name;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                str2 = null;
                nVar.a(bArr, 0, read);
            }
            FileUtils.closeQuietly(bufferedInputStream);
            bufferedInputStream2 = str2;
            if (nVar == null) {
                return;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (nVar == null) {
                return;
            }
            nVar.a();
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            FileUtils.closeQuietly(bufferedInputStream2);
            bufferedInputStream2 = bufferedInputStream2;
            if (nVar == null) {
                return;
            }
            nVar.a();
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            FileUtils.closeQuietly(bufferedInputStream2);
            if (nVar != null) {
                nVar.a();
            }
            throw th;
        }
        nVar.a();
    }

    private static void zip7zDirectory(File file, n nVar, String str) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                zip7zDirectory(file2, nVar, str + file2.getName() + "/");
            } else {
                zip7zFile(file2, nVar, str);
            }
        }
    }
}

package com.a.a;

import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class r<T> {
    public final s a(T t) {
        try {
            com.a.a.b.a.e eVar = new com.a.a.b.a.e();
            a(eVar, t);
            return eVar.a();
        } catch (IOException e) {
            throw new i(e);
        }
    }

    public abstract T a(com.a.a.c.a aVar) throws IOException;

    public abstract void a(com.a.a.c.b bVar, T t) throws IOException;
}

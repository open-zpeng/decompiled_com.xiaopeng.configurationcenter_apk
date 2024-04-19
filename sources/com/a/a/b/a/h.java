package com.a.a.b.a;

import com.a.a.q;
import com.a.a.r;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends r<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f994a = new q() { // from class: com.a.a.b.a.h.1
        @Override // com.a.a.q
        public <T> r<T> a(com.a.a.e eVar, com.a.a.d.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    };
    private final com.a.a.e b;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: com.a.a.b.a.h$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f995a;

        static {
            int[] iArr = new int[com.a.a.c.c.values().length];
            f995a = iArr;
            try {
                iArr[com.a.a.c.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f995a[com.a.a.c.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f995a[com.a.a.c.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f995a[com.a.a.c.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f995a[com.a.a.c.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f995a[com.a.a.c.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private h(com.a.a.e eVar) {
        this.b = eVar;
    }

    @Override // com.a.a.r
    public Object a(com.a.a.c.a aVar) throws IOException {
        switch (AnonymousClass2.f995a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.a.a.b.h hVar = new com.a.a.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), a(aVar));
                }
                aVar.d();
                return hVar;
            case 3:
                return aVar.h();
            case 4:
                return Double.valueOf(aVar.k());
            case 5:
                return Boolean.valueOf(aVar.i());
            case 6:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.a.a.r
    public void a(com.a.a.c.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.f();
            return;
        }
        r a2 = this.b.a((Class) obj.getClass());
        if (!(a2 instanceof h)) {
            a2.a(bVar, obj);
            return;
        }
        bVar.d();
        bVar.e();
    }
}

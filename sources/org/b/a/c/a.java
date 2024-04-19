package org.b.a.c;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final int f1404a;
    final int[] b = new int[4];
    final f c = new f();
    final short[][] d = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[] e = new short[12];
    final short[] f = new short[12];
    final short[] g = new short[12];
    final short[] h = new short[12];
    final short[][] i = (short[][]) Array.newInstance(short.class, 12, 16);
    final short[][] j = (short[][]) Array.newInstance(short.class, 4, 64);
    final short[][] k = {new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
    final short[] l = new short[16];

    /* renamed from: org.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    abstract class AbstractC0100a {

        /* renamed from: a  reason: collision with root package name */
        final short[] f1405a = new short[2];
        final short[][] b = (short[][]) Array.newInstance(short.class, 16, 8);
        final short[][] c = (short[][]) Array.newInstance(short.class, 16, 8);
        final short[] d = new short[IRadioController.TEF663x_PCHANNEL];
        private final a e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractC0100a(a aVar) {
            this.e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            org.b.a.d.a.a(this.f1405a);
            int i = 0;
            while (true) {
                short[][] sArr = this.b;
                if (i >= sArr.length) {
                    break;
                }
                org.b.a.d.a.a(sArr[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.b.length; i2++) {
                org.b.a.d.a.a(this.c[i2]);
            }
            org.b.a.d.a.a(this.d);
        }
    }

    /* loaded from: classes.dex */
    abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f1406a;
        private final int b;
        private final a c;

        /* renamed from: org.b.a.c.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        abstract class AbstractC0101a {

            /* renamed from: a  reason: collision with root package name */
            final short[] f1407a = new short[768];
            private final b b;

            /* JADX INFO: Access modifiers changed from: package-private */
            public AbstractC0101a(b bVar) {
                this.b = bVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void a() {
                org.b.a.d.a.a(this.f1407a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(a aVar, int i, int i2) {
            this.c = aVar;
            this.f1406a = i;
            this.b = (1 << i2) - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int a(int i, int i2) {
            int i3 = this.f1406a;
            return (i >> (8 - i3)) + ((i2 & this.b) << i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        this.f1404a = (1 << i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i) {
        if (i < 6) {
            return i - 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int[] iArr = this.b;
        int i = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.c.a();
        int i2 = 0;
        while (true) {
            short[][] sArr = this.d;
            if (i2 >= sArr.length) {
                break;
            }
            org.b.a.d.a.a(sArr[i2]);
            i2++;
        }
        org.b.a.d.a.a(this.e);
        org.b.a.d.a.a(this.f);
        org.b.a.d.a.a(this.g);
        org.b.a.d.a.a(this.h);
        int i3 = 0;
        while (true) {
            short[][] sArr2 = this.i;
            if (i3 >= sArr2.length) {
                break;
            }
            org.b.a.d.a.a(sArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            short[][] sArr3 = this.j;
            if (i4 >= sArr3.length) {
                break;
            }
            org.b.a.d.a.a(sArr3[i4]);
            i4++;
        }
        while (true) {
            short[][] sArr4 = this.k;
            if (i >= sArr4.length) {
                org.b.a.d.a.a(this.l);
                return;
            } else {
                org.b.a.d.a.a(sArr4[i]);
                i++;
            }
        }
    }
}

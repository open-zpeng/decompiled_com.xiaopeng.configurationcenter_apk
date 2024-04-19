package com.a.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
/* compiled from: LinkedTreeMap.java */
/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f = true;
    private static final Comparator<Comparable> g = new Comparator<Comparable>() { // from class: com.a.a.b.h.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Comparator<? super K> f1028a;
    c<K, V> b;
    int c;
    int d;
    final c<K, V> e;
    private h<K, V>.a h;
    private h<K, V>.b i;

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || h.this.a((Map.Entry) obj) == null) {
                return false;
            }
            return h.f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new h<K, V>.d<Map.Entry<K, V>>() { // from class: com.a.a.b.h.a.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            c<K, V> a2;
            if ((obj instanceof Map.Entry) && (a2 = h.this.a((Map.Entry) obj)) != null) {
                h.this.a((c) a2, h.f);
                return h.f;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new h<K, V>.d<K>() { // from class: com.a.a.b.h.b.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (h.this.b(obj) != null) {
                return h.f;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public static final class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f1033a;
        c<K, V> b;
        c<K, V> c;
        c<K, V> d;
        c<K, V> e;
        final K f;
        V g;
        int h;

        c() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        c(c<K, V> cVar, K k, c<K, V> cVar2, c<K, V> cVar3) {
            this.f1033a = cVar;
            this.f = k;
            this.h = 1;
            this.d = cVar2;
            this.e = cVar3;
            cVar3.d = this;
            cVar2.e = this;
        }

        public c<K, V> a() {
            c<K, V> cVar = this;
            for (c<K, V> cVar2 = this.b; cVar2 != null; cVar2 = cVar2.b) {
                cVar = cVar2;
            }
            return cVar;
        }

        public c<K, V> b() {
            c<K, V> cVar = this;
            for (c<K, V> cVar2 = this.c; cVar2 != null; cVar2 = cVar2.c) {
                cVar = cVar2;
            }
            return cVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.g;
                Object value = entry.getValue();
                if (v == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!v.equals(value)) {
                    return false;
                }
                return h.f;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes.dex */
    public abstract class d<T> implements Iterator<T> {
        c<K, V> b;
        c<K, V> c;
        int d;

        private d() {
            this.b = h.this.e.d;
            this.c = null;
            this.d = h.this.d;
        }

        final c<K, V> b() {
            c<K, V> cVar = this.b;
            if (cVar != h.this.e) {
                if (h.this.d == this.d) {
                    this.b = cVar.d;
                    this.c = cVar;
                    return cVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.b != h.this.e) {
                return h.f;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            c<K, V> cVar = this.c;
            if (cVar == null) {
                throw new IllegalStateException();
            }
            h.this.a((c) cVar, h.f);
            this.c = null;
            this.d = h.this.d;
        }
    }

    public h() {
        this(g);
    }

    public h(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new c<>();
        this.f1028a = comparator == null ? g : comparator;
    }

    private void a(c<K, V> cVar) {
        c<K, V> cVar2 = cVar.b;
        c<K, V> cVar3 = cVar.c;
        c<K, V> cVar4 = cVar3.b;
        c<K, V> cVar5 = cVar3.c;
        cVar.c = cVar4;
        if (cVar4 != null) {
            cVar4.f1033a = cVar;
        }
        a((c) cVar, (c) cVar3);
        cVar3.b = cVar;
        cVar.f1033a = cVar3;
        cVar.h = Math.max(cVar2 != null ? cVar2.h : 0, cVar4 != null ? cVar4.h : 0) + 1;
        cVar3.h = Math.max(cVar.h, cVar5 != null ? cVar5.h : 0) + 1;
    }

    private void a(c<K, V> cVar, c<K, V> cVar2) {
        c<K, V> cVar3 = cVar.f1033a;
        cVar.f1033a = null;
        if (cVar2 != null) {
            cVar2.f1033a = cVar3;
        }
        if (cVar3 == null) {
            this.b = cVar2;
        } else if (cVar3.b == cVar) {
            cVar3.b = cVar2;
        } else if (!f && cVar3.c != cVar) {
            throw new AssertionError();
        } else {
            cVar3.c = cVar2;
        }
    }

    private boolean a(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return f;
        }
        return false;
    }

    private void b(c<K, V> cVar) {
        c<K, V> cVar2 = cVar.b;
        c<K, V> cVar3 = cVar.c;
        c<K, V> cVar4 = cVar2.b;
        c<K, V> cVar5 = cVar2.c;
        cVar.b = cVar5;
        if (cVar5 != null) {
            cVar5.f1033a = cVar;
        }
        a((c) cVar, (c) cVar2);
        cVar2.c = cVar;
        cVar.f1033a = cVar2;
        cVar.h = Math.max(cVar3 != null ? cVar3.h : 0, cVar5 != null ? cVar5.h : 0) + 1;
        cVar2.h = Math.max(cVar.h, cVar4 != null ? cVar4.h : 0) + 1;
    }

    private void b(c<K, V> cVar, boolean z) {
        while (cVar != null) {
            c<K, V> cVar2 = cVar.b;
            c<K, V> cVar3 = cVar.c;
            int i = cVar2 != null ? cVar2.h : 0;
            int i2 = cVar3 != null ? cVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                c<K, V> cVar4 = cVar3.b;
                c<K, V> cVar5 = cVar3.c;
                int i4 = (cVar4 != null ? cVar4.h : 0) - (cVar5 != null ? cVar5.h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((c) cVar3);
                }
                a((c) cVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                c<K, V> cVar6 = cVar2.b;
                c<K, V> cVar7 = cVar2.c;
                int i5 = (cVar6 != null ? cVar6.h : 0) - (cVar7 != null ? cVar7.h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((c) cVar2);
                }
                b((c) cVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                cVar.h = i + 1;
                if (z) {
                    return;
                }
            } else if (!f && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                cVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            cVar = cVar.f1033a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    c<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a((h<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    c<K, V> a(K k, boolean z) {
        int i;
        c<K, V> cVar;
        Comparator<? super K> comparator = this.f1028a;
        c<K, V> cVar2 = this.b;
        if (cVar2 != null) {
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                Object obj = (K) cVar2.f;
                i = comparable != null ? comparable.compareTo(obj) : comparator.compare(k, obj);
                if (i == 0) {
                    return cVar2;
                }
                c<K, V> cVar3 = i < 0 ? cVar2.b : cVar2.c;
                if (cVar3 == null) {
                    break;
                }
                cVar2 = cVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            c<K, V> cVar4 = this.e;
            if (cVar2 != null) {
                cVar = new c<>(cVar2, k, cVar4, cVar4.e);
                if (i < 0) {
                    cVar2.b = cVar;
                } else {
                    cVar2.c = cVar;
                }
                b(cVar2, f);
            } else if (comparator == g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            } else {
                cVar = new c<>(cVar2, k, cVar4, cVar4.e);
                this.b = cVar;
            }
            this.c++;
            this.d++;
            return cVar;
        }
        return null;
    }

    c<K, V> a(Map.Entry<?, ?> entry) {
        c<K, V> a2 = a(entry.getKey());
        if ((a2 == null || !a(a2.g, entry.getValue())) ? false : f) {
            return a2;
        }
        return null;
    }

    void a(c<K, V> cVar, boolean z) {
        int i;
        if (z) {
            cVar.e.d = cVar.d;
            cVar.d.e = cVar.e;
        }
        c<K, V> cVar2 = cVar.b;
        c<K, V> cVar3 = cVar.c;
        c<K, V> cVar4 = cVar.f1033a;
        int i2 = 0;
        if (cVar2 == null || cVar3 == null) {
            if (cVar2 != null) {
                a((c) cVar, (c) cVar2);
                cVar.b = null;
            } else if (cVar3 != null) {
                a((c) cVar, (c) cVar3);
                cVar.c = null;
            } else {
                a((c) cVar, (c) null);
            }
            b(cVar4, false);
            this.c--;
            this.d++;
            return;
        }
        c<K, V> b2 = cVar2.h > cVar3.h ? cVar2.b() : cVar3.a();
        a((c) b2, false);
        c<K, V> cVar5 = cVar.b;
        if (cVar5 != null) {
            i = cVar5.h;
            b2.b = cVar5;
            cVar5.f1033a = b2;
            cVar.b = null;
        } else {
            i = 0;
        }
        c<K, V> cVar6 = cVar.c;
        if (cVar6 != null) {
            i2 = cVar6.h;
            b2.c = cVar6;
            cVar6.f1033a = b2;
            cVar.c = null;
        }
        b2.h = Math.max(i, i2) + 1;
        a((c) cVar, (c) b2);
    }

    c<K, V> b(Object obj) {
        c<K, V> a2 = a(obj);
        if (a2 != null) {
            a((c) a2, (boolean) f);
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        c<K, V> cVar = this.e;
        cVar.e = cVar;
        cVar.d = cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (a(obj) != null) {
            return f;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        c<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        c<K, V> a2 = a((h<K, V>) k, (boolean) f);
        V v2 = a2.g;
        a2.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }
}

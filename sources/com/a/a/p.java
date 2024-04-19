package com.a.a;
/* compiled from: LongSerializationPolicy.java */
/* loaded from: classes.dex */
public enum p {
    DEFAULT { // from class: com.a.a.p.1
        @Override // com.a.a.p
        public s O000000o(Long l) {
            return new n(l);
        }
    },
    STRING { // from class: com.a.a.p.2
        @Override // com.a.a.p
        public s O000000o(Long l) {
            return new n(String.valueOf(l));
        }
    };

    public abstract s O000000o(Long l);
}

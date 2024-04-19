package com.a.a;

import java.lang.reflect.Field;
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public enum b implements d {
    IDENTITY { // from class: com.a.a.b.1
        @Override // com.a.a.d
        public String O000000o(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.a.a.b.2
        @Override // com.a.a.d
        public String O000000o(Field field) {
            return b.b(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.a.a.b.3
        @Override // com.a.a.d
        public String O000000o(Field field) {
            return b.b(b.b(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.a.a.b.4
        @Override // com.a.a.d
        public String O000000o(Field field) {
            return b.b(field.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.a.a.b.5
        @Override // com.a.a.d
        public String O000000o(Field field) {
            return b.b(field.getName(), "-").toLowerCase();
        }
    };

    private static String a(char c, String str, int i) {
        return i < str.length() ? c + str.substring(i) : String.valueOf(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            charAt = str.charAt(i);
            if (i >= str.length() - 1 || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            i++;
        }
        return i == str.length() ? sb.toString() : !Character.isUpperCase(charAt) ? sb.append(a(Character.toUpperCase(charAt), str, i + 1)).toString() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}

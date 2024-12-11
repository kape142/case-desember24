package com.kape142.fagsystem.util;

public class NumberGenerator {
    public static String generateNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((int)Math.floor(Math.random() * 10));
        }
        return sb.toString();
    }
}

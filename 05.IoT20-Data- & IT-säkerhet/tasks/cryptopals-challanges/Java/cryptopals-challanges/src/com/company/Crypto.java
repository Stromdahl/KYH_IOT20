package com.company;

import java.util.*;

public class Crypto {

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();

        // This only works with an even number of characters.
        // If len is odd, append a 0 at the start of number
        if (len % 2 != 0) {
            s = "0" + s;
            len++;
        }

        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int value = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[value >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[value & 0x0F];
        }
        return new String(hexChars);
    }

    public static String base64Encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] xorBytes(byte[] A, byte[] B) {
        byte[] c = new byte[A.length];
        for (int i = 0; i < A.length; i++) {
            c[i] = (byte) (A[i] ^ B[i % B.length]);
        }
        return c;
    }

    public static byte[] singleCharKeyXOR(byte[] cypher, byte key){
        return xorBytes(cypher, new byte[]{key});
    }

    public static double getEnglishScore(String text) {

        text = text.toLowerCase(Locale.ROOT);

        Map<Character, Double> letterFrequency = new HashMap<>();
        letterFrequency.put('a', 0.08167);
        letterFrequency.put('b', 0.01492);
        letterFrequency.put('c', 0.02782);
        letterFrequency.put('d', 0.04253);
        letterFrequency.put('e', 0.12702);
        letterFrequency.put('f', 0.02228);
        letterFrequency.put('g', 0.02015);
        letterFrequency.put('h', 0.06094);
        letterFrequency.put('i', 0.06094);
        letterFrequency.put('j', 0.00153);
        letterFrequency.put('k', 0.00772);
        letterFrequency.put('l', 0.04025);
        letterFrequency.put('m', 0.02406);
        letterFrequency.put('n', 0.06749);
        letterFrequency.put('o', 0.07507);
        letterFrequency.put('p', 0.01929);
        letterFrequency.put('q', 0.00095);
        letterFrequency.put('r', 0.05987);
        letterFrequency.put('s', 0.06327);
        letterFrequency.put('t', 0.09056);
        letterFrequency.put('u', 0.02758);
        letterFrequency.put('v', 0.00978);
        letterFrequency.put('w', 0.02360);
        letterFrequency.put('x', 0.00150);
        letterFrequency.put('y', 0.01974);
        letterFrequency.put('z', 0.00074);
        letterFrequency.put(' ', 0.13000);

        List < Double > scores = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (letterFrequency.containsKey(c)) {
                scores.add(letterFrequency.get(c));
            }
        }
        return scores.stream().mapToDouble(a -> a).sum();
    }

    public static String getBestEnglishString(byte[] bytes){
        double bestScore = 0;
        String bestString = "";

        for (byte key = 32; key < 127; key++) {
            byte[] resultBytes = Crypto.singleCharKeyXOR(bytes, key);
            String result = new String(resultBytes);
            double score = Crypto.getEnglishScore(result);
            if (score > bestScore) {
                bestString = result;
                bestScore = score;
            }
        }
        return bestString;
    }

    public static byte[] xorRepeatingKey(byte[] text, byte[] key){
        byte[] cypher = new byte[0];

        return text;
    }

    public static int hammingDistance(byte a, byte b) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (((a >> i) & 1) != ((b >> i) & 1)) count++;
        }
        return count;
    }

    public static int hammingDistance(byte[] a, byte[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += hammingDistance(a[i], b[i]);
        }
        return count;
    }

    public static byte[][] divide(byte[] text, int size){
        byte[][] result = new byte[text.length/size][size];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOfRange(text,i * size, i * size + size);
        }
        return result;
    }

}

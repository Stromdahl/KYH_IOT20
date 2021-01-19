package com.company;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Main {

    public static void saveKey(String fileName, KeyPair key) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(key);
            out.close();
            System.out.println("Saved key as " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static KeyPair readKey(String fileName) {
        KeyPair key = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            key = (KeyPair) in.readObject();
            in.close();
            System.out.println("Read key from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static BigInteger phi(BigInteger p, BigInteger q) {
        // (p - 1) * (q - 1) = phi(n)
        return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    public static void generateKeys(String filename, int bitLength) {
        SecureRandom secureRandom = new SecureRandom();

        BigInteger p = new BigInteger(bitLength / 2, 100, secureRandom);
        BigInteger q = new BigInteger(bitLength / 2, 100, secureRandom);
        BigInteger n = p.multiply(q);
        BigInteger phiN = phi(p, q); // (p - 1) * (q - 1) = phi(n)
        BigInteger e = new BigInteger("3"); //Större än 2 mindre än phi(N)
        while (phiN.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }

        BigInteger d = e.modInverse(phiN);
        KeyPair publicKey = new KeyPair(e, n);
        KeyPair privateKey = new KeyPair(d, n);
        saveKey(filename + "_pub.key", publicKey);
        saveKey(filename + "_priv.key", privateKey);
    }

    private static String encrypt(String message, KeyPair key) {
        return (new BigInteger(message.getBytes(StandardCharsets.UTF_8)).modPow(key.getKey(), key.getN()).toString());
    }


    private static String decrypt(String message, KeyPair key) {
        String msg = new String(message.getBytes(StandardCharsets.UTF_8));
        return new String(new BigInteger(msg).modPow(key.getKey(), key.getN()).toByteArray());
    }


    public static void main(String[] args) {
        //generateKeys("keys", 4096);
        KeyPair publicKey = readKey("keys_pub.key");
        KeyPair privateKey = readKey("keys_priv.key");
        String encrypted = encrypt("Hemligt meddelande", publicKey);
        String clear = decrypt(encrypted, privateKey);
        System.out.println(clear);

        //m^e mod n = c
        //Encrypt
        //String cipher = msg.modPow(e, n).toString();
        //Decrypt
        //        String plain = new String(new BigInteger(cipher).modPow(d, n).toByteArray());

    }


}

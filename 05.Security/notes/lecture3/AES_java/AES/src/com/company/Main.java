package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {


    public static void main(String[] args)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        AES aes = new AES();
        IvParameterSpec iv = aes.generateIV();
        aes.saveIv("myiv.is", iv);
        SecretKeySpec skey = aes.generateKey();
        aes.encrypt("Jag vill ha lunch!", "crypto.enc", skey, iv);

        String result = aes.decrypt("crypto.enc", skey, iv);
        System.out.println(result);
    }
}
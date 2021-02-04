package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {

        String key = "ICE";

        String text = "Te lt     tusernep ta hhr sacu htyucnueadta lei h odi h ihrta trswt ei eaoasnhc tw tcehstie";
        byte[] cypher = Crypto.xorBytes(text.getBytes(), key.getBytes());
        String actual = Crypto.bytesToHex(cypher).toLowerCase();
        System.out.println(actual);

        /// There·is·a·clue·that·you·can·use·and·that·clue·is·the·word·in·the·cipher·that·starts·with·e
    }
}

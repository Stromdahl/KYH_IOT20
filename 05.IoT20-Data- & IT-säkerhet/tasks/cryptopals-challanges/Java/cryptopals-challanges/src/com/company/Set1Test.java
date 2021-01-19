package com.company;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Set1Test {

    @Test
    void testStringScore() {

        double score = Crypto.getEnglishScore("Cooking MC's like a pound of bacon");

        assertEquals(2.14329d, score);
    }

    @Test
    void TestHammingDistance(){
        assertEquals(1, Crypto.hammingDistance((byte)0b010, (byte)0b011));
        assertEquals(3, Crypto.hammingDistance((byte)0b010, (byte)0b101));
        assertEquals(2, Crypto.hammingDistance((byte)0b010, (byte)0b111));
        assertEquals(2, Crypto.hammingDistance((byte)0b011, (byte)0b101));
        assertEquals(1, Crypto.hammingDistance((byte)0b011, (byte)0b111));
        assertEquals(1, Crypto.hammingDistance((byte)0b101, (byte)0b111));
    }

    @Test
    void TestHammingDistanceByteArray(){
        assertEquals(37, Crypto.hammingDistance("this is a test".getBytes(), "wokka wokka!!!".getBytes()));
    }

    @Test
    void testDivide(){

        byte[][] result = Crypto.divide(new byte[]{0,0,0,0,0,0,0,0,0}, 3);
        assertEquals(3, result.length);
        assertEquals(3, result[0].length);
    }


}

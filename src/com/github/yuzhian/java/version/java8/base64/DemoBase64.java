package com.github.yuzhian.java.version.java8.base64;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author yuzhian
 */
public class DemoBase64 {
    public static void main(String[] args) {
        String src = "hello world!";
        // encode
        byte[] encodeToByte = Base64.getEncoder().encode(src.getBytes());
        System.out.println("encodeToByte: " + Arrays.toString(encodeToByte));
        String encodeToString = Base64.getEncoder().encodeToString(src.getBytes());
        System.out.println("encodeToString: " + encodeToString);
        // decode
        byte[] decodeByByte = Base64.getDecoder().decode(encodeToByte);
        System.out.println("decodeByByte: " + Arrays.toString(decodeByByte));
        byte[] decodeByString = Base64.getDecoder().decode(encodeToString);
        System.out.println("decodeByString: " + Arrays.toString(decodeByString));
        String srcByDecode = new String(decodeByByte);
        System.out.println("srcByDecode: " + srcByDecode);
    }
}

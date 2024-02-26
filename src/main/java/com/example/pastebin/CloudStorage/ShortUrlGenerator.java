package com.example.pastebin.CloudStorage;

import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class ShortUrlGenerator {

    String shortUrl;

    public ShortUrlGenerator() {
    }
    public String generateUrlFromLong(long sequenceVal) {
        try {
            byte[] bytes = ByteBuffer.allocate(8).putLong(sequenceVal).array();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(bytes);
            String encryptString = Base64.getUrlEncoder().encodeToString(messageDigest);
            return shortUrl = encryptString.substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

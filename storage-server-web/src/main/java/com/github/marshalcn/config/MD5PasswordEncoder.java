package com.github.marshalcn.config;

import com.github.marshalcn.utils.SecureUtil;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;


public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return SecureUtil.md5(SecureUtil.md5(rawPassword.toString()));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] expectedBytes = bytesUtf8(rawPassword.toString());
        byte[] actualBytes = bytesUtf8(encodedPassword);
        return MessageDigest.isEqual(expectedBytes, actualBytes);
    }

    private static byte[] bytesUtf8(String s) {
        // need to check if Utf8.encode() runs in constant time (probably not).
        // This may leak length of string.
        return (s != null) ? Utf8.encode(s) : null;
    }
}

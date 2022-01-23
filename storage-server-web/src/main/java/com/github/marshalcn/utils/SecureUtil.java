package com.github.marshalcn.utils;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SecureUtil {
    public static String md5(String val){
        String res = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(val.getBytes(StandardCharsets.UTF_8));
            res = Hex.encodeHexString(messageDigest.digest());
        }catch (Exception e){

        }
        return res;
    }

    public static String encrypt(String userName, String password, String salt){
        return md5(userName + salt + password);
    }

}

package com.github.marshalcn.utils;

public class RedisKeyGenerator {
    public static String getTokenKey(String token){
        return "token_" + token;
    }
}

package com.holidaysomething.holidaysomething.util;

import java.util.UUID;

public class UUIDGenerator {
    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

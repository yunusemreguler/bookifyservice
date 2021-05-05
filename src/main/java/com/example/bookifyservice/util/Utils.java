package com.example.bookifyservice.util;

import java.time.Instant;

public class Utils {

    public static long getTimestamp(){
        return Instant.now().getEpochSecond();
    }

}

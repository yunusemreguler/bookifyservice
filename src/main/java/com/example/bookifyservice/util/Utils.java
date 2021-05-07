package com.example.bookifyservice.util;

import java.time.Instant;
import java.util.Date;

public class Utils {

    public static long getTimestamp(){
        return Instant.now().getEpochSecond();
    }

    public static Date getDateTime(){
        return new Date();
    }

}

package com.softgroup.kuznietsov.utils;

import java.util.UUID;

/**
 * Created by User on 27.02.2017.
 */
public class EntityIdGenerator {
    public static Long random(){
        Long l = UUID.randomUUID().getLeastSignificantBits();
        if(l<0){
            l=-l;
        }
        return l;
    }
}

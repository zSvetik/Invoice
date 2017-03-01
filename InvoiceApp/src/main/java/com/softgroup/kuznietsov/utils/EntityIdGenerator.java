package com.softgroup.kuznietsov.utils;

import java.util.UUID;

/**
 * Created by User on 27.02.2017.
 */
public class EntityIdGenerator {

    public static Long random(){
        return UUID.randomUUID().getLeastSignificantBits();
    }
}

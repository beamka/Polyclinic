package ua.clinic.utils;

import java.util.UUID;

/*
 * 
 * 
 */

/**
 *
 * @author al
 */
public class EntityIdGenerator {
    public static Long random(){
        return Math.abs(UUID.randomUUID().getLeastSignificantBits());
    }
}

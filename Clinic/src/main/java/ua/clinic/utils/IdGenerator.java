package ua.clinic.utils;

import java.security.SecureRandom;
import java.math.*;

/**
 * @author Iryna Tkachova
 */
public final class IdGenerator {
    private static SecureRandom random = new SecureRandom();

    public static Long newId() {
        return Math.abs(new BigInteger(20, random).longValue());
    }
}

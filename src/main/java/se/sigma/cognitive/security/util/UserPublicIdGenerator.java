package se.sigma.cognitive.security.util;


import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class UserPublicIdGenerator {


    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS = 10000;
    private final int KEY_LENGTH = 256;


    public String generateUserId(int lenght) {
        return generateRandomString(lenght);
    }

    private String generateRandomString(int lenght) {

        StringBuilder randomString = new StringBuilder(lenght);

        for (int i = 0; i < lenght; i++) {
            randomString.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

        }

        return new String(randomString);
    }

}

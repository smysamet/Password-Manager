package com.example.passwordmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordCreator {

    private static final char[] letters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private static final char[] specialCharacters = {
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '{', '}', '[', ']', '|', '\\', ';',
            ':', '<', '>', ',', '.', '?', '/'
    };

    private static final char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private static final int numberOfLetters = 5;
    private static final int numberOfSpecialCharacters = 5;
    private static final int numberOfDigits = 5;

    private static final Random random = new Random();

    public static String createPassword() {

        int passwordLenght = numberOfDigits + numberOfLetters + numberOfSpecialCharacters;

        StringBuilder stringBuilder = new StringBuilder(passwordLenght);

        List<Character> randomCharacters = new ArrayList<>();

        for (int i = 0; i < numberOfLetters; i++) {
            randomCharacters.add(letters[random.nextInt(letters.length)]);
        }

        for (int i = 0; i < numberOfSpecialCharacters; i++) {
            randomCharacters.add(specialCharacters[random.nextInt(specialCharacters.length)]);
        }

        for (int i = 0; i < numberOfDigits; i++) {
            randomCharacters.add(digits[random.nextInt(digits.length)]);
        }

        Collections.shuffle(randomCharacters);

        for (char c : randomCharacters) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}

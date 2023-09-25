package de.neuefische;

import java.util.Scanner;

public class Main {



/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       System.out.println("Bitte geben sie ein Passwort ein:");
        System.out.println(validatePassword(testPassword));
    }*/

    public static void main(String[] args) {
        String testPassword = "Alex123456!";
        System.out.println(validatePassword(testPassword));
    }


    public static String validatePassword(String password) {
        if (password == null) {
            return "Da steht nix du Zipfeglatscher!";
        }
        if (!isPasswordLengthValid(password) ||
                !containsBothCases(password) ||
                !containsDigits(password) ||
                isCommonPassword(password) ||
                !containsSpecialCharacter(password)) {
            return "Das Passwort ist Ungültig!";
        }
        return "Das Passwort ist gültig!";
    }

    public static boolean isPasswordLengthValid(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        char[] charactersInPassword = password.toCharArray();
        for (char currentCharacter : charactersInPassword) {
            if (Character.isDigit(currentCharacter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsBothCases(String password) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (char symbol : password.toCharArray()) {
            if (!hasLowerCase) {
                hasLowerCase = Character.isLowerCase(symbol);
            }

            if (!hasUpperCase) {
                hasUpperCase = Character.isUpperCase(symbol);
            }

            if (hasLowerCase && hasUpperCase) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommonPassword(String password) {
        String[] commonPasswords = {"12345678", "password", "Alex", "welcome", "HELLO"};
        for (String commonPassword : commonPasswords) {
            if (password.equals(commonPassword)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacter(String password) {
        String specialChars  = "!@#$%^&*()-_=+[]{}|;:.<>?";
        for (char symbol : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(symbol))) {
                return true;
            }
        }
        return false;
    }
}

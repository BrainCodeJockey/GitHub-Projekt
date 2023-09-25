package de.neuefische;

public class Main {
    public static void main(String[] args) {
        String testPassword = "Alex12345678";
        System.out.println(validatePassword(testPassword));
    }

    public static String validatePassword(String password) {
        if (password == null) {
            return "Da steht nix du Zipfeglatscher!";
        }
        if (!isPasswordLengthValid(password) ||
                !containsBothCases(password) ||
                !containsDigits(password) ||
                isCommonPassword(password)) {
              //  !containsSpecialCharacter(password) {
            return "Das Passwort ist Ungültig!";
        }
        return "Das Passwort ist gültig!";
    }

    public static boolean isPasswordLengthValid(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        for (char digit : password.toCharArray()) {
            if (Character.isDigit(digit)) {
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

    public static boolean containsSpecialCharacter(String password)




}

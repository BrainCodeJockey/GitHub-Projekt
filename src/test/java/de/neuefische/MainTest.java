package de.neuefische;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testIsPasswordLengthValidForNull() {
        // Given
        String password = null;

        // Then
        assertThrows(NullPointerException.class, () -> {
            // When
            Main.isPasswordLengthValid(password);
        });
    }

    @Test
    void testIsPasswordLengthValidForShortPassword() {
        // Given
        String password = "1234567";

        // When
        boolean isValid = Main.isPasswordLengthValid(password);

        // Then
        assertFalse(isValid);
    }

    @Test
    void testIsPasswordLengthValidForValidPassword() {
        // Given
        String password = "12345678";

        // When
        boolean isValid = Main.isPasswordLengthValid(password);

        // Then
        assertTrue(isValid);
    }

    @Test
    void testIsPasswordLengthValidForLongPassword() {
        // Given
        String password = "1234567890123456";

        // When
        boolean isValid = Main.isPasswordLengthValid(password);

        // Then
        assertTrue(isValid);
    }

    @Test
    void testContainsDigitsWithoutDigits() {
        // Given
        String password = "Passwort";

        // When
        boolean hasDigits = Main.containsDigits(password);

        // Then
        assertFalse(hasDigits);
    }

    @Test
    void testContainsDigitsWithDigits() {
        // Given
        String password = "Passwort123";

        // When
        boolean hasDigits = Main.containsDigits(password);

        // Then
        assertTrue(hasDigits);
    }

    @Test
    void testContainsBothCasesWithoutLowercase() {
        // Given
        String password = "PASWQOERT";

        // When
        boolean hasBothCases = Main.containsBothCases(password);

        // Then
        assertFalse(hasBothCases);
    }

    @Test
    void testContainsBothCasesWithBothCases() {
        // Given
        String password = "KennKIVE";

        // When
        boolean hasBothCases = Main.containsBothCases(password);

        // Then
        assertTrue(hasBothCases);
    }

    @Test
    void testIsCommonPasswordForCommonPassword() {
        // Given
        String password = "12345678";

        // When
        boolean isCommon = Main.isCommonPassword(password);

        // Then
        assertTrue(isCommon);
    }

    @Test
    void testIsCommonPasswordForAnotherCommonPassword() {
        // Given
        String password = "password";

        // When
        boolean isCommon = Main.isCommonPassword(password);

        // Then
        assertTrue(isCommon);
    }

}

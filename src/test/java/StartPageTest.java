import org.junit.jupiter.api.Test;
import program.Start.StartPage;

import static org.junit.jupiter.api.Assertions.*;

public class StartPageTest {
    @Test
    public void testCheckPasswordSecureEnough() {
        assertFalse(StartPage.checkPasswordSecureEnough("abc")); // Password length < 8
        assertFalse(StartPage.checkPasswordSecureEnough("")); // Emty field
        assertFalse(StartPage.checkPasswordSecureEnough("abcdefgh")); // No upper case, numbers or special characters
        assertFalse(StartPage.checkPasswordSecureEnough("abcde1234")); // No upper case or special character
        assertFalse(StartPage.checkPasswordSecureEnough("Abcd1234")); // No special Character
        assertTrue(StartPage.checkPasswordSecureEnough("Abcd1234!@#")); // Password is strong enough
    }
    @Test
    public void testCheckEmailIsValidFormat() {
        assertFalse(StartPage.checkEmailIsValidFormat("abc")); // No local part or domain
        assertFalse(StartPage.checkEmailIsValidFormat("fmdf@@")); // Repeated @@
        assertFalse(StartPage.checkEmailIsValidFormat("@ds@")); // No local part
        assertFalse(StartPage.checkEmailIsValidFormat("")); // Empty String
        assertFalse(StartPage.checkEmailIsValidFormat("wadada@ds@g.c")); // 2 @s
        assertFalse(StartPage.checkEmailIsValidFormat("test@dadad3131r2d23 d24fver .dwed12xwfw")); //Spaces in domain
        assertTrue(StartPage.checkEmailIsValidFormat("testfdfdfd@email.com")); // Valid Email
    }
}
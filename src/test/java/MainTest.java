import org.junit.jupiter.api.Assertions;

public class MainTest {
    @org.junit.Test
    void hcf() {
        // Test 1
        int[] numbers = { 12, 18, 24 };
        int expected = 6;
        int actual = Main.hcf(numbers);
        Assertions.assertEquals(expected, actual);
    }
}

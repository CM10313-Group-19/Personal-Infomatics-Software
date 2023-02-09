import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void HCF() {
        assertEquals(1, Main.HCF(1, 1, 1));
        assertEquals(1, Main.HCF(2, 3, 4));
        assertEquals(2, Main.HCF(2, 4, 6));
        assertEquals(6, Main.HCF(6, 18, 24));
    }
}
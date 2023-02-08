import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void hcf() {
        assertEquals(2, Main.hcf(2, 4, 6, 8));
        assertEquals(1, Main.hcf(3, 5, 7, 9));
        assertEquals(2, Main.hcf(2, 4, 6));
        assertEquals(3, Main.hcf(3, 9, 15, 27));
    }
}
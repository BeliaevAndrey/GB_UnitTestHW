package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMainHW {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n,
    // чётным (true) либо нечётным (false).

    @Test
    public void testEvenOddNumberEven() {
        assertTrue(mainHW.evenOddNumber(42));
    }

    @Test
    public void testEvenOddNumberOdd() {
        assertFalse(mainHW.evenOddNumber(17));
    }

    @Test
    public void testEvenOddNumberEvenNegative() {
        assertTrue(mainHW.evenOddNumber(-42));
    }

    @Test
    public void testEvenOddNumberOddNegative() {
        assertFalse(mainHW.evenOddNumber(-17));
    }

    @Test
    public void testEvenOddNumberZero() {
        assertTrue(mainHW.evenOddNumber(0));
    }

}

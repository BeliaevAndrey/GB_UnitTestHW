package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

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

    // HW 3.2. Нужно написать метод, который проверяет, попадает ли переданное
    // число в интервал (25;100) и возвращает true, если попадает и
    // false - если нет,
    // покрыть тестами метод на 100%
    @ParameterizedTest
    @ValueSource(ints = {-99, 0, 25, 100, 101})
    void testNumberInIntervalFalse(int n) {
        assertFalse(mainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 99})
    void testNumberInIntervalTrue(int n) {
        assertTrue(mainHW.numberInInterval(n));
    }

    @ParameterizedTest
    @CsvSource(value = {"26, 99"})
    void testNumbersInIntervalTrueMultipleSuccess(int start, int end) {
        int[] testArr = new int[end - start + 1];

        for (int i = 0; i < testArr.length ; i++)
            testArr[i] = start + i;


        assertTrue(Arrays.stream(testArr).allMatch(mainHW::numberInInterval));
    }

    @ParameterizedTest
    @CsvSource(value = {"26, 99"})
    void testNumbersInIntervalTrueMultipleFail(int start, int end) {
        int[] testArr = new int[end - start + 1];

        for (int i = 0; i < testArr.length ; i++)
            testArr[i] = start + i;

        testArr[testArr.length - 2] = 100;

        assertFalse(Arrays.stream(testArr).allMatch(mainHW::numberInInterval));
    }


}

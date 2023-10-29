package seminars.six.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MeanValuesCompareTest {

    MeanValuesCompare meanValuesCompare;
    @BeforeEach
    void setUp() {
        meanValuesCompare = new MeanValuesCompare();
    }

    @Test
    void testCompareFirstGreaterSuccess() {
        String expected = "Первый список имеет большее среднее значение";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        String actual = meanValuesCompare.compare(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void testCompareSecondGreaterSuccess() {
        String expected = "Второй список имеет большее среднее значение";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        String actual = meanValuesCompare.compare(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void testCompareMeanValuesEquals() {
        String expected = "Средние значения равны";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 5, 2, 1, 3));
        String actual = meanValuesCompare.compare(first, second);
        assertEquals(expected, actual);
    }

}
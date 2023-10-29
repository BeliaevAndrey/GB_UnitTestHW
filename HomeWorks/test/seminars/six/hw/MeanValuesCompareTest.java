package seminars.six.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MeanValuesCompareTest {

    MeanValuesCompare<Integer> meanIntegerValuesCompare;
    MeanValuesCompare<Double> meanDoubleValuesCompare;
    MeanValuesCompare<Long> meanLongValuesCompare;

    MeanValuesCompare meanValuesCompare;

    @BeforeEach
    void setUp() {
        meanIntegerValuesCompare = new MeanValuesCompare<>();
        meanDoubleValuesCompare = new MeanValuesCompare<>();
        meanLongValuesCompare = new MeanValuesCompare<>();
        meanValuesCompare = new MeanValuesCompare();
    }

    @Test
    void testCompareIntegersFirstGreaterSuccess() {
        String expected = "Первый список имеет большее среднее значение";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        String actual = meanIntegerValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareIntegersSecondGreaterSuccess() {
        String expected = "Второй список имеет большее среднее значение";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));

        String actual = meanIntegerValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareIntegersMeanValuesEquals() {
        String expected = "Средние значения равны";
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 5, 2, 1, 3));

        String actual = meanIntegerValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareLongsFirstGreaterSuccess() {
        String expected = "Первый список имеет большее среднее значение";
        ArrayList<Long> first = new ArrayList<>(Arrays.asList(11L, 12L, 13L, 14L, 15L));
        ArrayList<Long> second = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        String actual = meanLongValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareLongsSecondGreaterSuccess() {
        String expected = "Второй список имеет большее среднее значение";
        ArrayList<Long> first = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        ArrayList<Long> second = new ArrayList<>(Arrays.asList(11L, 12L, 13L, 14L, 15L));

        String actual = meanLongValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareLongsMeanValuesEquals() {
        String expected = "Средние значения равны";
        ArrayList<Long> first = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L));
        ArrayList<Long> second = new ArrayList<>(Arrays.asList(4L, 5L, 2L, 1L, 3L));

        String actual = meanLongValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }


    @Test
    void testCompareDoublesFirstGreaterSuccess() {
        String expected = "Первый список имеет большее среднее значение";
        ArrayList<Double> first = new ArrayList<>(Arrays.asList(11D, 12D, 13D, 14D, 15D));
        ArrayList<Double> second = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 4D, 5D));

        String actual = meanDoubleValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testDoublesCompareSecondGreaterSuccess() {
        String expected = "Второй список имеет большее среднее значение";
        ArrayList<Double> first = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 4D, 5D));
        ArrayList<Double> second = new ArrayList<>(Arrays.asList(11D, 12D, 13D, 14D, 15D));

        String actual = meanDoubleValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testDoublesCompareMeanValuesEquals() {
        String expected = "Средние значения равны";
        ArrayList<Double> first = new ArrayList<>(Arrays.asList(1D, 2D, 3D, 4D, 5D));
        ArrayList<Double> second = new ArrayList<>(Arrays.asList(4D, 5D, 2D, 1D, 3D));

        String actual = meanDoubleValuesCompare.compare(first, second);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareNullPointerExceptionFail() {

        ArrayList<Double> first = null;
        ArrayList<Double> second = new ArrayList<>(Arrays.asList(4D, 5D, 2D, 1D, 3D));

        assertThrows(NullPointerException.class, () -> meanDoubleValuesCompare.compare(first, second));
    }

    @Test
    void testCompareTypeErrorFail() {
        String expected_message = "Нечисловой тип значений";

        ArrayList<String> first = new ArrayList<>(Arrays.asList("14D", "15D", "12D", "11D", "13D"));
        ArrayList<String> second = new ArrayList<>(Arrays.asList("4D", "5D", "2D", "1D", "3D"));

        Exception error = assertThrows(
                IllegalArgumentException.class, () -> meanValuesCompare.compare(first, second));
        assertThat(error).hasMessage(expected_message);
    }

}
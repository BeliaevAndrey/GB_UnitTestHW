package seminars.six.hw;

import java.util.ArrayList;

public class MeanValuesCompare {
    private final String ANSWER_FIRST = "Первый список имеет большее среднее значение";
    private final String ANSWER_SECOND = "Второй список имеет большее среднее значение";
    private final String ANSWER_EQUALS = "Средние значения равны";


    public String compare(ArrayList<Integer> first, ArrayList<Integer> second) {
        double firstMean = getMeanOfList(first);
        double secondMean = getMeanOfList(second);
        double mark = firstMean - secondMean;
        return mark > 0 ? ANSWER_FIRST : mark < 0 ? ANSWER_SECOND : ANSWER_EQUALS;
    }

    double getMeanOfList(ArrayList<Integer> values) {
        double total = 0;
        for (int e : values) {
            total += e;
        }
        total /= values.size();
        return total;
    }
}

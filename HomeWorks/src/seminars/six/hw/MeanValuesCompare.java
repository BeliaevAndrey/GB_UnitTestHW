package seminars.six.hw;

import java.util.ArrayList;

public class MeanValuesCompare<T> {

    private final String ANSWER_FIRST = "Первый список имеет большее среднее значение";
    private final String ANSWER_SECOND = "Второй список имеет большее среднее значение";
    private final String ANSWER_EQUALS = "Средние значения равны";


    public String compare(ArrayList<T> first, ArrayList<T> second) {
        double firstMean = getMeanOfList(first);
        double secondMean = getMeanOfList(second);
        double mark = firstMean - secondMean;
        return mark > 0 ? ANSWER_FIRST : mark < 0 ? ANSWER_SECOND : ANSWER_EQUALS;
    }

    private double getMeanOfList(ArrayList<T> values) {
        double total = 0;
        for (T e : values) {
            if (e instanceof Double)
                total += (double) e;
            else if (e instanceof Integer)
                total += (int) e;
            else if (e instanceof Long)
                total += (long) e;
            else throw new IllegalArgumentException("Нечисловой тип значений");
        }
        total /= values.size();
        return total;
    }
}

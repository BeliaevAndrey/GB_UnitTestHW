package seminars.six.hw;

import java.util.List;

public class MeanValuesCompare<T> {

    private static final String ANSWER_FIRST = "Первый список имеет большее среднее значение";
    private static final String ANSWER_SECOND = "Второй список имеет большее среднее значение";
    private static final String ANSWER_EQUALS = "Средние значения равны";


    public String compare(List<T> first, List<T> second) {
        if (first.isEmpty() || second.isEmpty()) throw new IllegalArgumentException("Передан пустой список");
        double firstMean = getMeanOfList(first);
        double secondMean = getMeanOfList(second);
        double mark = firstMean - secondMean;
        if (mark == 0) return ANSWER_EQUALS;
        return mark > 0 ? ANSWER_FIRST : ANSWER_SECOND;
    }

    private double getMeanOfList(List<T> values) {
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

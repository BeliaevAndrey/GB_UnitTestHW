package seminars.five.number;

import java.util.List;

public class MaxNumberModule {
    public int getMax(List<Integer> numList){
        return numList.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
    }
}

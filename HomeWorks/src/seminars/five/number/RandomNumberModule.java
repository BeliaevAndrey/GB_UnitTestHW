package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {

    public List<Integer> getRandList(int len) {
        List<Integer> numList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < len; i++) {
            numList.add(rnd.nextInt());
        }
        return numList;
    }

}

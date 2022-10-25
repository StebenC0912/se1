package week4_TranKhacLinh_2001040121;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomNums {
    
    public static int RandomNumberInRange(int min, int max){
        int random = min + (int)(Math.random() * ((max - min) + 1));
        return random;
    }
    public static void RandomNums(){
        ArrayList<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomList.add(RandomNumberInRange(0, 101));
        }
        Iterator<Integer> random = randomList.iterator();
        while (random.hasNext()) {
            System.out.println(random.next());
        }
    }
    public static void main(String[] args) {
        RandomNums();
    }
}

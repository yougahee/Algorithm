package Algorithm.test_utc;

import java.util.HashMap;
import java.util.HashSet;

public class test1 {
    public static void main(String[] args) {

    }

    public int solution(String[] grades, int[] weights, int threshold) {
        int answer = 0;
        HashMap<String, Integer> set = new HashMap<>();

        set.put("A+", 10);
        set.put("A0", 9);
        set.put("B+", 8);
        set.put("B0", 7);
        set.put("C+", 6);
        set.put("C0", 5);
        set.put("D+", 4);
        set.put("D0", 3);
        set.put("F", 0);

        for(int i=0; i<grades.length; i++) {
            answer += set.get(grades[i]) * weights[i];
        }

        return answer- threshold;
    }


}

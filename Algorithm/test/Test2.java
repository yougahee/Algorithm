package Algorithm.test;

import java.util.Arrays;
import java.util.HashMap;

public class Test2 {

    public static void main(String[] args) {
        String[] s = {"abc", "bca", "dbe"};
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String[] S) {
        int[] result = new int[3];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        boolean isTrue = false;

        loop:
        for(int i=0; i < S[0].length(); i++) {
            hashMap.clear();
            for(int j=0; j<S.length; j++) {
                char temp = S[j].charAt(i);
                if(!hashMap.containsKey(temp)) {
                    hashMap.put(temp, j);
                }else {
                    isTrue = true;
                    result[0] = hashMap.get(temp);
                    result[1] = j;
                    result[2] = i;
                    break loop;
                }
            }
        }

        if(!isTrue) {
            result = new int[0];
            return result;
        }

        return result;
    }
}

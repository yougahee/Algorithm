package Algorithm.kakao;

import java.util.Arrays;
import java.util.HashSet;

public class Solution3 {

    public static void main(String[] args) {

        String[] numbers = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        ProblemSolve3 problemSolve3 = new ProblemSolve3();

        int[] arr = problemSolve3.solution(numbers);
        System.out.println(Arrays.toString(arr));

    }
}

class ProblemSolve3 {

    public int[] solution(String[] gems) {
        int[] answer = {1,1};

        HashSet<String> hashSet = new HashSet<>();

        int min = Integer.MAX_VALUE;
        HashSet<String> addhashset = new HashSet<>();

        for(int i=0; i<gems.length; i++) {
            hashSet.add(gems[i]);
        }

        int num = hashSet.size();

        if(num == 1)
            return answer;
        if(num == gems.length) {
            answer[1] = num;
            return answer;
        }

        for(int i=0; i<gems.length; i++) {
            addhashset.clear();
            for(int j=i; j<gems.length; j++) {
                addhashset.add(gems[j]);
                if(addhashset.size() == num && min > j-i) {
                    min = j-i;
                    answer[0] = i+1;
                    answer[1] = j+1;
                }
            }
        }



        return answer;
    }
}
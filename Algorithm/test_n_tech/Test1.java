package Algorithm.test_n_tech;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        int[][] flowers = {{2, 5}, {3, 7}, {10, 11}};

        System.out.println(solution(flowers));
    }

    public static int solution(int[][] flowers) {
        int answer = 0;

        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        int start, end, date = 1;
        for(int i=0; i<flowers.length; i++) {
           // System.out.println(flowers[i][0]);

            start = flowers[i][0];
            end = flowers[i][1];


            if(date > start) {
                if(end < date)
                    continue;
                answer += end - date;
            }else {
                answer += end - start;
            }
            date = end;
        }


        return answer;
    }


}

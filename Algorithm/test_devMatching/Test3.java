package Algorithm.test_devMatching;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {
    public static void main(String[] args) {

        int[][] map = {{1, 5},{2, 7},{4, 8},{3, 6}};
        int[] arr = {};
        String[] orders = {"XYZ", "XWY", "WXA"};

        int[][] map1 = {{1, 50},{1, 100},{51, 100}};
        int[][] map2 = {{6,7},{1, 4},{2,4}};

        System.out.println(solution(10, map));
        System.out.println(solution(7, map2));
        //System.out.println(solution(100, map1));
    }

    public static int solution(int n, int[][] groups) {
        int answer = 0;
        int start = 0, end = 0;

        Arrays.sort(groups, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int start  = o1[0] - o2[0];

                if(start == 0)
                    return  (o2[1]-o2[0])- (o1[1]-o1[0]) ;
                return start;
            }
        });

        int index = 0;
        start = groups[0][0];
        end = groups[0][1];

        if(start != 1)
            answer += start - 1;

        if( start == 1 && end == n)
            return 1;

        for(int i = 0; i<groups.length; i++) {
            answer++;
            System.out.println("i의 값 : " + i + " start의 값 :  " + start + " end의 값 : " + end);

            for(int j=i+1; j<groups.length; j++) {
                if(end +1 >= groups[j][0] && end < groups[j][1]){
                    i = j-1;
                    end = groups[j][1];
                    System.out.println("index ? " + index + "end ? " + end);
                }
            }
        }

        System.out.println(start + " " + end);

        if(end < n) answer += n - end;
        return answer;
    }
}

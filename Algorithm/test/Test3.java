package Algorithm.test;

import java.util.Arrays;

public class Test3 {

    public static void main(String[] args) {
        int[] s = {6,2,3,5,6,3};
        System.out.println(solution(s));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0, MAXNUM = 1000000000;
        Arrays.sort(A);

        for(int i=1; i<=A.length; i++) {
            if(A[i-1] != i) {
                result += Math.abs(A[i-1] - i);
            }

            if(result > MAXNUM)
                return -1;
        }

        return result;
    }
}

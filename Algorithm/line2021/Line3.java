package Algorithm.line2021;

import java.util.Arrays;

public class Line3 {
    public static void main(String[] args) {

       // System.out.println(Arrays.toString(solution(73425)));

        //System.out.println(Arrays.toString(solution(10007)));

        System.out.println(Arrays.toString(solution(100)));
    }

    static int min = Integer.MAX_VALUE;
    static int num = 0;

    public static int[] solution(int n) {
        int[] answer = new int[2];

        if(Integer.toString(n).length() == 1) {
            answer[0] = 0;
            answer[1] = n;
            return answer;
        }

        singleDigit(n, 1);

        answer[0] = min;
        answer[1] = num;
        return answer;
    }

    public static void singleDigit(int n, int cnt) {

        String nData = Integer.toString(n);
        int result = 0;
        int quotient = 0, remainder =0, zeronum = 0;

        for(int i=1; i<nData.length(); i++) {
            if(nData.charAt(i) == '0' && i < nData.length()-1)
                continue;

            zeronum = zeroNum(nData.length() - i +1);

            quotient = n/zeronum;
            remainder = n%zeronum;

            result = quotient + remainder;

            if(Integer.toString(result).length() == 1) {
                min = Math.min(min, cnt);
                num = result;
            }
            else {
                singleDigit(result, cnt+1);
            }
        }
    }

    public static int zeroNum (int n) {
        int result = 1;
        for(int i=1; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}

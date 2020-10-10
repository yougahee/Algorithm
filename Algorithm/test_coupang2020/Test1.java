package Algorithm.test_coupang2020;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[][] map = {};
        int[] arr = {};
        String[] orders = {"XYZ", "XWY", "WXA"};

        System.out.println(Arrays.toString(solution(10)));
        System.out.println(solution(14));
    }

    static int maxK = 1;
    static int maxMul = 1;
    public static int[] solution(int N) {
        int[] answer = new int[2];

        for(int i = 2; i<10; i++) {
            turnToN(N, i);
        }

        answer[0] = maxK;
        answer[1] = maxMul;

        return answer;
    }

    public static void turnToN(int n, int k) {
        String ans = "";

        while (n > 0) {
            ans =  n%k + ans;
            n = n/k;
        }

        ans = ans.replace("0", "");
        int multi = 1;
        //System.out.println("k : " + k + " ans : " + ans);

        for(int i=0; i<ans.length(); i++) {
            //System.out.println(ans.charAt(i) - '0');
            multi *= ans.charAt(i) - '0';
        }

        if(maxMul <= multi){
            maxK = k;
            maxMul = multi;
        }
    }
}

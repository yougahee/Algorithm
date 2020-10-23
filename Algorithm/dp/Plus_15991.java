package Algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus_15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int DIV_NUM = 1000000009;
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for(int i=4; i<100001; i++) {
            if(i-6 >= 0) dp[i] += dp[i-6] % DIV_NUM;
            dp[i] += (dp[i-2] + dp[i-4])% DIV_NUM ;
        }

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}

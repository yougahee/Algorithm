package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberofEasySteps_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        long[][] dp = new long[N+1][11];

        for(int i=0; i<=9; i++)
            dp[1][i] = 1;


        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0)
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                else if ( j == 9)
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }



        for(int i=1; i<=9; i++) {
            ans = (ans + dp[N][i]) % 1000000000;
        }

        System.out.println(ans);
    }
}

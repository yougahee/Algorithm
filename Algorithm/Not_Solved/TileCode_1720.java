package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileCode_1720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<N; i++){
            if(i%2 == 0) ;
            else dp[i] = dp[i-2]*3;

        }

        System.out.println(dp[N]);
    }
}

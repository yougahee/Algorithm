package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile_1904 {
    public static int dp[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+2];

        System.out.println(tileNum(N));
    }

    public static int tileNum(int num) {

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<num+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }

        return dp[num];

    }
}

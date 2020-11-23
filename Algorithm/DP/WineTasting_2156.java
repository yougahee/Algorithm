package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting_2156 {

    static int[] graphGlass;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graphGlass = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            graphGlass[i] = Integer.parseInt(br.readLine());
        }
        dp();

    }

    public static void dp() {
        dp[0] = graphGlass[0];

        if (n >= 2) {
            dp[1] = dp[0] + graphGlass[1];
        }
        if(n >= 3) {
            dp[2] = Math.max(Math.max(dp[1], dp[0] + graphGlass[2]), graphGlass[1]+graphGlass[2]);
        }


        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i-2] + graphGlass[i], dp[i-1]), dp[i-3]+ graphGlass[i]+ graphGlass[i-1] );
        }

        System.out.println(dp[n-1]);
    }
}

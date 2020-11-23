package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlanKnapsack_12865 {

    static int N;
    static int K;
    static int weight[];
    static int value[];
    static int dp[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        value = new int[N+1];
        dp = new int[N+1][K+1];


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        maxValue();
        System.out.println(dp[N][K]);
    }

    public static void maxValue() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                dp[i][j] = dp[i][j-1];
                if(j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], value[i]+dp[i-1][j-weight[i]]);
                }
            }
        }
    }
}

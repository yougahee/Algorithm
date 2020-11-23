package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        int max = dp[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+dp[i], dp[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}

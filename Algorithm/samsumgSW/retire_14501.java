package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class retire_14501 {

    public static void main(String[] args) throws IOException {

        int N = 0;
        int arrDay[];
        int arrMondey[];
        int dp[];
        int result;
        int cnt;
        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrDay = new int[N+6];
        arrMondey = new int[N+6];
        dp = new int[N+6];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrDay[i] = Integer.parseInt(st.nextToken());
            arrMondey[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N+1; i++) {

            dp[i] = Math.max(dp[i], max);

            dp[arrDay[i] + i] = Math.max(dp[arrDay[i]+i], dp[i]+arrMondey[i]);

            max = Math.max(dp[i], max);

        }
        System.out.println(max);
    }
}

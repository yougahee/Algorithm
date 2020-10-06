package Algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//LIS
public class DeployingSoldiers_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] soldier = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<soldier.length; i++) {
            soldier[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<soldier.length; i++) {
            for(int j= 0; j<i; j++) {
                if(soldier[i] < soldier[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        Arrays.sort(dp);

        System.out.println(N - dp[N-1]);
    }
}

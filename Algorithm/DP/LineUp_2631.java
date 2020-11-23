package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//혼자 해결 X
public class LineUp_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println( N - dp[N-1] );
    }
}

package Algorithm.test_softwaremastro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {

    static int[] orange;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        orange = new int[N];
        dp = new int[N][N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<N; i++) {
            dp[i][0] = dp[0][0];
            for(int j=1; j<N; j++){
                dp[i][j] = dp[i-1][j-1] + dp[0][j];
            }
        }

        //최대값 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);

    }
}

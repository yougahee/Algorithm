package Algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class RGB_1149 {

    static int N;
    static int dp[][];
    static int price[][];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());

        price = new int[N][3];
        dp = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());

        }
        dp();
        System.out.println(min);
    }

    public static void dp() {

        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = min(price[i][j] + dp[i-1][1], price[i][j] + dp[i-1][2]);
                        break;
                    case 1:
                        dp[i][j] = min(price[i][j] + dp[i-1][0], price[i][j] + dp[i-1][2]);
                        break;
                    case 2:
                        dp[i][j] = min(price[i][j] + dp[i-1][0], price[i][j] + dp[i-1][1]);
                        break;
                }
            }
        }

        min = min(dp[N-1][0], dp[N-1][1]);
        min = min(min, dp[N-1][2]);

    }
}

package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DownHill_1520 {

    static int N, M;
    static long ans;

    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new long[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = findPath(0,0);
        System.out.println("=====");
        print();
        System.out.println(ans);

    }

    public static long findPath(int x, int y) {
        System.out.println("x : " + x + " y : " + y + " dp : " + dp[x][y] + " ans : " + ans);
        print();
        if(x == N-1 && y == M-1) {
            return 1;
        }

        int prev = map[x][y];
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx <0 || ny <0 || nx >= N || ny >= M) continue;
            if(prev <= map[nx][ny]) continue;
            if(dp[nx][ny] != 0) {
                ans += dp[nx][ny];
                return dp[nx][ny] + 1;
            }
            dp[x][y] += findPath(nx, ny);
        }

        return dp[x][y];
    }

    public static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }
}

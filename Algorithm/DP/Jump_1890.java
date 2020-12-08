package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jump_1890 {

    static int[][] game;
    static long[][] dp;
    static boolean[][] visited;

    static int N;

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        game = new int[N][N];
        dp = new long[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long answer = DFS(0,0);
        System.out.println(answer);
    }

    static long DFS(int x, int y) {
        if(x == N-1 && y == N-1) return 1;
        if(visited[x][y]) return dp[x][y];
        if(game[x][y] == 0) return 0;

        long cnt = 0;
        for(int i=0; i<2; i++) {
            int nx = dx[i]*game[x][y] + x;
            int ny = dy[i]*game[x][y] + y;

            if(nx >= N || ny >= N ) continue;
            cnt += DFS(nx, ny);
        }

        visited[x][y] = true;
        return dp[x][y] = cnt;
    }

    static void print() {
        System.out.println("===============");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

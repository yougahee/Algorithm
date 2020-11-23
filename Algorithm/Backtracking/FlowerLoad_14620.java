package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlowerLoad_14620 {
    static boolean[][] visited;
    static int[][] flower;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n, cost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        flower = new int[n][n];
        visited = new boolean[11][11];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                flower[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0, 0, 0);

        System.out.println(cost);
    }

    public static void DFS(int x, int y, int depth, int cnt) {

        if (depth == 3) {
            cost = Math.min(cost, cnt);
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = (i == x ? y : 0); j < n; j++) {
                boolean nxt = !visited[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) nxt = false;
                    else if (visited[nx][ny]) nxt = false;
                }
                if (!nxt) continue;

                //꽃이 된 부분
                visited[i][j] = true;
                cnt += flower[i][j];
                for (int h = 0; h < 4; h++) {
                    int hx = i + dx[h];
                    int hy = j + dy[h];
                    visited[hx][hy] = true;
                    cnt += flower[hx][hy];
                }

                DFS(i, j+1, depth + 1, cnt);

                //다시 제거
                visited[i][j] = false;
                cnt -= flower[i][j];
                for (int h = 0; h < 4; h++) {
                    int hx = i + dx[h];
                    int hy = j + dy[h];
                    visited[hx][hy] = false;
                    cnt -= flower[hx][hy];
                }
            }
        }
    }

}

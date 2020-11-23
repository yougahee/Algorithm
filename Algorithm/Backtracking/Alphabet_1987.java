package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet_1987 {

    static int max = 1;
    static int[][] alpha;
    static boolean[] used;
    static boolean[][] visited;

    static int r, c;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alpha = new int[r][c];
        used = new boolean[26];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String inputString = br.readLine();

            for (int j = 0; j < inputString.length(); j++) {
                alpha[i][j] = inputString.charAt(j) - 'A';
            }
        }

        visited[0][0] = true;
        DFS(0, 0, 1);
        System.out.println(max);
    }

    public static void DFS(int x, int y, int cnt) {

        max = Math.max(max, cnt);
        used[alpha[x][y]] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {

                if (used[alpha[nx][ny]])
                    continue;


                visited[nx][ny] = true;
                DFS(nx, ny, cnt + 1);
                visited[nx][ny] = false;
            }
        }

        used[alpha[x][y]] = false;
    }
}

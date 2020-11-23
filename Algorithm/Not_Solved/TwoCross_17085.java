package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoCross_17085 {

    static int n, m, result = 1;
    static char[][] map;
    static int[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //십자가가 있는지 확인하는 작업
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '#' && visited[i][j] == 0) {

                    isCrossSize(i, j);
                }
            }
        }


        System.out.println(result);
    }

    public static void isCrossSize(int x, int y) {
        while (true) {

            int len = 1;

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] * len + x;
                int ny = dy[k] * len + y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '#' && visited[nx][ny] == 0) {
                    continue;
                } else {

                }

            }


            setVisited(x, y);
        }
    }

    public static void setVisited(int x, int y) {

        for (int i = 0; i > 0; i--) {
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] * i + x;
                int ny = dy[k] * i + y;

                visited[nx][ny] = 1;
            }
        }
    }
}

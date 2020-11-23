package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class iceberg_2573 {
    static int n, m;
    static int[][] ice, visited;
    static int cnt = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ice = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            int areaNum = areaNum();
            /*System.out.println("=================처음!");
            printArr();
*/
            //할때마다 visited 초기화 시켜야겠다.
            visited = new int[n][m];

            if (areaNum == 0) {
                System.out.println(0);
                return;
            } else if (areaNum == 1) {
                iceMelting();
//                System.out.println("=================멜팅!");
//                printArr();
            } else {
                System.out.println(cnt);
                return;
            }

            cnt++;
        }
    }

    public static void iceMelting() {

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (ice[i][j] != 0) {
                    //상하좌우의 0의개수
                    int zero_cnt = 0;
                    visited[i][j] = 1;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (ice[nx][ny] == 0 && visited[nx][ny] == 0)
                            zero_cnt++;
                    }

                    if (ice[i][j] - zero_cnt < 0)
                        ice[i][j] = 0;
                    else
                        ice[i][j] -= zero_cnt;
                }
            }
        }
    }

    //분리되는 지역이 몇개인지?!
    public static int areaNum() {
        int area_cnt = 0;
        int[][] area_visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ice[i][j] != 0 && area_visited[i][j] == 0) {
                    area_cnt++;
                    area_visited[i][j] = 1;
                    DFS(i, j, area_visited);
                }
            }
        }

        return area_cnt;
    }

    public static void DFS(int x, int y, int[][] area_visited) {

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (ice[nx][ny] != 0 && area_visited[nx][ny] == 0) {
                area_visited[nx][ny] = 1;
                DFS(nx, ny, area_visited);
            }
        }
    }


    public static void printArr() {

        System.out.println("================");

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(ice[j][k]);
            }
            System.out.println();
        }

        System.out.println("================");
    }
}


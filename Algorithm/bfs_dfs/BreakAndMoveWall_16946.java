package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//플러드 필 알고리즘
public class BreakAndMoveWall_16946 {

    static int n, m, cnt;
    static int[][] map, visited;
    static HashSet<pair> set;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //0인 곳에 연결되어 있는 것의 수를 적기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == 0 && visited[i][j] == 0) {
                    set = new HashSet<>();
                    cnt =0;
                    set.add(new pair(i,j));
                    visited[i][j] = 1;
                    DFS(i, j);
                    //System.out.println("여기서 cnt 의 값이 ? " + cnt);
                    visitedCnt(cnt);
                }
            }
        }

        //동서남북 보기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int result_cnt =0;

                if( map[i][j] == 1 ){
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                            //System.out.println("visi " + visited[nx][ny]);
                            result_cnt += visited[nx][ny];
                            //System.out.println("cnt " + result_cnt);
                        }
                    }
                }

                map[i][j] += result_cnt;
            }
        }

        printArr();
    }

    public static void DFS(int x, int y) {

        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //System.out.println(nx + "  " + ny);

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                visited[nx][ny] = 1;
                set.add(new pair(nx, ny));
//                System.out.println("emfdj");
//
//                for(pair a : set) {
//                    visited[a.x][a.y] = cnt;
//
//                    System.out.println("이 visited 값은 ? " + visited[a.x][a.y]);
//                }

                DFS(nx, ny);
            }
        }
    }

    public static void visitedCnt(int cnt) {

        //System.out.println("함수에서 cnt 의 값이 ? " + cnt);

        for(pair a : set) {
            visited[a.x][a.y] = cnt;

            //System.out.println("이 visited 값은 ? " + visited[a.x][a.y]);
        }
    }

    static class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void printArr() {

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                System.out.print(map[j][k]);
            }
            System.out.println();
        }
    }

}

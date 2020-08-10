package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MonkeyButNotHorse_1600 {

    static int k;
    static int w, h;

    static int[][] plate;
    static int[][][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[] hx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int cnt = 0;
    static boolean success;

    static Queue<pair> monkeyMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        plate = new int[h][w];
        visited = new int[h][w][k + 1];
        monkeyMove = new LinkedList<>();


        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        monkeyMove.add(new pair(0, 0, k));
        plate[0][0] = 1;
        visited[0][0][k] = 1;
        success = false;

        BFS();
    }

    public static void BFS() {
        pair monkeyloc;

        loop: while (!monkeyMove.isEmpty()) {
            monkeyloc = monkeyMove.poll();
            int x = monkeyloc.x;
            int y = monkeyloc.y;

            if (x == h - 1 && y == w - 1) {
                success = true;
                cnt = visited[x][y][monkeyloc.horse];
                break loop;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && plate[nx][ny] == 0 && visited[nx][ny][monkeyloc.horse] == 0) {
                    visited[nx][ny][monkeyloc.horse] = visited[x][y][monkeyloc.horse] + 1;
                    monkeyMove.add(new pair(nx, ny, monkeyloc.horse));
                }
            }

            //능력을 사용할 수 있는 경우
            if (monkeyloc.horse > 0) {
                for (int i = 0; i < 8; i++) {
                    int kx = x + hx[i];
                    int ky = y + hy[i];

                    if (kx >= 0 && kx < h && ky >= 0 && ky < w && plate[kx][ky] == 0 && visited[kx][ky][monkeyloc.horse - 1] == 0) {
                        visited[kx][ky][monkeyloc.horse - 1] = visited[x][y][monkeyloc.horse] + 1;
                        monkeyMove.add(new pair(kx, ky, monkeyloc.horse - 1));
                    }
                }
            }
        }
        System.out.println(success ? cnt - 1 : -1);
    }

    static class pair {
        int x;
        int y;
        int horse;

        public pair(int x, int y, int horse) {
            this.x = x;
            this.y = y;
            this.horse = horse;
        }
    }
}



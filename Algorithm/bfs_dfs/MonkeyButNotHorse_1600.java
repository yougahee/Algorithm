package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MonkeyButNotHorse_1600 {

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

    static int k;
    static int w, h;

    static int[][] plate;
    static int[][][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[] hx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int h_cnt = 0, cnt=0;
    static boolean success;

    static Queue<pair> monkeyMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        plate = new int[w][h];
        visited = new int[w][h][];
        monkeyMove = new LinkedList<>();


        for (int i = 0; i < w ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < h; j++) {
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        monkeyMove.add(new pair(0, 0,0));
        plate[0][0] = 1;
        visited[0][0][0] = 1;
        success = false;

        BFS();
    }

    public static void BFS() {
        pair monkeyloc;

        while (!monkeyMove.isEmpty()) {
            monkeyloc = monkeyMove.poll();
            int x = monkeyloc.x;
            int y = monkeyloc.y;

            //능력을 사용할 수 있는 경우
            if (h_cnt < k) {
                for (int i = 0; i < 8; i++) {
                    int kx = x + hx[i];
                    int ky = y + hy[i];

                    if (kx >= 0 && kx < w && ky >= 0 && ky < h && plate[kx][ky] == 0 && visited[kx][ky] == 0) {
                        if(kx == w-1 && ky == h-1) {
                            success = true;
                            cnt = visited[x][y];
                            //System.out.println("Escaped in " + (visited[loc.x][loc.y][loc.z]) +" minute(s).");
                            break;
                        }
                        plate[kx][ky] = 1;
                        visited[kx][ky] = visited[x][y] + 1;
                        monkeyMove.add(new pair(kx, ky));
                        h_cnt++;
                    }

                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < w && ny >= 0 && ny < h && plate[nx][ny] == 0 && visited[nx][ny] == 0) {

                    if(nx == w-1 && ny == h-1) {
                        success = true;
                        cnt = visited[x][y];
                        //System.out.println("Escaped in " + (visited[loc.x][loc.y][loc.z]) +" minute(s).");
                        break;
                    }

                    plate[nx][ny] = 1;
                    visited[nx][ny] = visited[x][y] + 1;
                    monkeyMove.add(new pair(nx, ny));
                }
            }
        }

        if(success) {
            System.out.println(cnt);
        }else{
            System.out.println(-1);
        }


    }
}

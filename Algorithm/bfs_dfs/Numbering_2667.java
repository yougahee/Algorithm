package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Numbering_2667 {

    static int N;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static ArrayList<Integer> array = new ArrayList<>();
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        //판별
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    cnt=0;

                    DFS(i, j);

                    pq.add(cnt);
                }
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void DFS(int x, int y) {
        map[x][y]=0;
        cnt++;

        for (int i = 0; i < 4; i++) {
            //x,y의 상하좌우 보기
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위에 안에 있으면!
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (map[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }

        }
    }
}

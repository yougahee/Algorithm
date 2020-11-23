package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab_14502 {

    static int N, M, answer = 0;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        DFS(lab, visited, 0);

        System.out.println(answer);
    }

    public static void DFS(int[][] copyLab, boolean[][] visited, int cnt) {
        if(cnt == 3) {
            int[][] copy = new int[N][M];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    copy[i][j] = copyLab[i][j];
                }
            }

            answer = Math.max(answer, spreadVirus(copy));
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(copyLab[i][j] == 0 && !visited[i][j]) {
                    copyLab[i][j] = 1;
                    visited[i][j] = true;
                    DFS(copyLab, visited, cnt+1);
                    copyLab[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static int spreadVirus(int[][] area) {
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + pair.x;
                int ny = dy[k] + pair.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (area[nx][ny] != 0) continue;

                queue.add(new Pair(nx, ny));
                area[nx][ny] = 2;
            }
        }

        return safeArea(area);
    }

    public static int safeArea(int[][] area) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

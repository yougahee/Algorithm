package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingWallsAndMoving_2206 {

    static int answer = Integer.MAX_VALUE;
    static int N, M;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[1000][1000];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        BFS();

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void BFS() {
        boolean[][][] visited = new boolean[1000][1000][2];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0,0,1));
        visited[0][0][0] = visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if(p.x == N-1 && p.y == M-1) {
                answer = p.cnt;
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                int z = p.z;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny][z]) continue;

                if(z == 1 && map[nx][ny] == 1) continue;
                if(z == 0 && map[nx][ny] == 1) {
                    if(visited[nx][ny][1]) continue;
                    z = 1;
                }

                visited[nx][ny][z] = true;
                queue.add(new Pair(nx, ny, z, p.cnt+1));
            }
        }
    }

    static class Pair {
        int x,y,z,cnt;

        public Pair(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
}

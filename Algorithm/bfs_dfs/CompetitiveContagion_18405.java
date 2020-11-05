package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CompetitiveContagion_18405 {

    static int N;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;
        int Y = Integer.parseInt(st.nextToken())-1;

        loop:
        for(int i=0; i<S; i++) {
            for(int j=0; j<K; j++) {
                map = BFS(map, j+1);

                if(map[X][Y] != 0) break loop;
            }
        }

        System.out.println(map[X][Y]);
    }

    public static int[][] BFS(int[][] map, int virus) {
        int[][] copyMap = new int[N][N];
        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                copyMap[i][j] = map[i][j];

                if(copyMap[i][j] == virus) queue.add(new Pair(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Pair qu = queue.poll();

            for(int k=0; k<4; k++) {
                int nx = qu.x + dx[k];
                int ny = qu.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N ) continue;
                if(map[nx][ny] != 0) continue;

                copyMap[nx][ny] = virus;
            }
        }

        return copyMap;
    }

    static class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

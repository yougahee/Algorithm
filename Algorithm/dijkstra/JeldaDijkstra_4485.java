package Algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JeldaDijkstra_4485 {

    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) return;

            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("Problem " + cnt + ": " + Dijkstra(arr[0][0], arr));
            cnt++;
        }
    }

    static int Dijkstra(int start, int[][] arr) {
        boolean[][] isVisited = new boolean[N][N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0, start));

        while (!pq.isEmpty()) {
            Pair rupi = pq.poll();

            if(rupi.x == N-1 && rupi.y == N-1) return rupi.sum;

            for(int i=0; i<4; i++) {
                int nx = dx[i] + rupi.x;
                int ny = dy[i] + rupi.y;

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;
                pq.add(new Pair(nx, ny, rupi.sum + arr[nx][ny]));
            }
        }

        return 0;
    }

    static class Pair implements Comparable<Pair> {
        int x,y, sum;

        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }
}

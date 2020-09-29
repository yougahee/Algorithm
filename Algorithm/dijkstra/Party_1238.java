package Algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Party_1238 {

    static class pair implements Comparable<pair>{
        int index;
        int time;

        public pair(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(pair o) {
            return this.time - o.time;
        }
    }

    static int N,M,X;
    static boolean[] isChecked;
    static int[][] dist;

    static PriorityQueue<pair> pq;
    static ArrayList<pair>[] load;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a,b,t, max = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        load = new ArrayList[N+1];
        dist = new int[N+1][N+1];

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=1; i<N+1; i++) {
            load[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            load[a].add(new pair(b, t));
        }

        for(int i=1; i<N+1; i++) {
            dist[i][i] = 0;
            isChecked = new boolean[N+1];

            Dijkstra(i);
        }

        for(int i=1; i<=N; i++) {
            int distance = dist[i][X] + dist[X][i];

            max = Math.max(distance, max);
        }

        System.out.println(max);

    }

    public static void Dijkstra(int start) {
        pq.add(new pair(start, 0));
        int index, next, time;

        while (!pq.isEmpty()) {
            pair temp = pq.poll();
            index = temp.index;

            if(!isChecked[index]) {
                for(int i=0; i<load[index].size(); i++) {
                    next = load[index].get(i).index;
                    time = load[index].get(i).time;

                    dist[start][next] = Math.min(dist[start][next], dist[start][index]+time);
                    pq.add(new pair(next, dist[start][next]));
                }
            }
            isChecked[index] =true;
        }
    }
}

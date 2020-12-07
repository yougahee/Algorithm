package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpecificShortestPath_1504 {

    static int N, v1, v2;
    static ArrayList<Pair>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E;
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int min = result();
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static int result() {
        int min1, min2;

        int a, b, c, d, e;
        a = Dijkstra(v1, v2);

        if( a == -1 ) return Integer.MAX_VALUE;

        b = Dijkstra(1, v1);
        c = Dijkstra(v2, N);
        d = Dijkstra(1, v2);
        e = Dijkstra(v1, N);

        if( b == -1 || c == -1) min1 = Integer.MAX_VALUE;
        else min1 = a + b + c;

        if( d == -1 || e == -1) min2 = Integer.MAX_VALUE;
        else min2 = a + d + e;

        return Math.min(min1, min2);
    }


    static int Dijkstra(int s, int e) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Pair(s, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.next == e) return p.w;
            if(visited[p.next]) continue;
            visited[p.next] = true;

            for (int i = 0; i < graph[p.next].size(); i++) {
                Pair nextP = graph[p.next].get(i);
                pq.add(new Pair(nextP.next, p.w + nextP.w));
            }
        }
        return -1;
    }

    static class Pair {
        int next, w;

        Pair(int n, int w) {
            this.next = n;
            this.w = w;
        }
    }
}

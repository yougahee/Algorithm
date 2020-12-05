package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        ArrayList<Pair>[] graph = new ArrayList[V+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int u,v,w;
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[u].add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        pq.add(new Pair(K, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if(visited[p.i]) continue;

            for(int i=0; i<graph[p.i].size(); i++) {
                int next = graph[p.i].get(i).i;
                int weight = graph[p.i].get(i).w;

                if(dist[next] > dist[p.i] + weight) {
                    dist[next] = dist[p.i] + weight;
                    pq.add(new Pair(next, dist[next]));
                }
            }
            visited[p.i] = true;
        }

        for (int i = 1; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static class Pair{
        int i, w;

        Pair(int i, int w) {
            this.i = i;
            this.w = w;
        }
    }
}

package Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath_1753 {
    static class pair implements Comparable<pair>{
        int index;
        int weight;

        public pair(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(pair o) {
            return this.weight - o.weight;
        }
    }

    static boolean[] isChecked;
    static int[] dist;
    static PriorityQueue<pair> pq;
    static ArrayList<pair>[] array;

    static int V,E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a,b, w, start;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        isChecked = new boolean[V+1];
        pq = new PriorityQueue<>();

        for(int i=1; i<V+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        array = new ArrayList[V+1];

        for(int i=1; i<V+1; i++) {
            array[i] = new ArrayList<>();
        }

        //입력
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            array[a].add(new pair(b, w));
        }

        Dijkstra(start);

        for(int i=1; i<V+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else
                System.out.println(dist[i]);
        }

    }


    static public void Dijkstra(int start) {
        dist[start] = 0;
        pq.add(new pair(start, 0));

        int next;

        while (!pq.isEmpty()) {
            pair temp = pq.poll();
            next = temp.index;

            if(!isChecked[next]) {
                for(int i=0; i<array[next].size(); i++ ) {
                    int index = array[next].get(i).index;
                    int w = array[next].get(i).weight;

                    dist[index] = Math.min(dist[next] + w, dist[index]);
                    pq.add(new pair(index, dist[index]));
                }
            }
            isChecked[next] =true;
        }
    }
}

package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindingTheMinimumCost_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Pair>[] bus = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<bus.length; i++) {
            bus[i] = new ArrayList<>();
        }

        int a,b,c;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            bus[a].add(new Pair(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if(p.p == e) {
                System.out.println(p.w);
                return;
            }

            if(visited[p.p]) continue;

            for(int i=0; i<bus[p.p].size(); i++) {
                Pair next = bus[p.p].get(i);
                pq.add(new Pair(next.p, p.w + next.w));
            }

            visited[p.p] = true;
        }
    }

    static class Pair{
        int p, w;

        Pair(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
}

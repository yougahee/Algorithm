package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlmostShortestPath_5719 {

    static int N, M, S, D;
    static int[][] road;

    static int[] node;

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) return;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            road = new int[N][N];
            min = Integer.MAX_VALUE;
            node = new int[N];

            int u, v, p;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                road[u][v] = p;
            }

            Arrays.fill(node, Integer.MAX_VALUE);
            Dijkstra();

            //역추적
            BackDijkstra();

            Arrays.fill(node, Integer.MAX_VALUE);
            System.out.println(Dijkstra());
        }
    }

    static int Dijkstra() {
        PriorityQueue<Navigation> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Navigation(S, 0));
        node[S] = 0;

        while (!pq.isEmpty()) {
            Navigation navi = pq.poll();
            int curNode = navi.s, curWeight = navi.weight;

            if (curNode == D) {
                node[curNode] = curWeight;
                return curWeight;
            }

            for (int i = 0; i < N; i++) {
                if ( road[navi.s][i] <= 0 ) continue;
                if( navi.weight + road[curNode][i] >= node[i]) continue;

                node[i] = curWeight + road[curNode][i];
                pq.add(new Navigation(i, node[i]));
                //System.out.println("start : " + curNode + " i : " + i + " node 최소값 : " + node[i] );
            }
        }

        return -1;
    }

    //최소경로인 것 다 지워버리기
    static void BackDijkstra() {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(D);

        while (!qu.isEmpty()) {
            Integer index = qu.poll();

            for (int i = 0; i < N; i++) {
                if ( road[i][index] <= 0 ) continue;
                if( node[i] == Integer.MAX_VALUE ) continue;
                if( node[i] + road[i][index] != node[index]) continue;

                road[i][index] = -1;
                qu.add(i);
            }
        }
    }

    static class Navigation {
        int s, weight;

        public Navigation(int s, int weight) {
            this.s = s;
            this.weight = weight;
        }
    }
}

package Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek_6118 {

    static int[] dist;
    static boolean[] isChecked;
    static ArrayList<Integer>[] list;
    static PriorityQueue<pair> priorityQueue;

    static int N, max_dist;
    static int max = Integer.MIN_VALUE;

    public static class pair implements Comparable<pair>{
        int index, distance;

        pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(pair o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a, b, cnt = 1;

        dist = new int[N + 1];
        isChecked = new boolean[N + 1];
        list = new ArrayList[N + 1];
        priorityQueue = new PriorityQueue<>();

        for (int i = 2; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //왜 int 2차원 배열로 사용하지 않고 ArrayList를 사용하는가?
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Dijkstra();

        for (int i = 2; i < dist.length; i++) {
            if(max < dist[i]) {
                max = dist[i];
                max_dist = i;
                cnt = 1;
            }
            else if (dist[i] == max)
                cnt++;
        }

        System.out.println(max_dist + " " + max + " " + cnt);
    }

    public static void Dijkstra() {
        priorityQueue.add(new pair(1, 0));

        while (!priorityQueue.isEmpty()) {
            pair temp = priorityQueue.poll();

            int index = temp.index;
            int distance = temp.distance;

            if (!isChecked[index]) {
                for (int i = 0; i < list[index].size(); i++) {
                    int next = list[index].get(i);

                    dist[next] = Math.min(dist[next], distance + 1);
                    priorityQueue.add(new pair(next, dist[next]));
                }
            }
            isChecked[index] = true;
        }
    }
}

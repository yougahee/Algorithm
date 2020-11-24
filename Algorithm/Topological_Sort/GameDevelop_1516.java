package Algorithm.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameDevelop_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] building = new int[N][2];
        int[] result = new int[N];

        ArrayList<Integer>[] arr = new ArrayList[N];
        Queue<BuiltTime> queue = new LinkedList();
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();

        int time, node, prev;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            time = Integer.parseInt(st.nextToken());
            building[i][1] = time;

            prev = i;
            while (true) {
                node = Integer.parseInt(st.nextToken());
                if (node == -1) break;

                building[node-1][0]++;
                arr[node-1].add(prev);
                prev = node-1;
            }
        }


        for(int i=0; i<N; i++) {
            if (building[i][0] == 0) queue.add(new BuiltTime(i, building[i][1]));
        }

        for(int i=0; i<N; i++) {
            //이러면 위상정렬이 안만들어지긴 하는데,
            //여기서는 각자가 만드는 것의 최소값을 구하면 되서 이 처리를 따로 안해줘도 되는 건가?
            if(queue.isEmpty()) {
                break;
            }

            BuiltTime b = queue.poll();
            for(int j : arr[b.node]) {
                if(--building[j][0] == 0) {
                    building[j][1] += b.time;
                }
            }
        }


        for(int i=0; i<N; i++)
            System.out.println(building[i][1]);

    }

    static class BuiltTime {
        int node, time;

        public BuiltTime(int x, int y) {
            this.node = x;
            this.time = y;
        }
    }
}

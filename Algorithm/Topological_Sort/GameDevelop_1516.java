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
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();

        int time, node;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            time = Integer.parseInt(st.nextToken());
            building[i][1] = time;

            while (true) {
                node = Integer.parseInt(st.nextToken());
                if (node == -1) break;

                building[i][0]++;
                arr[node-1].add(i);
            }

            if (building[i][0] == 0) {
                result[i] = building[i][1];
                queue.add(i);
            }
        }

        for(int i=0; i<N; i++) {
            if(queue.isEmpty()) break;

            int b = queue.poll();
            for(int j : arr[b]) {
                result[j] = Math.max(result[j], building[j][1] + result[b]);
                if(--building[j][0] == 0) {
                    queue.add(j);
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.println(result[i]);
        }
    }
}

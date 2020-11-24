package Algorithm.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MusicProgram_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] node = new int[N];
        int[] result = new int[N];
        ArrayList<Integer>[] arr = new ArrayList[N];
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();

        int s, prev, next;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            if(s == 0) continue;

            prev = Integer.parseInt(st.nextToken());
            for(int j=1; j<s; j++){
                next = Integer.parseInt(st.nextToken());

                node[next-1]++;
                arr[prev-1].add(next-1);
                prev = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            if(node[i] == 0) queue.add(i);
        }

        for(int i=0; i<N; i++) {
            if(queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            int index = queue.poll();
            result[i] = index+1;

            for(int value : arr[index]) {
                if(--node[value] == 0) queue.add(value);
            }
        }

        for(int i=0; i<N; i++)
            System.out.println(result[i]);
    }
}

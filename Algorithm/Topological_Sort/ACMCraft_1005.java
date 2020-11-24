package Algorithm.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] node = new int[N];
            int[] time = new int[N];
            int[] result = new int[N];
            ArrayList<Integer>[] arr = new ArrayList[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = new ArrayList<>();
                time[i] = Integer.parseInt(st.nextToken());
            }

            int s,e;
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                arr[s-1].add(e-1);
                node[e-1]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> qu = new LinkedList<>();
            for(int i=0; i<N; i++) {
                if(node[i] == 0) {
                    result[i] = time[i];
                    qu.add(i);
                }
            }

            for(int i=0; i<N; i++) {
                int b = qu.poll();

                for(int index : arr[b]) {
                    result[index] = Math.max(result[index], time[index] + result[b]);
                    if(--node[index] == 0){
                        qu.add(index);
                    }
                }
            }

            System.out.println(result[W-1]);
        }
    }
}

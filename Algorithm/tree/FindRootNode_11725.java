package Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindRootNode_11725 {

    static int N;
    static int[] answer;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        BFS(1);

        for(int i=2; i<=N; i++)
            System.out.println(answer[i]);
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for(int i=0; i<arr[n].size(); i++) {
                if(answer[arr[n].get(i)] == 0) {
                    answer[arr[n].get(i)] = n;
                    queue.add(arr[n].get(i));
                }
            }
        }
    }
}

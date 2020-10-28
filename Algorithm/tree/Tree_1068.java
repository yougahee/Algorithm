package Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree_1068 {

    static int N;
    static int[] arr;
    static boolean[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        node = new boolean[N];
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            node[i] = false;
        }

        int R = Integer.parseInt(br.readLine());

        delete(R);

        for(int i=0; i<N; i++) {
            if(!node[i] && arr[i] >= 0) {
                set.add(arr[i]);
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(!node[i] && !set.contains(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void delete(int start) {
        node[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();

            for(int i=0; i<N; i++) {
                if(index == arr[i] && !node[i]) {
                    node[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

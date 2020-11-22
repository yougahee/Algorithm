package Algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Praise_14267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] praise = new int[n+1];

        st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) queue.add(Integer.parseInt(st.nextToken()));

        int num,w;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            praise[num] += w;
        }

        int index = 2;
        while (!queue.isEmpty()) {
            int superior = queue.poll();
            if(superior == -1) continue;
            praise[index++] += praise[superior];
        }

        for(int i=1; i<=n; i++)
            System.out.print(praise[i] + " ");
    }
}

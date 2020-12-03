package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NAndM2_15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] output = new int[M];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) arr[i] = i+1;

        recursive(arr, output, visited, N, M, 0);

    }

    static void recursive(int[] arr, int[] output, boolean[] visited, int n, int r, int depth) {
        if(depth == r) {
            for (int i : output) {
                System.out.print( i + " ");
            }
            System.out.println();
        }
        else {

            for(int i=0; i<n; i++) {
                if(visited[i]) continue;
                if(depth != 0 && output[depth-1] > arr[i]) continue;
                visited[i] = true;
                output[depth] = arr[i];
                recursive(arr, output, visited, n, r, depth+1);
                visited[i] = false;
            }

        }
    }
}

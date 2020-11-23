package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NAndM_15657 {

    static int N, M;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        int[] output = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        DFS(0,0, output);


    }

    public static void DFS(int depth, int start, int[] output) {

        if(depth == M) {
            for(int i=0; i<M; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<N; i++) {
            output[depth] = input[i];
            DFS(depth+1, i, output);
        }
    }
}

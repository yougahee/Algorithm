package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfPartialSequence {

    public static int result =0;
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         s = Integer.parseInt(st.nextToken());

         arr = new int[n];
         st = new StringTokenizer(br.readLine());

         for(int i=0; i<n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }

        DFS(0, 0);

        System.out.println(result);
    }

    public static void DFS(int start, int sum) {

        if(start == n)
            return;

        if(sum + arr[start] == s)
            result++;

        DFS(start+1, sum);

        DFS(start+1, sum+ arr[start]);

    }
}

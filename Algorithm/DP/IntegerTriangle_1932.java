package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0) continue;
                if(j == 0) arr[i][j] += arr[i-1][j];
                else arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) max = Math.max(max, arr[N-1][i]);


        System.out.println(max);
    }
}

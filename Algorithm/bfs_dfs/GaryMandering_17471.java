package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GaryMandering_17471 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] area = new int[N];
        int[][] connection = new int[N][N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            area[i] = Integer.parseInt(st.nextToken());
            sum += area[i];
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            //연결되어있는 것
            for(int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                connection[i][a] = 1;
            }
        }


    }
}

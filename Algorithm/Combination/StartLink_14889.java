package Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink_14889 {

    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N+1];
        comb(1,0);
        System.out.println(answer);
    }

    public static void comb(int start, int depth) {
        if(depth == N/2) {
            answer = Math.min(answer, makeTeam());
            return;
        }

        for(int i = start; i<=N; i++) {
            if(visited[i])
                continue;
            visited[i] = true;
            comb(i+1, depth+1);
            visited[i] = false;
        }
    }

    public static int makeTeam() {
        int sumStart =0;
        int sumLink =0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(visited[i] && visited[j]){
                    sumStart += arr[i][j];
                }
                if(!visited[i] && !visited[j]){
                    sumLink += arr[i][j];
                }
            }
        }

        return Math.abs(sumStart - sumLink);
    }

}

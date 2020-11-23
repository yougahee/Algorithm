package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindLoad_11403 {

    static int N;
    static int[][] map;
    static int[][] resultmap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        resultmap = new int[N][N];

        //입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[] visited;


        for (int i = 0; i < N; i++) {

            visited = new int[N];

            dfs(i, visited);

            for(int j=0; j<N; j++) {
                System.out.print(visited[j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int start, int[] visited) {

        for (int i = 0; i < N; i++) {
            if (map[start][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(i,visited);
            }
        }
    }
}

package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConnectedNum_11724 {

    static int N,M;
    static int[][] map;
    static int[] visited;

    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] =1;
            map[y-1][x-1] =1;
        }

        for(int i=0; i<N; i++) {
            if(visited[i] == 0){
                visited[i] =1;
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void DFS(int start) {


        for(int i=0; i<N; i++) {
            if(visited[i] == 0 && map[start][i] == 1){
                visited[i] =1;
                DFS(i);
            }
        }
    }

}

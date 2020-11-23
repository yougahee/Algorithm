package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeArea_2468 {

    static  int N;
    static int[][] map;
    static int[][] test;

    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};

    static int max =1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int height =0;


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }

        for(int i=1; i<height; i++) {
            solution(i);
        }

        System.out.println(max);
    }

    public static void solution(int height) {

        test = new int[N][N];
        int cnt=0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(map[i][j] > height) {
                    test[i][j] = 1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(test[i][j] == 1) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);

    }

    public static void dfs(int x, int y) {

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx<N && ny >=0 && ny<N && test[nx][ny] ==1 ) {
                test[nx][ny]=0;
                dfs(nx, ny);
            }

        }
    }


}

package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvoidLeftovers_1743 {

    static int N,M;
    static int[][] map;

    static int max = Integer.MIN_VALUE;
    static int cnt =0;

    static int[] dx = {-1,1,0,0};//상하좌우
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] =1;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                //
                if(map[i][j] == 1) {
                    cnt=0;
                    max = Math.max(solution(i,j), max);
                }
            }
        }

        System.out.println(max);

    }

    public static int solution(int x, int y) {


        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //사각형 안에 있을 때,
            if(nx >=0 && nx < N && ny >=0 && ny < M) {
                if(map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    solution(nx,ny);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

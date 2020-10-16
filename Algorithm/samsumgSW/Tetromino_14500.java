package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {
    static int max=0;
    static int[][] paper;

    static int N, M;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            int cnt = 0;
            for(int j=0; j<M; j++) {
                //System.out.println("=======================");
                //System.out.println("ii : " + i + " j : " + j);
                visited[i][j] = true;
                cnt = paper[i][j];
                subDFS(i,j,0,cnt);
                otherTertromino(i,j,cnt);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void subDFS(int x, int y, int depth, int cnt) {
        if(depth == 3) {
            max = Math.max(max, cnt);
            return;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;

            cnt += paper[nx][ny];

            //System.out.println("nx : " + nx + " ny " + ny + " cnt " + cnt);

            visited[nx][ny] = true;
            subDFS(nx, ny, depth+1, cnt);
            cnt -= paper[nx][ny];
            visited[nx][ny] = false;
        }
    }

    public static void otherTertromino(int x, int y, int cnt) {
       //4가지 경우,
        for(int i=0; i<4; i++) {
            boolean flag = false;
            int value = 0;
            for(int j=0; j<4; j++) {
                if(i==j) continue;
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    flag = true;
                    break;
                }
                value += paper[nx][ny];
            }
            if(!flag) max = Math.max(cnt + value, max);
        }
    }
}
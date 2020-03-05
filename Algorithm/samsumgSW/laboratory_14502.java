package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class laboratory_14502 {
    static int arr[][];
    static int copy[][];
    static int N;
    static int M;
    static int max=0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        copy = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //조합
        combiWall(0,0);
        System.out.println(max);

    }

    //벽 세우기
    public static void combiWall(int start,  int step) {

        //벽 3개 다 세웠을 때,
        if(step == 3) {
            copyArr();
            spreadVirus(0,0);
            int result = safeCnt();
            max = Math.max(result, max);
            return;
        }

        for(int i=start; i<N*M; i++) {

            int x = i/M;
            int y = i%M;

            if(arr[x][y] == 0) {
                //여기에 벽을 세우는 거지!
                arr[x][y] = 1;
                combiWall(x+1, step+1);
                arr[x][y] = 0;

            }
        }


    }

    //copy하기
    public static void copyArr() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }

    //바이러스 퍼뜨리기
    public static void spreadVirus(int start, int end) {
        //2가 있는 것을 먼저 파악..! 그 후, 상하좌우가 0이면 2를 다 퍼트리기
        for(int i=start; i<N; i++) {
            for (int j=end; j<M; j++) {

                if(copy[i][j] == 2) {
                    //상
                    if(i-1 >=0) {
                        if(copy[i-1][j]==0) {
                            copy[i-1][j] =2;
                            spreadVirus(i-1, j);
                        }
                    }
                    //하
                    if( i+1 <N) {
                        if(copy[i+1][j]==0) {
                            copy[i+1][j] =2;
                            spreadVirus(i+1, j);
                        }
                    }
                    //좌
                    if(j-1 >=0) {
                        if(copy[i][j-1]==0) {
                            copy[i][j-1] =2;
                            spreadVirus(i, j-1);
                        }
                    }
                    //우
                    if(j+1 < M) {
                        if(copy[i][j+1]==0) {
                            copy[i][j+1] =2;
                            spreadVirus(i, j+1);
                        }
                    }
                }
            }
        }
    }
/*

    // DFS 로 바이러스 퍼트리기
    static void spreadVirusDFS(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                if(copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    spreadVirus(nx, ny);
                }
            }
        }
    }
*/

    //안전영역 갯수 세기
    public static int safeCnt() {
        //copy꺼를 받아서 0인 것의 개수 세기
        int cnt =0;

        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if(copy[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

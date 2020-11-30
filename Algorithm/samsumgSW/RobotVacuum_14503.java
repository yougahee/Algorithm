package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotVacuum_14503 {

    static int N,M;
    static int r,c,d;
    static int space[][];
    static int wall;
    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N,M입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //r,c,d 입력
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        space = new int[N][M];

        //배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanSpaceWay();
    }

    //새로 다시하기!!!!!
    public static void cleanSpaceWay() {

        while (true) {
            //wall이 4개이거나 모두 청소하거나
            if(wall ==4) {
                int nx = r - dx[d];
                int ny = c - dy[d];

                //반대편 방향이 벽이면
                if(space[nx][ny] == 1) {
                    System.out.println(countClean());
                    return;
                }
                //청소가 되어 있는거라면?!
                else {
                    setLocation(nx, ny, d, 0);
                }
            }

            if(space[r][c] == 0) {
                space[r][c] =2;
            }

            //현재방향에서 왼쪽방향 확인
            int dl = (d+3)%4;
            int dxl = r + dx[dl];
            int dyl = c + dy[dl];

            //0이면,
            if(space[dxl][dyl] == 0) {
                setLocation(dxl, dyl, dl, 0);
            }else {
                setLocation(r, c, dl, wall+1);
            }
        }
    }


    public static void setLocation(int x, int y, int direction, int count) {
        r = x;
        c = y;
        d = direction;
        wall = count;
    }

    public static int countClean() {
        int cnt =0;

        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if(space[i][j]==2) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

}

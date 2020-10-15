package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

    static int N;
    static int M;
    static char map[][];

    static int O_x, O_Y, cnt;
    static boolean RHole, BHole, isTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R_X=0, R_Y=0, B_X=0, B_Y =0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'O'){
                    O_x = i;
                    O_Y = j;
                }

                if(map[i][j] == 'R'){
                    R_X = i;
                    R_Y = j;
                }

                if(map[i][j] == 'B'){
                    B_X = i;
                    B_Y = j;
                }
            }
        }

        moveMarble(R_X, R_Y, B_X, B_Y, map);

        if(isTrue) System.out.println(cnt);
        else System.out.println(-1);
    }

    public static void moveMarble(int Rx, int Ry, int Bx, int By, char[][] map) {

    }

    public static int realUpMove(int x, int y, int n) {
        int nx = x;

        for(int i = x-1; i > 0; i--){
            if(map[i][y] == 'O'){
                if(n == 0) BHole = true;
                else RHole = true;
            }
            else if(map[i][y] != '.') {
                break;
            }
            nx = i;
        }

        return nx;
    }

    public static int realdownMove(int x, int y, int n) {
        int nx = x;

        for(int i = x+1; i < N-1; i++){
            if(map[i][y] == 'O'){
                if(n == 0) BHole = true;
                else RHole = true;
            }
            else if(map[i][y] != '.') {
                break;
            }
            nx = i;
        }

        return nx;
    }

    public static int realLeftMove(int x, int y, int n) {
        int ny = y;

        for(int i = y-1; i > 0; i--){
            if(map[x][i] == 'O'){
                if(n == 0) BHole = true;
                else RHole = true;
            }
            else if(map[x][i] != '.') {
                break;
            }
            ny = i;
        }

        return ny;
    }

    public static int realRightMove(int x, int y, int n) {
        int ny = y;

        for(int i = y+1; i < M-1; i++){
            if(map[x][i] == 'O'){
                if(n == 0) BHole = true;
                else RHole = true;
            }
            else if(map[x][i] != '.') {
                break;
            }
            ny = i;
        }
        return ny;
    }

    static class MarbleLocation {
        int Rx;
        int Ry;
        int Bx;
        int By;
        int cnt;

        public MarbleLocation(int Rx, int Ry, int Bx, int By, int cnt) {
            this.Rx = Rx;
            this.Bx = Bx;
            this.Ry = Ry;
            this.By = By;
            this.cnt = cnt;
        }
    }
}

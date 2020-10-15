package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Marble_13460 {

    static int N;
    static int M;
    static char map[][];

    static int O_x, O_Y;
    static boolean RHole, BHole;

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
                    map[i][j] = '.';
                }

                if(map[i][j] == 'B'){
                    B_X = i;
                    B_Y = j;
                    map[i][j] = '.';
                }
            }
        }

        moveMarble(R_X, R_Y, B_X, B_Y);
    }

    public static void moveMarble(int Rx, int Ry, int Bx, int By) {
        Queue<MarbleLocation> queue = new LinkedList<>();
        queue.add(new MarbleLocation(Rx, Ry, Bx, By, 0));
        HashSet<String> hashSet = new HashSet<>();

        while (!queue.isEmpty()) {
            MarbleLocation marble = queue.poll();

            if(marble.cnt == 10) {
                System.out.println(-1);
                return;
            }

            for(int i=0; i<4; i++) {
                int bx=marble.Bx, by=marble.By, rx=marble.Rx, ry=marble.Ry;

                switch (i) {
                    //상
                    case 0:
                        if(marble.By == marble.Ry && marble.Bx < marble.Rx){
                            //구슬 b를 움직인다.
                            bx = realUpMove(marble.Bx, marble.By, 0);
                            rx = realUpMove(marble.Rx, marble.Ry, 1);
                            if(bx == rx)
                                rx++;
                        }
                        else {
                            rx = realUpMove(marble.Rx, marble.Ry, 1);
                            bx = realUpMove(marble.Bx, marble.By, 0);
                            if(bx == rx && marble.By < marble.Ry)
                                bx++;
                        }
                        break;

                    //하
                    case 1:
                        if(marble.By == marble.Ry && marble.Bx > marble.Rx){
                            //구슬 b를 움직인다.
                            bx = realdownMove(marble.Bx, marble.By, 0);
                            rx = realdownMove(marble.Rx, marble.Ry, 1);
                            if(bx == rx)
                                rx--;
                        }
                        else {
                            rx = realdownMove(marble.Rx, marble.Ry, 1);
                            bx = realdownMove(marble.Bx, marble.By, 0);
                            if(bx == rx && marble.By < marble.Ry)
                                bx--;
                        }

                        break;

                    //좌
                    case 2:
                        if(marble.Bx == marble.Rx && marble.By < marble.Ry){
                            //구슬 b를 움직인다.
                            by = realLeftMove(marble.Bx, marble.By, 0);
                            ry = realLeftMove(marble.Rx, marble.Ry, 1);

                            if(by == ry )
                                ry++;
                        }
                        else {
                            ry = realLeftMove(marble.Rx, marble.Ry, 1);
                            by = realLeftMove(marble.Bx, marble.By, 0);

                            if(by == ry && marble.Bx == marble.Rx)
                                by++;
                        }
                        break;

                    //우
                    case 3:
                        if(marble.Bx == marble.Rx && marble.By > marble.Ry){
                            //구슬 b를 움직인다.
                            by = realRightMove(marble.Bx, marble.By, 0);
                            ry = realRightMove(marble.Rx, marble.Ry, 1);
                            if(by == ry)
                                ry--;
                        }
                        else {
                            ry = realRightMove(marble.Rx, marble.Ry, 1);
                            by = realRightMove(marble.Bx, marble.By, 0);
                            if(by == ry && marble.Bx == marble.Rx)
                                by--;
                        }
                        break;
                }

                System.out.println("rx :" + rx + " ry :" + ry + " bx :" + bx + " by :" + by);
                System.out.println(BHole + "  " + RHole );

                if(!BHole) {
                    if(RHole) {
                        System.out.println(marble.cnt + 1);
                        return;
                    }
                    else queue.add(new MarbleLocation(rx, ry, bx, by, marble.cnt+1));
                }

                BHole = false; RHole = false;
            }
        }
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

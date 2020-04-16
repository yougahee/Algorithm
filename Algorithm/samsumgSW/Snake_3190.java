package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Snake_3190 {

    static class Dot{
        int x,y;

        public Dot(int x, int y) {
            this.x =x;
            this.y =y;
        }
    }

    static int[][] map;
    static int cnt=0;
    static int n;

    static int direction=1;
    static int[] dx = {-1,0,1,0};//상우하좌
    static int[] dy = {0,1,0,-1};

    static int[] second;
    static String[] c;

    static Deque<Dot> snake = new ArrayDeque<Dot>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        int k = Integer.parseInt(br.readLine());
        int x;
        int y;

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x][y] =1;
        }


        int L = Integer.parseInt(br.readLine());
        second = new int[L+1];
         c = new String[L];


        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            second[i] = Integer.parseInt(st.nextToken());
            c[i] = st.nextToken();
        }

        move();
    }

    public static void move() {

        int nx=1;
        int ny=1;
        map[1][1] = 2;

        snake.add(new Dot(nx, ny));

        int switchdirection=0;

        while(true) {

            nx = nx + dx[direction];
            ny = ny + dy[direction];
            cnt++;

            //벽에 부딪히면 끝
            if(nx <=0 || ny <=0 || nx > n || ny > n) {
                break;
            }

            //자신에 몸에 부딪히면 끝
            if(map[nx][ny] == 2) {
                break;
            }

            //사과먹음
            if(map[nx][ny]==1){

                map[nx][ny] =2;
                snake.addFirst(new Dot(nx, ny));
            }else if(map[nx][ny] ==0){
                map[nx][ny] =2;
                snake.addFirst(new Dot(nx, ny));

                //뒤에 빼기
                Dot tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }

            //방향 바꾸기
            if(cnt == second[switchdirection]) {
                if(c[switchdirection].equals("D")){
                    direction = (direction+1)%4;
                }else{
                    direction = (direction+3)%4;
                }

                switchdirection++;
            }
        }

        System.out.println(cnt);
    }

}

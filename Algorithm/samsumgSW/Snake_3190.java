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
    static int[][] visited;
    static int cnt=0;
    static int n;

    static int direction=1;
    static int[] dx = {-1,0,1,0};//상우하좌
    static int[] dy = {0,1,0,-1};

    static int[] second;
    static String[] c;
    static int tail=0;

    static Deque<Dot> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new int[n+1][n+1];

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

        int switchdirection=0;

        while(true) {
            nx = nx + dx[direction];
            ny = ny + dy[direction];
            cnt++;

            //벽에 부딪히면 끝
            if(nx <=0 || ny <=0 || nx > n || ny > n) {
                break;
            }

            if(map[nx][ny]==1 && visited[nx][ny]==0){
                //길이 증가
                tail++;
                visited[nx][ny]=1;
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

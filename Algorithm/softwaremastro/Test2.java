package Algorithm.softwaremastro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Test2 {

    static class Dot{
        int x,y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static LinkedList<Dot> dot = new LinkedList<>();
    public static int isCheckedDFS[];
    static int[][] map;

    static int N;

    static int max = Integer.MIN_VALUE;

    static LinkedList<Dot> teamDot;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        isCheckedDFS = new int[N];
        map = new int[N][N];

        //좌표
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dot.add(new Dot(x,y));
        }

        //관계
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a-1][b-1] = 1;
            map[b-1][a-1] = 1;
        }

        for(int i=0; i<N; i++) {
            teamDot = new LinkedList<>();
            DFS(i);
            if(teamDot.size()!=0)
                calmax();
        }

        System.out.println(max);
    }

    public static void DFS(int start) {

        for(int i=0; i<N; i++) {
            if(map[start][i] == 1 && isCheckedDFS[i] == 0 ) {
                isCheckedDFS[i] =1;
                DFS(i);
                teamDot.add(dot.get(i));
            }
        }
    }

    public static void calmax() {

        int Xmax = Integer.MIN_VALUE;
        int Ymax = Integer.MIN_VALUE;

        int Xmin = Integer.MAX_VALUE;
        int Ymin = Integer.MAX_VALUE;

        for(Dot testDot : teamDot) {
            Xmax  = Math.max(testDot.x, Xmax);
            Ymax = Math.max(testDot.y, Ymax);

            Xmin  = Math.min(testDot.x, Xmin);
            Ymin = Math.min(testDot.y, Ymin);
        }

        //4각형 길이 구하기
        int length = (Xmax -Xmin) *2 + (Ymax - Ymin) *2;

        max = Math.max(max, length);

    }
}

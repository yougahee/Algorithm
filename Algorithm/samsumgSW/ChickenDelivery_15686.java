package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {

    static class Chicken{
        int x,y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int map[][];

    static int[] set;
    static Chicken[] combination;

    static Chicken chicken;


    static int min;
    static int sum;

    static ArrayList<Integer> d = new ArrayList();

    static LinkedList<Chicken> chickenArrayList = new LinkedList<Chicken>();
    static LinkedList<Chicken> home = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        //d = new int[2*N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1 ){
                    home.add(new Chicken(i,j));
                }

                if(map[i][j] == 2) {
                    chickenArrayList.add(new Chicken(i,j));
                }
            }
        }


        min = Integer.MAX_VALUE;
        set = new int[M];
        //치킨을 M개 만큼 뽑기
        combi(set, 0, chickenArrayList.size(), M, 0);

        System.out.println(min);
    }

    //조합
    public static void combi(int[] set, int size, int n, int c, int index) {
        if(c==0) {
            combination = new Chicken[size];
            for(int i=0; i<size; i++) {
                combination[i] = chickenArrayList.get(set[i]);
            }
            direction();
            return;
        }
        else if ( n == index) return;

        set[size]  = index;
        combi(set, size+1, n, c-1, index+1);
        combi(set, size, n, c, index+1);


    }


    //치킨거리 구하기
    public static void direction() {

        int dismin = Integer.MAX_VALUE;

        for(Chicken home1 : home) {

            //조합으로 구한 치킨집의 위치와 지금 home1의 위치 중 거리가 가장 짧은 것을 구하면 된다.
            for(int i=0; i<combination.length; i++) {

                int abs = Math.abs(combination[i].x - home1.x) + Math.abs(combination[i].y - home1.y);

                if(dismin > abs) {
                    dismin = abs;
                }
            }

            sum += dismin;

        }

        if(sum < min) min = sum;
    }

}

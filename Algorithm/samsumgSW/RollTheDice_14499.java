package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RollTheDice_14499 {

    static int[][] map;
    static int x;
    static int y;
    static int n;
    static int m;

    //명령 queue
    static Queue<Integer> direction = new LinkedList<>();

    //주사위
    static int[] dice = new int[7];

    static int[] dx = {0, 0, -1, 1}; //동서북남
    static int[] dy = {1, -1, 0, 0};

    //가로
    static int[] row = {6,4,1,3};
    static int rowPoint = 2;
    //세로
    static int[] col = {2,1,5,6};
    static int colPoint = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            direction.add(Integer.parseInt(st.nextToken()));
        }


    }

}

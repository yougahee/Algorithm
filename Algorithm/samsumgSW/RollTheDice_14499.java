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

        solution();

    }

    public static void solution() {

        int nx = x;
        int ny = y;

        //명령이 있을때까지!
        while (!direction.isEmpty()) {
            int d =direction.poll();

            nx = nx + dx[d-1];
            ny = ny + dy[d-1];

            //지도에서 벗어나면 break
            if(nx < 0 || nx > n || ny< 0 || ny > m) {
                break;
            }

            switch(d) {
                //동
                case 1:
                    //현위치
                    rowPoint = mod(rowPoint+1);
                    System.out.println(dice[row[rowPoint]]);

                    break;

                //서
                case 2:
                    rowPoint = mod(rowPoint+3);
                    System.out.println(dice[row[rowPoint]]);
                    break;

                //북
                case 3:
                    colPoint = mod(colPoint+1);

                    System.out.print("위 " + col[colPoint] + "    ");
                    System.out.println(dice[col[colPoint]]);
                    break;

                //남
                case 4:
                    colPoint = mod(colPoint+3);
                    System.out.print("위 " + col[colPoint] + "    ");
                    System.out.println(dice[col[colPoint]]);
                    break;
            }

            //조건,,가로(동,서)
            if(d ==1 || d==2) {
                if(map[nx][ny]==0) {
                    map[nx][ny] = dice[row[mod(rowPoint+2)]];
                }else {
                    dice[row[mod(rowPoint+2)]]=map[nx][ny];

                    System.out.println( "주사위 몇번째?" + row[mod(rowPoint+2)] +" "+ dice[row[mod(rowPoint+2)]]);
                    map[nx][ny]=0;
                }
            }else{
                if(map[nx][ny]==0) {
                    map[nx][ny] = dice[col[mod(colPoint+2)]];
                }else {
                    dice[col[mod(colPoint+2)]]=map[nx][ny];
                    System.out.println( "주사위 몇번째?" + col[mod(colPoint+2)] +" "+ dice[col[mod(colPoint+2)]]);
                    map[nx][ny]=0;
                }
            }


        }

    }

    public static int mod(int num) {
        return num%4;
    }
}

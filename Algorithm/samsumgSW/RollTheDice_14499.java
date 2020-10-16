package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//주사위를 어떻게 굴릴지 혼자 생각해내지 못했음..
//ㅜㅅㅜ
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

        while (!direction.isEmpty()) {
            int dir = direction.poll();
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            int top = dice[1];
            if(dir == 1) {
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = top;
            }else if(dir == 2) {
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = top;
            }else if(dir == 3) {
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = top;
            }else {
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = top;
            }

            //지도의 칸이 0일 경우,
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            }
            //칸이 0 이 아닌경우
            else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            System.out.println(dice[1]);
        }
    }
}

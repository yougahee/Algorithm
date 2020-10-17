package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonCurve_15685 {

    static boolean[][] map = new boolean[101][101];

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int x, y, d, g;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(d);
            for(int j=0; j<g; j++) {
                int size = arr.size();
                while (size > 0) {
                    arr.add((arr.get(size-1)+1)%4);
                    size--;
                }
            }
            map[x][y] = true;
            dragonCurve(arr, x, y);
        }
        count();
    }

    public static void dragonCurve(ArrayList<Integer> arr, int x, int y) {
        int nx = x;
        int ny = y;
        for (Integer i : arr) {
            nx += dx[i];
            ny += dy[i];

            if(nx < 0 || ny < 0 || nx > 100 || ny > 100 ) continue;
            map[nx][ny] = true;
        }
    }

    public static void count() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}

package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonCurve_15685 {
    static int x, y, d, g;

    static int[][] map = new int[101][101];
    static int cnt = 0;

    static List<Integer> direction;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            direction = new LinkedList<Integer>();

            dragonCurve();

        }
        count();
    }

    public static void directions() {

        direction.add(d);

        while (g > 0) {

            for (int i = direction.size()-1; i >=0 ; i--) {
                int dir = (direction.get(i) +1 ) % 4;
                direction.add(dir);
            }
            g--;
        }
    }

    public static void dragonCurve() {

        map[x][y] = 1;
        directions();

        for(int i = 0; i < direction.size(); i++) {
            int dir = direction.get(i);

            //map에서 벗어나는 것은 제외시키기
            if (x + 1 > 100 || x - 1 < 0 || y + 1 > 100 || y - 1 < 0) {
                break;
            }

            switch (dir) {
                case 0:
                    map[++x][y] = 1;
                    break;
                case 1:
                    map[x][--y] = 1;
                    break;
                case 2:
                    map[--x][y] = 1;
                    break;
                case 3:
                    map[x][++y] = 1;
                    break;
            }
        }
    }

    //드래곤커브의 일부인 정사각형 구하기
    public static void count() {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

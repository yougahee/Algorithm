package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddRectangularArea_2669 {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[101][101];

        int sx, sy, ex, ey;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            fillArea(sx,sy,ex,ey);
        }

        System.out.println(countArea());
    }

    static void fillArea(int sx, int sy, int ex, int ey) {

        for(int i=0; i<ex-sx; i++) {
            for(int j=0; j<ey-sy; j++) {
                arr[sx+i][sy+j] = 1;
            }
        }
    }

    static int countArea() {
        int cnt =0;

        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if (arr[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}

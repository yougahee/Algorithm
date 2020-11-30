package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotVacuum_14503 {

    static int[][] place;

    //북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer, r, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        place = new int[N][M];

        answer = 0;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {

            if (cnt == 4) {
                int kx = r - dx[d];
                int ky = c - dy[d];

                if (place[kx][ky] == 1) break;
                else {
                    r = kx;
                    c = ky;
                    cnt = 0;
                }
            }

            if (place[r][c] == 0) {
                place[r][c] = 2;
                answer++;
            }

            int nd = (d + 3) % 4;
            int nx = r + dx[nd];
            int ny = c + dy[nd];

            if (place[nx][ny] == 0) {
                cnt = 0;
                d = nd;
                r = nx;
                c = ny;
            }
            else {
                d = nd;
                cnt++;
            }
        }
        System.out.println(answer);
    }
}

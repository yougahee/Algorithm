package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candy_3085 {

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int N;
    static char[][] candy;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candy = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                candy[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < N && ny <N) {
                        char temp = candy[i][j];
                        candy[i][j] = candy[nx][ny];
                        candy[nx][ny] = temp;

                        countMax(i, j);
                        countMax(nx, ny);

                        candy[nx][ny] = candy[i][j];
                        candy[i][j] = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void countMax(int r, int c) {
        int r_cnt = 1, c_cnt = 1;

        for (int i = 0; i < N - 1; i++) {
            //행
            if (candy[r][i] == candy[r][i + 1]) {
                r_cnt++;
            } else {
                r_cnt = 1;
            }
            //열
            if (candy[i][c] == candy[i + 1][c]) {
                c_cnt++;
            } else {
                c_cnt = 1;
            }

            max = Math.max(max, Math.max(r_cnt, c_cnt));
        }
    }
}

package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RedGreenMedicine_10026 {

    static int N;
    static char[][] general;
    static char[][] redGreen;
    static int[][] map;

    static int[] dx = {-1,1,0,0}; //상 하 좌 우
    static int[] dy = {0,0,-1,1};

    static int cnt =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        general = new char[N][N];
        redGreen = new char[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<N; j++) {
                general[i][j] = str[j].charAt(0);
            }
        }

        makeRedGreenMap();

        dp(general);
        dp(redGreen);
    }

    public static void dp(char[][] array) {

        cnt =0;
        cleanMap();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 0) {
                    char a = array[i][j];
                    //함수 호출
                    countArea(array, i, j, a);
                    cnt++;
                }
            }
        }

        System.out.print(cnt + " ");
    }

    public static void countArea(char[][] array, int x, int y, char c) {

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny <N && map[nx][ny] ==0 && c == array[nx][ny]) {
                map[nx][ny] = 1;
                countArea(array, nx, ny, c);
            }
        }

    }

    public static void makeRedGreenMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(general[i][j] == 'G') {
                    redGreen[i][j] = 'R';
                }else {
                    redGreen[i][j] = general[i][j];
                }
            }
        }
    }

    public static void cleanMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] =0;
            }
        }
    }
}

package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganCabbage_1012 {

    static int N;
    static int M;
    static int cabbageNum;
    static int cabbageMap[][];
    static int map[][];
    static int cnt;

    static int nx[] = {-1,1,0,0}; //상,하,좌,우
    static int ny[] = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int l=0; l<testCase; l++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cabbageNum = Integer.parseInt(st.nextToken());

            cabbageMap = new int[N][M];
            map = new int[N][M];
            cnt =0;

            for(int i=0; i<cabbageNum; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                cabbageMap[X][Y] =1;
            }

            earthWormNum();
        }
    }

    public static void earthWormNum() {

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++){

                if(cabbageMap[i][j] ==1 && map[i][j] == 0) {
                    moveWorm(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void moveWorm(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx2 = x + nx[i];
            int ny2 = y + ny[i];

            if(nx2 >=0 && nx2 < N && ny2 >=0 && ny2 < M && cabbageMap[nx2][ny2]==1 && map[nx2][ny2] ==0){
                map[nx2][ny2] = 1;
                moveWorm(nx2, ny2);
            }
        }
    }
}

package Algorithm.test_brandy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test4 {

    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};

    static int max = Integer.MIN_VALUE;
    static int[][] stream;
    static int N, d;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        stream = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                stream[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(stream[i][j] == 0)
                    count(i,j);
            }
        }

        System.out.println(max);
    }

    public static void count(int x, int y) {
        int cnt=0;

        for(int j=1; j<=d; j++) {
            for(int i=0; i<8; i++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if(nx >=0 && ny >=0 && nx <N && ny <N && stream[nx][ny] == 0) {
                    cnt++;
                }
            }
        }

        if(max < cnt)
            System.out.println(x + " " + y);

        max = Math.max(cnt, max);
    }
}

package Algorithm.brandy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test2 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int N;
    static int[][] home;
    static Queue<pair> queue;

    public static class pair {
        int x;
        int y;
        int cnt;

        public pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        home = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //물 이동. queue를 사용해야함.
        //홍현이 이동 후 막고 0의 개수 세어서 최대값 구하기
        //-1은 이미 침수되었당,,
        home[0][0] = -1;
        queue = new LinkedList<>();
        queue.add(new pair(0,0,0));

    }

    static public void moveWater() {

        while (true) {
            int size = queue.size();

            if(size == 0)
                break;

            for(int k=0; k<size; k++) {
                pair qu = queue.poll();

                for(int i=0; i<4; i++) {
                    int nx = qu.x + dx[i];
                    int ny = qu.y + dy[i];

                    if(nx >=0 && nx <N && ny >=0 && ny <N && home[nx][ny] == 0) {
                        home[nx][ny] = -1;
                        queue.add(new pair(nx, ny, qu.cnt+1));
                    }
                }
            }


        }


    }
}

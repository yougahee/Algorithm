package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1차시도 --> 시간초과 ( BFS 두번 호출 )
//2차시도 --> 시간초과 ( BFS 한번 호출 )

public class SaveThePrincess_17836 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int N, M, cnt, gramCnt;
    static boolean[][] visited;
    static int[][] castle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time, answer = 0;
        int gramDistance=0, gramX=0, gramY=0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        castle = new int[N][M];
        visited = new boolean[N][M];
        cnt = time+1;
        gramCnt = time +1;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());

                if(castle[i][j] == 2) {
                    gramX = i;
                    gramY = j;
                    gramDistance = N - i + M - j -2;
                }
            }
        }

        BFS(gramX, gramY);
        answer = Math.min(cnt, gramCnt + gramDistance);

        if(time < answer)
            System.out.println("Fail");
        else
            System.out.println(answer);
    }

    static void BFS(int desX, int desY) {

        Queue<Hero> queue = new LinkedList<>();
        queue.add(new Hero(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Hero hero = queue.poll();
            int x = hero.x;
            int y = hero.y;
            int timeCnt = hero.time;

            if(x == N-1 && y == M-1) {
                cnt = Math.min(timeCnt, cnt);
            }

            //gram에 도달
            if(x == desX && y == desY) {
                gramCnt = Math.min(timeCnt, gramCnt);
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && ny >=0 && nx < N && ny < M && !visited[nx][ny] && castle[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    queue.add(new Hero(nx, ny, timeCnt+1));
                }
            }
        }
    }

    static class Hero {
        int x;
        int y;
        int time;

        public Hero(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}

package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7576 {

    static int M,N;

    static int[][] tomato;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        Queue<Tomato> queue = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1)
                    queue.add(new Tomato(i,j,0));
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            ans = t.w;

            for(int i=0; i<4; i++) {
                int nx = dx[i] + t.x;
                int ny = dy[i] + t.y;

                if(nx < 0 || nx >= N || ny <0 || ny >= M) continue;
                if(tomato[nx][ny] != 0) continue;

                tomato[nx][ny] = 1;
                queue.add(new Tomato(nx,ny, ans+1));
            }
        }

        if(isState()) System.out.println(ans);
        else System.out.println(-1);
    }

    static boolean isState() {

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    static class Tomato{
        int x,y,w;

        Tomato(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

}

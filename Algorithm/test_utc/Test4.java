package Algorithm.test_utc;

import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
    public static void main(String[] args) {

    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static int cx = 0;
    static int cy = 0;

    static int ans = 0;
    static int N;

    public static int solution(int n, int[][] board) {
        N = n;
        for(int i=0; i<n*n; i++) {
            BFS(i+1, board);
        }

        return ans;
    }

    public static void BFS(int num, int[][] board) {
        boolean[][] visit = new boolean[N][N];
        visit[cx][cy] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(cx, cy, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if(board[pair.x][pair.y] == num) {
                ans += pair.cnt;
                cx = pair.x;
                cy = pair.y;
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = ( dx[i] + pair.x + N ) % N;
                int ny = ( dy[i] + pair.y + N )  % N;

                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                queue.add(new Pair(nx, ny, pair.cnt+1));
            }
        }

    }

    static class Pair {
        int x,y,cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}

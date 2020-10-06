package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JumpJump_11060 {

    static boolean isArrive = false;
    static boolean[] isVisited;
    static int[] maze;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maze = new int[N];
        isVisited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        BFS();

        if(isArrive)
            System.out.println(min);
        else
            System.out.println(-1);
    }

    public static void BFS() {
        Queue<Jump> queue = new LinkedList<>();
        queue.add(new Jump(0, 0));

        while (!queue.isEmpty()) {
            Jump jumpTmp = queue.poll();
            int index = jumpTmp.index;

            if(index == N-1) {
                isArrive = true;
                min = Math.min(jumpTmp.cnt, min);
                continue;
            }

            if(isVisited[index] || index >= N) continue;

            int jumpMax = maze[index];
            isVisited[index] = true;

            for(int i=jumpMax; i>0; i--) {
                if(index+i >= N)
                    continue;
                queue.add(new Jump(index+i, jumpTmp.cnt +1));
            }
        }
    }

    public static class Jump {
        int index;
        int cnt;

        public Jump(int index, int cnt) {
            this.index = index;
            this.cnt = cnt;
        }
    }
}

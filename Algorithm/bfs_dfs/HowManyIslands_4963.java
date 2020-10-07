package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HowManyIslands_4963 {

    static int w,h;
    static int[][] island;
    static boolean[][] isVisited;

    static int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int cnt = 0;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                return;

            island = new int[h][w];
            isVisited = new boolean[h][w];
            cnt = 0;

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(island[i][j] == 1 && !isVisited[i][j]){
                        cnt++;
                        isVisited[i][j] = true;
                        BFS(i, j);
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >=0 && ny >=0 && nx <h && ny < w && !isVisited[nx][ny] && island[nx][ny] == 1) {
                    isVisited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

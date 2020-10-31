package Algorithm.test_wintercoding;

import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {


        //System.out.println(solution(perchase));
    }

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int N;

    public static int[] solution(int[][] v)
    {
        int[] answer = new int[3];
        N = v.length;
        map = v;
        visited = new boolean[v.length][v.length];

        for(int i=0; i<v.length; i++) {
            for(int j=0; j<v.length; j++) {
                if(!visited[i][j]) {
                    BFS(i, j, v[i][j]);
                    answer[v[i][j]]++;
                }
            }
        }

        return answer;
    }

    public static void BFS(int x, int y, int value) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if(nx < 0 || nx >= N || ny <0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] !=value) continue;

                visited[nx][ny] = true;
                queue.add(new Pair(nx, ny));
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

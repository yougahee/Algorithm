package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo_11559 {

    static char[][] puyo;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        puyo = new char[12][6];

        for(int i=0; i<12; i++) {
            String str = br.readLine();
            for(int j=0; j<6; j++){
                puyo[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        boolean endFlag;
        while (true) {
            endFlag = false;
            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++){
                    if( puyo[i][j] != '.' && isRemove(i,j)) {
                        removeRelate(i,j);
                        endFlag = true;
                    }
                }
            }

            if(!endFlag) break;
            downPuyo();
            cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean isRemove(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        q.add(new Pair(x,y));
        int cnt = 0;
        char color = puyo[x][y];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            cnt++;
            if(cnt == 4) return true;
            Pair p = q.poll();

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx >= 12 || ny < 0 || ny >=6) continue;
                if(color != puyo[nx][ny]) continue;
                if(visited[nx][ny]) continue;

                q.add(new Pair(nx,ny));
                visited[nx][ny] = true;
            }
        }

        return false;
    }

    public static void removeRelate(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        char color = puyo[x][y];

        while (!q.isEmpty()) {
            Pair p = q.poll();

            puyo[p.x][p.y] = '.';

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx >= 12 || ny < 0 || ny >=6) continue;
                if(color != puyo[nx][ny]) continue;

                q.add(new Pair(nx,ny));
            }
        }
    }

    public static void downPuyo() {
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<6; i++) {
            q.clear();
            for(int j=11; j>=0; j--) {
                if(puyo[j][i] == '.') {
                    q.add(new Pair(j,i));
                }
                else if( puyo[j][i] != '.' && !q.isEmpty()) {
                    Pair p = q.poll();
                    puyo[p.x][p.y] = puyo[j][i];
                    puyo[j][i] = '.';
                    q.add(new Pair(j,i));
                }
            }
        }
    }

    public static void print() {
        System.out.println("============");
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++){
                System.out.print(puyo[i][j]);
            }
            System.out.println();
        }
    }

    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

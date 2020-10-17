package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Surveillance_15683 {

    static int N, M, min = Integer.MAX_VALUE;
    static int[][] place;
    static int[] aFew = {0,4,2,4,4,1};
    static ArrayList<cctv> arr;

    static int[] dx = {-1, 0, 1, 0}; //상우하좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        place = new int[N][M];
        arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if(place[i][j] > 0 && place[i][j] < 6)
                    arr.add(new cctv(i,j, place[i][j]));
            }
        }

        DFS(0, place);
        System.out.println(min);
    }

    public static void DFS(int depth, int[][] map) {
        if(depth == arr.size()) {
            min = Math.min(min, blindSpot(map));
            return;
        }

        int x = arr.get(depth).x;
        int y = arr.get(depth).y;
        int num = arr.get(depth).num;

        for(int i=0; i<aFew[num]; i++) {
            switch (num) {
                case 1:
                    DFS(depth+1, firstCCTV(x,y,i,map));
                    break;
                case 2:
                    DFS(depth+1, firstCCTV(x,y,i, firstCCTV(x,y,i+2, map)));
                    break;
                case 3:
                    DFS(depth+1, firstCCTV(x,y,i, firstCCTV(x,y, (i+1)%4, map)));
                    break;
                case 4:
                    DFS(depth+1, forthCCTV(x,y,i,map));
                    break;
                case 5:
                    DFS(depth+1, fifthCCTV(x,y,map));
                    break;
            }
        }
    }

    public static int[][] firstCCTV(int x, int y, int seq, int[][] map) {
        int[][] copyMap = copyArr(map);

        while (true) {
            x += dx[seq];
            y += dy[seq];

            if(x < 0 || x >= N || y < 0 || y >= M) break;
            if(copyMap[x][y] == 6) break;
            if(copyMap[x][y] > 0 && copyMap[x][y] < 6) continue;

            copyMap[x][y] = 7;
        }
        //printMap(copyMap);
        return copyMap;
    }

    public static int[][] forthCCTV(int x, int y, int seq, int[][] map) {
        int[][] copyMap = copyArr(map);
        int nx=0, ny=0;

        for(int i=0; i<4; i++) {
            if(seq == i)
                continue;
            nx = x;
            ny = y;

            while (true) {
                nx += dx[i];
                ny += dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                if(copyMap[nx][ny] == 6) break;
                if(copyMap[nx][ny] > 0 && copyMap[nx][ny] < 6) continue;

                copyMap[nx][ny] = 7;
            }
        }
        //printMap(copyMap);
        return copyMap;
    }

    public static int[][] fifthCCTV(int x, int y, int[][] map) {
        int[][] copyMap = copyArr(map);

        for(int i=0; i<4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                if(copyMap[nx][ny] == 6) break;
                if(copyMap[nx][ny] > 0 && copyMap[nx][ny] < 6) continue;

                copyMap[nx][ny] = 7;
            }
        }
        //printMap(copyMap);
        return copyMap;
    }

    public static int[][] copyArr (int[][] map) {
        int[][] copyMap = new int[N][M];

        for(int i=0; i<N; i++)  {
            for(int j=0; j<M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }

    public static int blindSpot(int[][] map) {
        int cnt =0;
        for(int i=0; i<N; i++)  {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void printMap(int[][] map) {
        System.out.println("=======================");
        for(int i=0; i<N; i++)  {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class cctv {
        int x, y, num;

        cctv(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}

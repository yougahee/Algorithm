package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindArea_2583 {
    static int[][] area;
    static int[][] visited;

    static int x, y, cnt=0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        area = new int[x][y];
        visited = new int[x][y];
        ArrayList<Integer> answer = new ArrayList<>();

        int sx, sy, ex, ey;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            sy = Integer.parseInt(st.nextToken());
            sx = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());

            checkArea(sx, sy, ex, ey);
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (area[i][j] == 0) {
                    cnt = 1;
                    area[i][j] = 1;
                    DFS(i,j);
                    answer.add(cnt);
                }
            }
        }

        System.out.println(answer.size());

        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }

    public static void checkArea(int sx, int sy, int ex, int ey) {

        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                area[i][j] = 1;
            }
        }

      /*  for(int i=0; i<x; i++) {
            System.out.println(Arrays.toString(area[i]));
        }*/
    }

    public static void DFS(int r, int c) {

        for (int i = 0; i < 4; i++) {
            int nx =  r + dx[i];
            int ny =  c + dy[i];

            if (nx >= 0 && nx < x && ny >= 0 && ny < y && area[nx][ny] == 0) {
                cnt++;
                area[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }
}

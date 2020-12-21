package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreadHouse_3109 {

    static int ans, R, C;

    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};

    static boolean[][] visited;
    static char[][] bread;

    static boolean isArrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bread = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                bread[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<R; i++) {
            //visited[i][0] = true;
            isArrive = false;
            //System.out.println("================");
            if(DFS(i, 0, 1)) ans++;
        }

        System.out.println(ans);
    }

    static boolean DFS(int s, int e, int cnt) {

        if(cnt == C) {
            return true;
        }

        visited[s][e] = true;
        for(int i=0; i<3; i++) {
            int nx = s + dx[i];
            int ny = e + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(bread[nx][ny] == 'x') continue;

            if(DFS(nx, ny, cnt+1)) return true;
        }
        return false;
    }
}

package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


//다시풀기
//bfs & 백트레킹..ㅠㅜㅜ어렵드아
public class Alphabet_1987 {

    static int r;
    static int c;

    static char[][] alphabet;
    static int[] visited;

    static int[] dx = {-1,1,0,0};//상하좌우
    static int[] dy = {0,0,-1,1};

    static int max =1;
    static int cnt =1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alphabet = new char[r][c];
        visited = new int[26];

        for(int i=0; i< r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                alphabet[i][j] = str.charAt(j);
            }
        }

        dfs(0,0);

        System.out.println(max);


    }

    public static void dfs(int x, int y) {
        visited[alphabet[x][y]- 'A'] =1;

        //상하좌우
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            //범위 안에 있으면
            if(nx >= 0 && nx < r && ny >= 0 && ny < c) {

                int nextAlpha = alphabet[nx][ny] - 'A';

                if(visited[nextAlpha] ==0) {
                    cnt++;
                    max = Math.max(max, cnt);
                    dfs(nx, ny);
                }
            }
        }

        //초기화..
        --cnt;
        visited[alphabet[x][y] - 'A'] =0;

    }


}

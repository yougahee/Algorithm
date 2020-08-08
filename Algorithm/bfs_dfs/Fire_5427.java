package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fire_5427 {

    public static class location {
        int x;
        int y;

        public location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static ArrayList<location> location_sang;
    static Queue<location> fire;

    static int w,h;
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new int[h][w];

            location_sang = new ArrayList<>();
            fire = new LinkedList();

            //입력
            for(int x =0; x<h; x++) {
                String[] str = br.readLine().split("");
                for(int y =0; y<w; y++) {
                    map[x][y] = str[y].charAt(0);

                    if(map[x][y] == '@') {
                        location_sang.add(new location(x,y));
                        visited[x][y] = 1;
                    }

                    if(map[x][y] == '*')
                        fire.add(new location(x,y));
                }
            }

            BFS();

        }
    }

    public static void BFS() {
        location loc;
        location fire_loc;
        int loc_x, loc_y;
        int fire_loc_x, fire_loc_y;
        int cnt = 0;


        while (true) {
            if(location_sang.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            int sangen_size = location_sang.size();
            int fire_size = fire.size();
            cnt++;

            //상근이가 이동
            for(int i=0; i<sangen_size; i++) {
                loc = location_sang.remove(0);

                loc_x = loc.x;
                loc_y = loc.y;

                for(int k=0; k<4; k++) {
                    int nx = loc_x + dx[k];
                    int ny = loc_y + dy[k];

                    //범위에 있는 경우
                    if(nx >= 0 && nx < h && ny >=0 && ny < w ) {
                        if(map[nx][ny] == '.' && visited[nx][ny] == 0){
                            map[nx][ny] = '@';
                            visited[nx][ny] = 1;
                            location_sang.add(new location(nx, ny));
                        }
                    }else {
                        System.out.println(cnt);
                        return;
                    }
                }
            }
//
//            //
//            System.out.println("상근이 이동===================");
//            printArr();
//            System.out.println("===================");

            //불 이동
            for(int i=0; i<fire_size; i++) {
                fire_loc = fire.poll();

                fire_loc_x = fire_loc.x;
                fire_loc_y = fire_loc.y;

                for(int k=0; k<4; k++) {
                    int nx = fire_loc_x + dx[k];
                    int ny = fire_loc_y + dy[k];

                    //범위에 있는 경우
                    if(nx >= 0 && nx < h && ny >=0 && ny < w ) {
                        if(map[nx][ny] == '@'){
                            location_sang.removeIf(x -> (x.x == nx) && (x.y == ny));

                        }
                        if(map[nx][ny] != '#' && map[nx][ny] != '*'){
                            map[nx][ny] = '*';
                            fire.add(new location(nx, ny));
                        }

                    }
                }
            }
//
//            System.out.println("불 이동===================");
//            printArr();
//            System.out.println("===================");


        }

    }

    public static void printArr() {
        for(int i=0; i<h; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

}

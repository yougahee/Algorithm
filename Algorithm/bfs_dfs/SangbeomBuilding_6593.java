package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangbeomBuilding_6593 {

    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    static int L, R, C;
    static char[][][] building;
    static int[][][] visited;

    static class location {
        int x;
        int y;
        int z;

        public location(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static Queue<location> locationQueue ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while (true) {
            locationQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            boolean success = false;
            int cnt = 0;

            if (L == 0 && R == 0 && C == 0) {
                return;
            }

            building = new char[R][C][L];
            visited = new int[R][C][L];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[j][k][i] = str.charAt(k);
                        //System.out.print(building[j][k][i]);

                        if (building[j][k][i] == 'S') {

                            locationQueue.add(new location(j, k, i));
                            visited[j][k][i] = 1;
                        }
                    }
                }
                st = new StringTokenizer(br.readLine());
            }


            while (!locationQueue.isEmpty()) {
                location loc = locationQueue.poll();

                //System.out.println("원래의 x,y,z 좌표" + toto.x + " " + toto.y + " " + toto.z);

                for (int i = 0; i < 6; i++) {
                    int nx = dx[i] + loc.x;
                    int ny = dy[i] + loc.y;
                    int nz = dz[i] + loc.z;

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L && visited[nx][ny][nz] == 0) {
                        //System.out.println("들어오는 아이 " + nx + " " + ny + " " + nz + " " );

                        if (building[nx][ny][nz] == '.') {
                            visited[nx][ny][nz] = visited[loc.x][loc.y][loc.z] + 1;
                            locationQueue.add(new location(nx, ny, nz));
                        } else if (building[nx][ny][nz] == 'E') {
                            success = true;
                            cnt = (visited[loc.x][loc.y][loc.z]);
                            //System.out.println("Escaped in " + (visited[loc.x][loc.y][loc.z]) +" minute(s).");
                            break;
                        }
                    }
                }
            }

            if(success)
                System.out.println("Escaped in " + cnt +" minute(s).");
            else
                System.out.println("Trapped!");
        }
    }
}

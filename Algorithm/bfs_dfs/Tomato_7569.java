package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7569 {

    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    static class pair{
        int x;
        int y;
        int z;

        public pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x, y, z;
        int[][][] tomato;
        Queue<pair> tomatoqueue = new LinkedList<>();

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        tomato = new int[x][y][z];

        //입력
        for(int i=0; i<z; i++) {
            for(int j=0; j<x; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<y; k++) {
                    tomato[j][k][i] = Integer.parseInt(st.nextToken());

                    if(tomato[j][k][i] == 1) {
                        tomatoqueue.add(new pair(j,k,i));
                    }
                }
            }
        }

        //3차원 큐 풀기!
        while ( !tomatoqueue.isEmpty() ) {
            pair toto = tomatoqueue.poll();

            //System.out.println("원래의 x,y,z 좌표" + toto.x + " " + toto.y + " " + toto.z);

            for(int i=0; i<6; i++) {
                int nx = dx[i] + toto.x;
                int ny = dy[i] + toto.y;
                int nz = dz[i] + toto.z;

                if(nx >=0 && nx < x && ny >=0 && ny < y && nz >=0 && nz < z && tomato[nx][ny][nz] == 0) {
                    //System.out.println("들어오는 아이 " + nx + " " + ny + " " + nz + " " );
                    tomato[nx][ny][nz] = tomato[toto.x][toto.y][toto.z] + 1;
                    tomatoqueue.add(new pair(nx, ny, nz));
                }
            }
        }

        int cnt =0;


        for(int i=0; i<z; i++) {
            for(int j=0; j<x; j++) {
                for(int k=0; k<y; k++) {
                    if(tomato[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if(cnt < tomato[j][k][i]) {
                        cnt = tomato[j][k][i];
                    }
                }
            }
        }

        System.out.println(cnt-1);
    }


    public static void printArr(int x, int y, int z, int[][][] tomato) {

        for(int i=0; i<z; i++) {
            for(int j=0; j<x; j++) {
                for(int k=0; k<y; k++) {

                    System.out.print(tomato[j][k][i]);
                }
                System.out.println();
            }
        }
    }
}

package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscapeMaze_16954 {

    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1}; //그 자리 그대로, 상하좌우(뒤죽이박죽이), 대각선위, 대각선 아래
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};
    static char[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maze = new char[8][8];
        int nx, ny;

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        maze[7][0] = Integer.toString(1).charAt(0);

        for(int k=1; k<=8; k++) {
            char target = Integer.toString(k).charAt(0);

            for(int x=7; x>=0; x--) {
                for(int y=0; y<8; y++) {
                    if(maze[x][y] == target) {
                        for(int i=0; i < 8; i++) {
                            nx = x + dx[i];
                            ny = y + dy[i];

                            if(nx >=0 && nx < 8 && ny >=0 && ny < 8 && maze[nx][ny] != '#'&& maze[nx][ny] != target) {
                                maze[nx][ny] = Integer.toString(k+1).charAt(0);
                            }
                        }
                        maze[x][y] = Integer.toString(k+1).charAt(0);

                        /*System.out.println("======================");
                        for(int jj =0; jj<8; jj++) {
                            System.out.println(Arrays.toString(maze[jj]));
                        }

                        System.out.println("======================");*/
                    }
                }
            }

            moveMap();

          /*  System.out.println("1번의 루틴이 끝난 상태 ======================");
            for(int jj =0; jj<8; jj++) {
                System.out.println(Arrays.toString(maze[jj]));
            }

            System.out.println("======================");*/

        }

        //모든 벽이 내려온 상태일 것! maze에 '.'이 아닌 것이 하나라도 존재하면 1출력, 아니면 0출력
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(maze[i][j] != '.') {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    public static void moveMap() {
        //벽 한칸 내리기 아래부터
        for(int i=0; i<8; i++) {
            if(maze[7][i] == '#')
                maze[7][i] = '.';
        }

        for(int i=6; i>=0; i--) {
            for(int j=0; j<8; j++) {
                if(maze[i][j] == '#') {
                    maze[i][j] = '.';
                    maze[i+1][j] = '#';
                }
            }
        }
    }
}

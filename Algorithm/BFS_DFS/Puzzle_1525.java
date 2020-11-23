package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Puzzle_1525 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] puzzle = new int[3][3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++) {
                puzzle[0][0] = Integer.parseInt(st.nextToken());
            }
        }

        



    }
}

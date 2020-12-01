package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindRightIsoscelesTriangle_2658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[10][10];
        int[][] ans = new int[3][2];

        for(int i=0; i<10; i++) {
            String str = br.readLine();
            for(int j=0; j<10; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j));
            }
        }

        

    }
}

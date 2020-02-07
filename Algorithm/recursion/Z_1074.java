package Algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

    static int cnt=0;
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        Z_Recursion(getSize(size), 0, 0);

    }

    public static void Z_Recursion(int size, int r, int c) {

        if (size == 1) {
            if(r == row && c == col ) {
                System.out.println(cnt);
            }
            else cnt++;
        }else {
            //1사분면
            Z_Recursion(size/2, r, c);
            //2사분면
            Z_Recursion(size/2, r, size/2+c);
            //3사분면
            Z_Recursion(size/2, size/2+r, c);
            //4사분면
            Z_Recursion(size/2, size/2+r, size/2+c);
        }
    }

    public static int getSize(int size) {
        int s =1;
        for(int i= 0; i< size; i++) {
            s = 2*s;
        }
        return s;
    }
}

package Algorithm.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Chess_1846 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 3) System.out.println(-1);
        else if (n%2 == 0) {
            System.out.println(n/2);

            for(int i=1; i<n/2; i++)
                System.out.println(i);
            for(int i=n/2+2; i <= n; i++)
                System.out.println(i);

            System.out.println(n/2+1);
        }
        else {
            System.out.println(n-2);
            for(int i=1; i<n-2; i++) {
                System.out.println(i);
            }
            System.out.println(n);
            System.out.println(n-1);
        }

    }
}

package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_2446 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n/2; i++) {

            for(int j =0; j<i; j++) {
                System.out.print(" ");
            }

            for(int j=i; j<n-i; j++) {
                System.out.print("X");
            }
            System.out.println();
        }


        for(int i=n/2; i>=0; i--) {
            if(n%2 == 0 && i == n/2) continue;
            for(int j = 0; j<i; j++) {
                System.out.print(" ");
            }

            for(int j=0; j<n-(2*i); j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}

package Algorithm.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decomposition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int k = N;
        boolean isRight = false;

        while(k<N) {
            //100의자리
            int y = k%100;
            //10의자리
            int n1 = y/10;
            //1의자리
            int n2 = y%10;

            if(N == k+y+n1+n2){
                isRight = true;
                System.out.println(k);
                break;
            }

            k++;
        }

        if(!isRight) {
            System.out.println("0");
        }

    }
}

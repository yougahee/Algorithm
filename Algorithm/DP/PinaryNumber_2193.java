package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber_2193 {

    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new long[N+2];

        System.out.println(pinarynum(N));
    }

    static long pinarynum(int num) {
        arr[1] =1;
        arr[2] =1;
        for(int i=3; i<=num; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[num];
    }
}

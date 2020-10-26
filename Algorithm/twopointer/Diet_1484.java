package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Diet_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxSize = 50000;
        int G = Integer.parseInt(br.readLine());
        long[] arr = new long[maxSize];

        for(int i=0; i<arr.length; i++) {
            arr[i] = (long) Math.pow(i+1, 2);
        }

        int left = 0, right = 0;
        long sub =0;
        boolean isTrue = false;

        while (true) {
            if( left == maxSize ) break;

            sub = arr[right] - arr[left];
            if( sub == G ) {
                isTrue = true;
                System.out.println(right+1);
            }

            if( right < maxSize-1 && sub < G) {
                right++;
            }else {
                left++;
            }
        }

        if(!isTrue) System.out.println(-1);
    }
}

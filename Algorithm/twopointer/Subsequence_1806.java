package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Subsequence_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right =0, sum = arr[0];
        while (true) {
            //System.out.println("left : " + left + " right : " + right +" sum : " + sum);
            if(left == N) break;
            if(S <= sum) {
                min = Math.min(min, right - left + 1);
            }

            if(right < N-1 && sum < S) {
                right++;
                sum += arr[right];
            }
            else {
                sum -= arr[left];
                left++;
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}

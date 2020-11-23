package Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumber_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long left = 1, middle=0, ans=0;
        long right = K;
        long cnt;

        while (left <= right) {
            cnt=0;
            middle = (left + right ) / 2;

            for(int i=1; i<=N; i++)
                cnt += Math.min(middle/i , N);

            //System.out.println("cnt : " + cnt + " middle : " + middle);

            if(cnt < K) {
                left = middle + 1;
            }else {
                ans = middle;
                right = middle -1;
            }
        }
        System.out.println(ans);
    }
}

package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LogJumping_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] ans = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int le=0, ri=N-1, mid = N/2;
            for(int j=0; j<N; j++) {
                if(j%2 == 0) ans[le++] = arr[j];
                else ans[ri--] = arr[j];
            }
            ans[mid] = arr[N-1];

            int max = 0;
            for(int j=0; j<N; j++) {
                max = Math.max(Math.abs(ans[j] - ans[(j+1) % N]), max);
            }

            System.out.println(max);
        }
    }
}

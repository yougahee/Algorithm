package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//답 봄..
public class Scale_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        long[] sum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) weight[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(weight);

        for(int i=1; i<=N; i++) sum[i] = sum[i-1] + weight[i-1];

        for(int i=0; i<N; i++) {
            if(sum[i]+2 <= weight[i]) {
                System.out.println(sum[i]+1);
                return;
            }
        }

        System.out.println(sum[N]+1);
    }
}

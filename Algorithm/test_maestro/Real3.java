package Algorithm.test_maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Real3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int cost=0;
        int min = 100000;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(N == K) {
            cost =0;
        }
        //확인필요
        else if(K == 1) {
            cost = arr[N-1] - arr[0];
        }
        else {
            for(int i=0; i<K; i++) {
                min = Math.min(min, arr[N-K+i]-arr[i]);
            }
            cost = min;
        }

        System.out.println(cost);
    }
}

package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNum_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, answer = 0;
        int start=0, end=0, sum=0;
        int[] arr;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //시간복잡도 O(N)
        while(true) {
            if(sum >= m) sum -= arr[start++];
            else if(end == n) break;
            else sum += arr[end++];

            if(sum == m) answer++;
        }

        System.out.println(answer);
    }
}

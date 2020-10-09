package Algorithm.test_maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt =0;
        int left = 0;
        int right =0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st =  new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1 ) {
                left = i;
                right = i;
            }
        }

        //왼쪽
        while(left > 0) {
            cnt++;
            left = left - K +1;
        }

        //오른쪽
        while(right < N) {
            cnt++;
            right = right + K -1;
        }

        System.out.println(cnt);
    }
}

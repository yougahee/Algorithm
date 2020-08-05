package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Repairman_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, L;
        int loc, cnt=1;

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] location = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(location);
        loc = location[0];

        for(int i=0; i<N; i++) {

            if(location[i] - loc > L-1 ) {
                loc = location[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

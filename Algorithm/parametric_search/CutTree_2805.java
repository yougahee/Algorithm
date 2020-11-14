package Algorithm.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] height = new int[N];

        long left =0, right = height[N-1], mid =0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, height[i]);
        }

        while (left <= right) {
            mid = (left + right ) /2;

            if( cntTree(height, mid) >= M ) {
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }

        System.out.println(right);
    }

    public static long cntTree(int[] height, long mid) {
        long cnt = 0;

        for(int a : height) {
            if(a > mid)
                cnt += a - mid;
        }

        return cnt;
    }
}

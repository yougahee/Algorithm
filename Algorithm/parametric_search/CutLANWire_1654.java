package Algorithm.parametric_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutLANWire_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lan = new long[K];

        long min = 1, max = 0, mid = 0, cnt =0, ans=0;
        for(int i=0; i<K; i++) {
            lan[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lan[i]);
        }

        while (min <= max) {
            cnt = 0;
            mid = (min + max) / 2;

            for(long a : lan) {
                if(mid != 0) cnt += a/mid;
            }

            //UpperBound, LowerBound
            //중복되는 값 중, 최대의 값을 보장하는 것?
            if(cnt >= N) {
                ans = mid;
                min = mid + 1;
            }
            else max = mid - 1;
        }

        System.out.println(ans);
    }
}

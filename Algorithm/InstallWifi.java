package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallWifi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];

        for(int i=0; i<N; i++) home[i] = Integer.parseInt(br.readLine());
        Arrays.sort(home);

        int min = 1, max = home[N-1] - home[0], mid;
        int cnt, result =0, value;

        while (min <= max) {
            mid = (min + max) / 2;
            value = home[0];
            cnt = 1;

            for(int i=0; i<N; i++){
                if(home[i] >= value + mid ){
                    value = home[i];
                    cnt++;
                }
            }

            if(cnt >= C) {
                min = mid + 1;
                result = mid;
            }else {
                max = mid - 1;
                result = max;
            }
        }

        System.out.println(result);
    }
}

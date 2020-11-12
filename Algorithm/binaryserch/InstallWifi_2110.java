package Algorithm.binaryserch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallWifi_2110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n,c,value=0;
        int[] arr;

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = arr[n-1] - arr[0];
        int min = 1;
        int result =0;
        int mid=0;

        while(min <= max){
            mid = (max + min)/2;
            value = arr[0];
            int cnt =1;

            for(int i=0; i<n; i++) {
                if(arr[i] >= value+mid) {
                    value = arr[i];
                    cnt++;
                }
            }

            if(cnt >= c) {
                min = mid +1;
                result = mid;
            }
            else {
                max = mid-1;
                result = max;
            }
        }
        System.out.println(result);
    }
}

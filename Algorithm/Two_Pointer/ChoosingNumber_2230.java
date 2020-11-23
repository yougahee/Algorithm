package Algorithm.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChoosingNumber_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left=0, right=0, sub = 0;
        while (true) {
            if(left == n-1) break;
            if(sub >= m){
                min = Math.min(sub, min);
            }

            if(right < n-1 && sub < m) {
                right++;
                sub = arr[right] - arr[left];
            }else {
                left++;
                sub = arr[right] - arr[left];
            }
        }

        System.out.println(min);
    }
}

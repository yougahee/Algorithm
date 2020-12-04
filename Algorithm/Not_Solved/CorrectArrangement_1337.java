package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CorrectArrangement_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        int cnt = 1, max = 1;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            long value = arr[i];
            cnt = 1;
            for(int j=i+1; j < N; j++) {
                if(value + 4 < arr[j]) break;
                cnt++;

                max = Math.max(cnt, max);
                if(max == 5) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(5-max);
    }
}

package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsecutiveSumofPrimeNumbers_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[4000001];
        boolean[] prime = new boolean[4000001];
        int cnt = 0;

        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) continue;
            int x = 1;
            while (i * x <= n) {
                prime[i*x] = true;
                x++;
            }
            arr[index++] = i;
        }

        int left = 0, right = 0, sum = arr[0];
        while (true) {
            //System.out.println("left : " + left + " right : " + right +" sum : " + sum);
            if (left == index) break;
            if (sum == n) {
                cnt++;
            }

            if (sum < n && right < index-1) {
                right++;
                sum += arr[right];
            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(cnt);
    }
}

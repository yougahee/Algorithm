package Algorithm.Eratosthenes_Sieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eratosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt =0;

        boolean[] prime = new boolean[n+1];

        loop:
        for(int i = 2; i<n+1; i++) {
            if(!prime[i]) {
                int index = 1;

                while (i*index <= n) {
                    if(!prime[i*index]) {
                        cnt++;
                        prime[i*index] = true;
                    }

                    if(cnt == k) {
                        System.out.println(i*index);
                        break loop;
                    }
                    index++;
                }
            }
        }
    }
}

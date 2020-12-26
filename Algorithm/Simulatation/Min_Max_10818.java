package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min_Max_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int value = Integer.parseInt(st.nextToken());

            min = Math.min(value, min);
            max = Math.max(value, max);
        }

        System.out.println(min + " " + max);
    }
}

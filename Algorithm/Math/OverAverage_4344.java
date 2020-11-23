package Algorithm.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OverAverage_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            int sum =0;
            int[] student = new int[size];
            for(int j=0; j<size; j++) {
                student[j] = Integer.parseInt(st.nextToken());
                sum += student[j];
            }

            double avg = (double) sum/ (double) size;
            int cnt =0;
            for( int value : student ){
                if(value > avg) cnt++;
            }

            double ans = (double) cnt/ (double) size * 100;
            System.out.println(String.format("%.3f", ans) + "%");
        }
    }
}

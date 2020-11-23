package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumPrize_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int max =0;


        for(int i=0; i<testCase; i++) {

            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int exchangeNum = Integer.parseInt(st.nextToken());


            



            System.out.println("#"+i+ " " + max);
        }
    }
}

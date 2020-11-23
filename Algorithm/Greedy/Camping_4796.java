package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L =1;
        int P;
        int V;
        int day, cnt=1;

        while (L !=0) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            day=0;

            if(L ==0) {
                break;
            }

            while (V - P > 0) {
                day += L;
                V = V-P;
            }

            if(V<=L) {
                day += V;
                System.out.println("Case "+ cnt++ + ": " + day);
            }
            else {
                day += L;
                System.out.println("Case "+ cnt++ + ": " + day);

            }

        }

    }
}

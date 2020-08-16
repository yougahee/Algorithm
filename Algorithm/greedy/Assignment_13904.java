package Algorithm.greedy;

import javax.swing.plaf.basic.BasicIconFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//유니온파인드
public class Assignment_13904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int d, w, sum = 0;
        int[] dp = new int[1001];
        ArrayList<Assignment> assignment = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            assignment.add(new Assignment(d, w));
        }

        Collections.sort(assignment);

        /*for(Assignment as : assignment) {
            System.out.println(as.duration + "  " + as.score);
        }
*/
        int du;
        int temp_d, temp_s;

        for(int i = 0; i<n; i++) {
            du = assignment.get(i).duration;

            for(int j = du; j >0; j--) {
                if(dp[j] == 0) {
                    dp[j] = 1;
                    sum += assignment.get(i).score;
                    break;
                }
            }

//            for(Assignment as : assignment) {
//                System.out.println(as.duration + "  " + as.score);
//            }
//            System.out.println("=====================");
        }

        System.out.println(sum);
    }

    static class Assignment implements Comparable<Assignment> {
        int duration;
        int score;

        public Assignment(int d, int s) {
            this.duration = d;
            this.score = s;
        }

        @Override
        public int compareTo(Assignment o) {
            int r = o.score - this.score;
            if(r == 0)
                r = this.duration - o.duration;
            return r;
        }
    }
}

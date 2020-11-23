package Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget_2512 {
    static int N, budget;
    static int[] country;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        country = new int[N];
        int left=1, right, middle;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            country[i] = Integer.parseInt(st.nextToken());
        }

        budget = Integer.parseInt(br.readLine());

        Arrays.sort(country);
        right = country[N-1];

        while (true) {
            middle = (left + right + 1) / 2;

            if(right == left) {
                System.out.println(left);
                return;
            }

            int cnt = isOverBudget(middle);

            if(cnt == budget){
                System.out.println(middle);
                return;
            }

                //right 가 변함
            else if(cnt > budget) {
                right = middle-1;
            }
                //left가 변함
            else if(cnt < budget) {
                left = middle;
            }

        }
    }

    public static int isOverBudget(int middle) {
        int cnt =0;

        for(int i=0; i<N; i++) {
            if(middle < country[i]){
                cnt += middle;
            }else {
                cnt += country[i];
            }
        }
        return cnt;

    }
}

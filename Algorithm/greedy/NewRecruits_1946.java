package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewRecruits_1946 {
    static int[] ranking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int n, index, value, cnt = 1;
        int max;

        for (int i = 0; i < size; i++) {
            n = Integer.parseInt(br.readLine());
            ranking = new int[n + 1];
            max = 1;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                index = Integer.parseInt(st.nextToken());
                value = Integer.parseInt(st.nextToken());

                ranking[index] = value;
            }

            value = ranking[1];
            cnt = 1;

            //차례대로 하나씩 선택했을 경우,
            for (int k = 2; k <= n; k++) {

                if (value > ranking[k]) {
                    //System.out.println("여기를 들어와서의 최소값 : " + value );
                    cnt++;
                    value = ranking[k];
                }
            }

            System.out.println(cnt);
        }
    }
}

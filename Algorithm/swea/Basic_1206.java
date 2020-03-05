package Algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Basic_1206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int building[];
        int N;

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            building = new int[N];
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                building[j] = Integer.parseInt(st.nextToken());
            }

            for (int k = 2; k < N - 2; k++) {
                int distance[]= new int[4];
                distance[0] = building[k] - building[k - 1];
                distance[1] = building[k] - building[k - 2];
                distance[2] = building[k] - building[k + 1];
                distance[3] = building[k] - building[k + 2];

                if(distance[0] >0 && distance[1] >0 && distance[2] >0 && distance[3] >0) {
                    Arrays.sort(distance);
                    result += distance[0];
                }else{
                    continue;
                }
            }

            System.out.println("#"+i+" "+ result);

        }

    }
}

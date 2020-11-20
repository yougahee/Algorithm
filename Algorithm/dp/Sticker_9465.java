package Algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Sticker_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[N][2];

            for(int k=0; k<2; k++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            System.out.println();
        }
    }
}

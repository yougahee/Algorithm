package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];

            for(int k=0; k<2; k++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    sticker[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(N==1) {
                System.out.println(Math.max(sticker[1][0], sticker[0][0]));
                return;
            }

            sticker[0][1] += sticker[1][0];
            sticker[1][1] += sticker[0][0];

            for(int k=2; k<N; k++) {
                sticker[0][k] += Math.max(sticker[1][k-1], sticker[1][k-2]);
                sticker[1][k] += Math.max(sticker[0][k-1], sticker[0][k-2]);
            }

            System.out.println(Math.max(sticker[0][N-1], sticker[1][N-1]));
        }
    }
}

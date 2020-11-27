package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessRepainting_1018 {

    static char[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new char[N][M];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                chess[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<=N-8; i++) {
            for(int j=0; j<=M-8; j++) {
                min = Math.min(min, findRePaint(i,j));
            }
        }

        System.out.println(min);
    }

    static int findRePaint(int x, int y) {
        int cnt = 0;
        for(int i=x; i<x+8; i++) {
            for(int j=y; j<y+8; j++) {
                if( ( i+j ) % 2 == 0) {
                    if( chess[i][j] != 'B' ) cnt++;
                }else {
                    if(chess[i][j] != 'W') cnt++;
                }
            }
        }

        return Math.min(cnt, 64-cnt);
    }


}

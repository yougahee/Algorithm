package Algorithm.floydwarshall;

import Algorithm.swea.MaximumPrize_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int MAX = 1000000000;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] bus = new int[100][100];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bus[i][j] = i == j ? 0 : MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            int a, b, c;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            bus[a - 1][b - 1] = Math.min(bus[a - 1][b - 1], c);
        }

        // 플로이드 와샬 알고리즘 적용
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    bus[i][j] = Math.min(bus[i][j], bus[i][k] + bus[k][j]);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                if(bus[i][j] >= MAX)
                    System.out.println("0 ");
                else
                    System.out.print(bus[i][j] + " ");
            System.out.println();
        }

    }
}

package Algorithm.Prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakePrefixSum_11660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        int[][] prefixMap = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                prefixMap[i+1][j+1] = prefixMap[i][j+1] + prefixMap[i+1][j] - prefixMap[i][j] + map[i][j];
            }
        }

        int x1,y1,x2,y2;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(prefixMap[x2][y2] - prefixMap[x1-1][y2]
                    - prefixMap[x2][y1-1] + prefixMap[x1-1][y1-1]);
        }
    }
}

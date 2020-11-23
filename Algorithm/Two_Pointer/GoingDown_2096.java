package Algorithm.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoingDown_2096 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;
        int[] maxCol = new int[3], maxTemp = new int[3];
        int[] minCol = new int[3], minTemp = new int[3];

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                maxTemp[j] = Integer.parseInt(st.nextToken());
                minTemp[j] = maxTemp[j];

                maxTemp[j] += Math.max(maxCol[1], (j == 1) ? Math.max(maxCol[0], maxCol[2]) : maxCol[j]);
                minTemp[j] += Math.min(minCol[1], (j == 1) ? Math.min(minCol[0], minCol[2]) : minCol[j]);
            }

            maxCol = maxTemp.clone();
            minCol = minTemp.clone();
        }

        Arrays.sort(maxCol);
        Arrays.sort(minCol);

        System.out.println(maxCol[2] + " " + minCol[0]);
    }
}

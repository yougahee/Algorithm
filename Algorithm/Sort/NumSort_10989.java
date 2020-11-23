package Algorithm.Sort;

import java.io.*;

public class NumSort_10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < input; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    bw.write(Integer.toString(i) + "\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}

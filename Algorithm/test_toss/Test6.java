package Algorithm.test_toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0";

        String[] input_string = input.split(";");
        int n = input_string.length;
        int m = input_string[0].split(" ").length;
        String[][] arr = new String[n][m];
        System.out.println(Arrays.toString(input_string));

        for (int i = 0; i < n; i++) {
            String[] a = input_string[i].split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = a[j];
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}

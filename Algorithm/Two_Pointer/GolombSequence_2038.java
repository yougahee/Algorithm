package Algorithm.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GolombSequence_2038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        long sum = 0;
        int index = 1;
        int[] arr = new int[700000];
        arr[1] = 1;

        while (true) {
            sum += arr[index];

            if( sum >= N ) {
                System.out.println(index);
                break;
            }

            index++;
            arr[index] = 1 + arr[index - arr[arr[index-1]]];
        }
    }
}

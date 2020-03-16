package Algorithm.maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Real1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[] = {6,2,5,5,4,5,6,3,7,6};
        int data[] = new int[9];

        for(int i=0; i<10; i++) {
            if(N>= arr[i]) {
                //배열에 저장을 하거나,,
                data[i] = arr[i];
            }
        }
        Permutation(arr, data, 0, 3);

    }


    public static void Permutation(int[] arr, int[] output, int step, int n) {
        if(n == step) {
            System.out.println(Arrays.toString(output));
        }else{
            for(int i=0; i<n; i++) {
                output[step] = arr[i];
                Permutation(arr, output, step+1, n);
            }
        }
    }
}

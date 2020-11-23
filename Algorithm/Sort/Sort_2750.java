package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort_2750 {
    public static void main(String[] args) throws Exception {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        //내림차순
        //Integer로 바꿔줘야 가능..!!!!!
        //Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i< N; i++) {
            System.out.println(arr[i]);
        }
    }
}

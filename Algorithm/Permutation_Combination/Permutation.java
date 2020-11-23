package Algorithm.Permutation_Combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
    public static void main(String[] args) throws Exception {

        int[] arr;
        int inputCase;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputCase = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[inputCase];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int r =2;

        int[] output = new int[r];
        boolean[] visited = new boolean[arr.length];

        //순열
        Permutation(arr, output,visited, 0, arr.length, r);

        //중복순열
//        repermutation(arr, output, 0  , arr.length, r);

 //     orderPerm(arr, output, visited, 0, arr.length, 2);

        comb(arr, output, 0, arr.length, 2, 0);

    }

    // 조합
    public static void comb(int[] arr, int[] output, int step, int n, int r, int target) {
        if (r == 0) {
            System.out.println(Arrays.toString(output));
        } else if (target == n) return;
        else {
            output[step] = arr[target];

            comb(arr, output, step + 1, n, r - 1, target + 1);
            comb(arr, output, step, n, r, target + 1);
        }
    }

    //순열(nPr)
    public static void Permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {

        if(r == depth){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                Permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
                output[depth] =0;
            }
        }
    }


    //중복순열nㅠr
    public static void repermutation(int[] arr, int[] output, int depth, int n, int r) {

        if(r == depth) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            output[depth] = arr[i];
            repermutation(arr, output, depth+1, n, r);
        }
    }

}
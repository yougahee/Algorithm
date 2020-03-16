package Algorithm.permu_combi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermuCombi {
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

        int[] output = new int[2];
        boolean[] visited = new boolean[arr.length];

        Permutation(arr, output,0, arr.length);

 //     orderPerm(arr, output, visited, 0, arr.length, 2);

 //       comb(arr, output, 0, arr.length, 2, 0);

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

    // 순서 있는 순열
    public static void orderPerm(int[] arr, int[] output, boolean[] visited, int step, int n, int r) {
        if (step == r) {
            System.out.println(Arrays.toString(output));
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[step] = arr[i];
                    orderPerm(arr, output, visited, step + 1, n, r);

                    visited[i] = false;
                }
            }
        }
    }

    // 순서 필요없는 순열
    // 이거 뭔가 아닌듯,,,
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
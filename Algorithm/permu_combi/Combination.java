package Algorithm.permu_combi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {

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

        comb(arr, output,  arr.length, r, 0, 0);

        //recomb(arr, output,  arr.length, r, 0, 0);

    }

    //조합(중복X)
    public static void comb(int[] arr, int[] output, int n, int r, int index, int target) {

        if(r == 0) System.out.println(Arrays.toString(output));
        else if(target == n) return;
        else{
            output[index] = arr[target];
            comb(arr, output,n,r-1, index+1, target+1);//뽑는 경우
            comb(arr, output, n, r, index, target+1);//안뽑는 경우
        }
    }

    //중복조합
    public static void recomb(int[] arr, int[] output, int n, int r, int index, int target) {
        if(r ==0) System.out.println(Arrays.toString(output));
        else if(target == n) return;
        else {
            output[index] = arr[target];
            recomb(arr, output, n, r-1, index+1, target); //뽑는 경우
            recomb(arr, output, n, r, index, target+1); //안뽑는 경우
        }
    }
}

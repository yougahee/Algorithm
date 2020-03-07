package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AddOperator_14888 {

    static int N;
    static int arr[];
    static int operatorNum[] = new int[4]; //덧, 뺄, 곱, 나
    static int combiOperator[];
    static int max = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt =0;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int out[] = new int[N-1];
        combiOperator = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operatorNum[i] = Integer.parseInt(st.nextToken());
            for(int j=0; j<operatorNum[i]; j++) {
                combiOperator[cnt++] =i;
            }
        }

        permu(combiOperator, out, 0, N-1);


    }

    public static void permu(int arr[], int out[], int step, int n) {

      if(step == n){

          System.out.println(Arrays.toString(out));
        }else {
            for(int i=0; i<n; i++) {

                out[step] = arr[i];

                permu(arr, out, step + 1, n);
            }
        }

    }


}

package Algorithm.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AddOperator_14888 {

    static int N;
    static int arr[];
    static int operator[];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operator = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //연산자 4개 개수 입력
        int cnt=0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<5; i++) {
            int a = Integer.parseInt(st.nextToken());
            for(int j=0; j<a; j++) {
                operator[cnt++] = i;
            }
        }

        permutation(0);
        System.out.println(max);
        System.out.println(min);
    }

    //중복없는 순열
    public static void permutation(int depth) {

        if(depth == N-1){
            calculator();
            return;
        }

        for(int i=depth; i<N-1; i++) {
            swap(depth, i);
            permutation(depth+1);
            swap(i, depth);
        }
    }

    public static void swap(int i, int j) {

        int temp = operator[i];
        operator[i] = operator[j];
        operator[j] = temp;

    }

    //계산
    public static void calculator() {
        int result = arr[0];

        for(int i=0; i< N-1; i++) {
            switch (operator[i]){
                case 1:
                    result = result + arr[i+1];
                    break;
                case 2:
                    result = result - arr[i+1];
                    break;
                case 3:
                    result = result * arr[i+1];
                    break;
                case 4:
                    result = result / arr[i+1];
                    break;
            }
        }

        min = Integer.min(min, result);
        max = Integer.max(max, result);
    }
}

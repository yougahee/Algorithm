package Algorithm.study20200802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrepareCamp_16938 {
    static int cnt = 0;
    static int L,R,X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] problem = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        //2개부터 N개의 수를 사용하여 조합 만들기
        for(int i=2; i<=N; i++) {
            int[] output = new int[i];
            Combi(problem, output, N, i, 0,0);
        }

        System.out.println(cnt);
    }

    //조합
    public static void Combi(int[] arr, int[] output, int n, int r, int index, int target) {

        if (r == 0) {
            Count(output);
            return;
        }
        else if (target == n) {
            return;
        }
        output[index] = arr[target];
        Combi(arr, output, n,r-1, index+1, target+1);//뽑는 경우
        Combi(arr, output, n, r, index, target+1);//안뽑는 경우

    }


    //조건 만족
    public static void Count(int[] result) {

        int sum=0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<result.length; i++) {
            sum += result[i];
            min = Math.min(min, result[i]);
            max = Math.max(max, result[i]);
        }

        if(sum >=L && sum <=R && (max - min) >= X) {
            cnt++;
        }
    }
}

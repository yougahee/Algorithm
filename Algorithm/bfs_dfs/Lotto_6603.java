package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lotto_6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] output = new int[6];

            if(N == 0) break;

            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            Combi(arr, output, N, 6, 0,0);
            System.out.println();
        }
    }

    public static void Combi(int[] arr, int[] output, int n, int r, int index, int target) {

        if(r == 0) {
            //System.out.println(Arrays.toString(output));

            for(int i=0; i<6; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        else if( n == target ) return;

        else {

            output[index] = arr[target];
            Combi(arr, output, n, r-1, index+1, target+1); //뽑는경우
            Combi(arr, output, n, r, index, target+1); //안뽑는경우
        }

    }
}

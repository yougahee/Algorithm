package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ConveyorBeltSushi_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        int N, d, k, c;
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        int kind = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++) {
            set.clear();
            for(int j=0; j<k; j++) {
                set.add(arr[(i+j)%N]);
            }
            set.add(c);
            kind = Math.max(kind, set.size());
        }

        System.out.println(kind);
    }
}

package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepresentationSet_1717 {
    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int p,a,b;

        set = new int[N+1];

        for(int i=1; i<=N; i++) {
            set[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(p == 0) {
                union(a,b);
            }else {
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    static int find(int n) {
        if(set[n] == n) return n;
        set[n] = find(set[n]);
        return set[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;
        set[b] = a;
    }
}

package Algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Trip_1976 {

    static int[] capital;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        capital = new int[202];
        int connect, route;

        for(int i=1; i<=N; i++) {
            capital[i] = i;
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                connect = Integer.parseInt(st.nextToken());
                if(connect == 1) {
                    union(i, j);
                }
            }
        }

//
//        System.out.println("=====================");
//        System.out.println(Arrays.toString(capital));

        st = new StringTokenizer(br.readLine());
        route = Integer.parseInt(st.nextToken());
        route = find(route);

        for(int i=1; i<M; i++) {
            int a = Integer.parseInt(st.nextToken());

            //루트의 값이 다르면,
            if(route != find(a)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int n) {
        if(capital[n] == n) return n;
        capital[n] = find(capital[n]);
        return capital[n];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        capital[b] = a;
    }
}

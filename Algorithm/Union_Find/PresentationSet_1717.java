package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PresentationSet_1717 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;

        int a, b, u;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (u == 0) Union(a, b);
            else {
                if (Find(b) == Find(a)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);

        if (a == b) return;
        arr[a] = b;
    }

    public static int Find(int a) {
        if (arr[a] == a) return a;
        arr[a] = Find(arr[a]);
        return arr[a];
    }
}

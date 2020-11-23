package Algorithm.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TripExercise {

    static int[] capital;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        capital = new int[202];
        int connect, route;


        //반례를 모르겠음!!!!!!!!!!!!
        // 예상해보면,,,, 솔직히 왜 안되는지 모르곘음.!>!>!> 배열의 모든 곳에 (1,2) (2,1) 모두다 union을 시키면
        // 결국 모든 값에 대해서 루트에 있는 값으로 변하는 거 아닌가?!!?
        //왜 안되는지 이해가 안간다...
        Arrays.fill(capital, -1);

       /* for(int i=1; i<=N; i++) {
            capital[i] = i;
        }
*/
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                connect = Integer.parseInt(st.nextToken());
                if(connect == 1) {
                    union(i, j);
                }
            }
        }


        for(int i=1; i<=N; i++) {
            if(capital[i] == -1)
                capital[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        route = Integer.parseInt(st.nextToken());
        route = capital[route];

        for(int i=1; i<M; i++) {
            int a = Integer.parseInt(st.nextToken());

            //루트의 값이 다르면,
            if(route != capital[a]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int n) {
        if(capital[n] < 0) return n;
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

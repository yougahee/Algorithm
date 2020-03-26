package Algorithm.queueex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideSeek_17071 {

    static int X;
    static int K;
    static int map[];
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[500001];
        queue.add(X);
        map[X] = 1;

        location();
    }

    public static void location() {

        while (!queue.isEmpty()) {
            X=queue.poll();

            int add = k_location(map[X]);
            System.out.println(X + " " + add);

            if (X == K + add) {
                break;
            }
            if(K+add >500000) {
                System.out.println(-1);
                return;
            }
            if(X-1 >= 0) {
                queue.add(X-1);
                map[X-1] = map[X] +1;
            }
            if(X+1 <= 500000) {
                queue.add(X+1);
                map[X+1] = map[X] +1;
            }
            if(X*2 <= 500000) {
                queue.add(X*2);
                map[X*2] = map[X] +1;
            }
        }

        if(map[X] == 0) {
            System.out.println(-1);
        }else {
            System.out.println(map[X]-1);
        }

    }

    public static int k_location(int n) {
        int add=0;

        for(int i=0; i<n; i++) {
            add +=i;
        }
        return add;
    }
}
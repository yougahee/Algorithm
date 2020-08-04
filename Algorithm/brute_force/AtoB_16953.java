package Algorithm.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB_16953 {

    public static class pair {
        long val;
        int cnt;

        public pair(long v, int c) {
            this.val = v;
            this.cnt = c;
        }
    }

    public static void main(String[] args) throws IOException {
        int a, b;
        long result1, result2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Queue<pair> queue = new LinkedList<>();

        queue.add(new pair(a, 1));

        while (!queue.isEmpty()) {
            pair p = queue.poll();

            result1 = p.val * 2;
            result2 = p.val * 10 + 1;

            if (result1 == b || result2 == b) {
                System.out.println(p.cnt + 1);
                return;
            }

            if (result1 < b) {
                queue.add(new pair(result1, p.cnt + 1));
            }
            if (result2 < b) {
                queue.add(new pair(result2, p.cnt + 1));
            }
        }

        System.out.println(-1);
    }


}

package Algorithm.division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi_11729 {
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1,2,3);
        System.out.println(cnt);
        System.out.println(sb);

    }

    public static void hanoi(int n, int from, int by, int to) {
        cnt++;
        if(n == 1) {
            sb.append(from + " " + to+"\n");
            return;
        }else {
            hanoi(n-1, from, to, by);
            sb.append(from + " " + to+"\n");
            hanoi(n-1, by, from ,to);
        }

    }
}

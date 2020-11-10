package Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSorting_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));

        int cnt = 0;
        int value = 0;
        while (!pq.isEmpty()) {
            if(cnt % 2 == 0) value = pq.poll();
            else {
                value += pq.poll();
                pq.add(value);
                ans += value;
            }

            cnt++;
        }

        System.out.println(ans);
    }
}

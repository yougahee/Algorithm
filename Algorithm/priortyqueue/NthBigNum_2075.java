package Algorithm.priortyqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NthBigNum_2075 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                priorityQueue.add(Integer.parseInt(st.nextToken()));

                if(priorityQueue.size() > N) {
                    priorityQueue.poll();

                }
            }
        }

        System.out.println(priorityQueue.peek());
    }
}

package Algorithm.priortyqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class middle_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());
        int T = Integer.parseInt(br.readLine());
        int M;

        for(int i=0; i<T; i++) {
            M = Integer.parseInt(br.readLine());
            priorityQueueMax.clear();
            priorityQueueMin.clear();

            System.out.println(M/2+1);

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(priorityQueueMax.size() == priorityQueueMin.size()) {
                    if(j != 1 && priorityQueueMin.peek() < num) {
                        priorityQueueMax.add(priorityQueueMin.poll());
                        priorityQueueMin.add(num);
                    }else {
                        priorityQueueMax.add(num);
                    }
                }
                else {
                    if(priorityQueueMax.peek() > num) {
                        priorityQueueMin.add(priorityQueueMax.poll());
                        priorityQueueMax.add(num);
                    }else {
                        priorityQueueMin.add(num);
                    }
                }

                //홀수이면
                if(j%2 == 1) {
                    System.out.print(priorityQueueMax.peek() + " ");
                }
                //10의 배수
                if(j%10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                if(j% 20 == 0)
                    System.out.println();
            }

            System.out.println();

        }
    }
}

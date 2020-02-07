package Algorithm.queueex;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrintQue {

    public static void main(String[] args) {
        int testCase;
        int N=0;
        int M=0;
        int max =0;
        int cnt =0;
        int priority=0;
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for(int i=0; i< testCase; i++) {
            N = sc.nextInt();
            M = sc.nextInt();

            for(int j=0; j < N; j++){
                priority = sc.nextInt();
                queue.add(priority);

                if(max < priority){
                    max = priority;
                }
            }

            //실제 구현
            if(queue.peek() < max)
            {
                queue.add(queue.peek());
                queue.remove();
            }else if(queue.peek() == max) {
                queue.remove();
                cnt++;
            }




        }

        System.out.println();
    }
}

package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SK {
    public static void main(String[] args) {
        int result = 0;

        skSolution solution = new skSolution();

        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};

        System.out.println(Arrays.toString(solution.solution(deposit)));

    }
}

class skSolution {
    public int[] solution(int[] deposit) {
        int[] answer;
        Deque<Integer> queue = new LinkedList<>();

        int a;

        for(int i=0; i<deposit.length; i++){
            a = deposit[i];
            //양수이면
            if(a > 0) {
                queue.add(a);

                System.out.println(i + "더하기 " + queue.peekLast());
            }
            else{
                while(a < 0) {
                    a = queue.peekLast() + a;
                    queue.pollLast();
                    System.out.println(i + "뺴기 " + a);

                    if(a>0){
                        queue.addLast(a);
                        System.out.println("더하기" + queue.peekLast());
                        break;
                    }
                    if(a ==0 )
                        break;
                }
            }

        }

        answer = new int[queue.size()];
        for(int i=0; i<queue.size(); i++) {
            answer[i] = queue.pollFirst();
        }


        return answer;
    }
}
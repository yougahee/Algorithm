package Algorithm.test_line2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Line2 {
    public static void main(String[] args) {
        int[] ball = {1, 2, 3, 4, 5, 6};
        int[] order = {6, 2, 5, 1, 4, 3};

        System.out.println(Arrays.toString(solution(ball, order)));
    }

    public static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        ArrayList<Integer> orderArr = new ArrayList<>();

        Deque<Integer> deque = new LinkedList<>();

        for( int ballNum : ball) {
            deque.add(ballNum);
        }

        for(int orderNum : order) {
            orderArr.add(orderNum);
        }

        int index = 0, ansIdx=0;
        while (!deque.isEmpty()) {
            int num = orderArr.get(index);

            //맨앞에 존재하면,
            if(deque.peekFirst() == num) {
                answer[ansIdx++] = deque.pollFirst();
                orderArr.remove(index);
                index =0;
            }
            else if(deque.peekLast() == num) {
                answer[ansIdx++] = deque.pollLast();
                orderArr.remove(index);
                index =0;
            }
            //앞,뒤에도 없으면 보류,
            else {
                index++;
            }
        }

        return answer;
    }
}

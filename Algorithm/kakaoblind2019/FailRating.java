package Algorithm.kakaoblind2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FailRating {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        System.out.println(Arrays.toString(solution(N, stages)));
    }

    static class pair implements Comparable<pair>{
        int index;
        double fail;

        pair(int index, double fail) {
            this.index = index;
            this.fail = fail;
        }

        @Override
        public int compareTo(pair o) {
            //내림차순이라.. 이거 아닐 수도
            //System.out.println(this.fail - o.fail);
            double a = (this.fail - o.fail);
            //System.out.println(a);
            if(a < 0) return -1;
            else if(a > 0) return 1;
            if(a == 0)
                return o.index - this.index;
            return (int) a;
        }
    }

    static public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.reverseOrder());

        double a, b;
        double div;
        int k=0;
        a = stages.length;

        Arrays.sort(stages);

        for(int i=1; i<=N; i++) {
            int cnt = 0;
            for(int j=k; j<stages.length; j++) {
                if(stages[j] != i) {
                    k = j;
                    break;
                }
                cnt++;
            }

            b = cnt;

            if(a <=0){
                div =0;
            }
            else{
                div = b/a;
            }

            a = a-b;

            pq.add(new pair(i, div));
        }


        for(int i=0; i<N; i++){
            answer[i] = pq.poll().index;
        }

        return answer;
    }
}

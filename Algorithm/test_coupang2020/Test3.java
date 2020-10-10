package Algorithm.test_coupang2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Test3 {
    public static void main(String[] args) {
        int[] score = {24,22,20,10,5,3,2,1};
        System.out.println(solution(3, score));
    }

    public static int solution(int k, int[] score) {
        int answer = 0;
        boolean[] pattern = new boolean[score.length];
        int difference = 0;

        boolean isTrue;
        ArrayList<Score> scoreArr = new ArrayList<>();

        for(int i=1; i<score.length; i++) {
            isTrue = false;
            difference = score[i-1] - score[i];

            Iterator<Score> itr = scoreArr.iterator();
            while (itr.hasNext()) {
                Score element = itr.next();

                if(element.difference == difference) {
                    isTrue = true;
                    element.addIndex(i);
                    break;
                }
            }

            if(!isTrue)
                scoreArr.add(new Score(difference, i));
        }

        Iterator<Score> itr = scoreArr.iterator();
        while (itr.hasNext()) {
            Score element = itr.next();

            if(element.index.size() >= k) {
                for(int i=0; i<element.index.size(); i++) {
                    int num = element.index.get(i);
                    pattern[num] = true;
                    pattern[num-1] = true;
                }
            }
        }


        for(int i=0; i<pattern.length; i++) {
            if(!pattern[i])
                answer++;
        }

        return answer;
    }

    public static class Score {
        int difference;
        ArrayList<Integer> index;

        Score(int difference, int idx) {
            index = new ArrayList<>();
            index.add(idx);
            this.difference = difference;
        }

        public void addIndex(int idx) {
            index.add(idx);
        }
    }
}

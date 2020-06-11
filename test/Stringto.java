/*
package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Stringto {
    public void main(String[] args) {
        int result = 0;

        skSolution2 solution = new skSolution2();

        String[] company_name = {"warehouse", "parkworld", "eggandbacon", "xyz", "hellomark", "olive"};
        int[][] scores = {{74, 76, 65, 90, 75}, {95, 70, 85, 60, 65}, {75, 75, 75, 75, 80}, {90, 100, 85, 75, 70}, {100, 79, 100, 70, 79}, {70, 71, 100, 80, 39};

        System.out.println(Arrays.toString(solution.solution(company_name, scores)));

    }
    }


    class skSolution2 {
        public String[] solution(String[] company_names, int[][] scores) {
            String[] answer = {};

            //name과 80점 이상 영역개수, 총점을 저장.
            //compareto로 80점이상, 총점을 비교하고 정렬 후 출력

            int[] score = new int[scores.length];

            for (int i = 0; i < score.length; i++) {
                for (int j = 0; j < 5; j++) {

                    score[i] += scores[i][j];
                }
            }
        }

    }*/

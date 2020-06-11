package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Company {

    public static void main(String[] args) {
        int result = 0;

        skSolution1 solution = new skSolution1();

        String[] company_names={"warehouse", "parkworld", "eggandbacon", "xyz", "hellomark", "olive"};


        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};


        int[][] d = {{2,4}, {3,5}, {2,5}};
        int answer = solution.solution3(5, d, 5);
        System.out.println(answer);

    }
}

class skSolution1 {
    public String[] solution(String[] company_names, int[][] scores) {
        String[] answer = {};
        return answer;
    }

    public int solution3(int n, int[][] d, int k)
    {
        int answer = 0;

        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = i;
        }

        for(int i=0; i<d.length; i++) {
            int a = d[i][0];
            int b = d[i][1];

            int swap = arr[a];
            arr[a] = arr[b];
            arr[b] = swap;
         }


        for(int i=1; i<= n; i++){
            if(k==arr[i])
                answer =i;
        }
        return answer;
    }
}

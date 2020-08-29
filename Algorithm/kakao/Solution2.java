package Algorithm.kakao;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";

        ProblemSolve2 problemSolve2 = new ProblemSolve2();

        long arr = problemSolve2.solution(expression);
        System.out.println(arr);

    }
}

class ProblemSolve2 {

    static LinkedList<Integer> numList;
    static LinkedList<Character> opList;

    static Queue<Integer> numqueue;
    static Queue<Character> opqueue;

    public long solution(String expression) {
        long answer = 0;

        numList = new LinkedList<Integer>(); //숫자관련
        opList = new LinkedList<Character>();//연산자

        numqueue = new LinkedList<>();
        opqueue = new LinkedList<>();


        char[] operator = { '*', '-', '+'};
        char[] output = new char[3];
        boolean[] visited = new boolean[3];

        String num ="";

        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i); //string을 char 타입 단위로 나눔

            if(ch == '+' || ch =='-' || ch == '*' ) {
                numList.add(Integer.parseInt(num)); //숫자로 바꿔서 숫자배열에 추가
                opList.add(ch); //연산자를 연산자배열에 추가
                num = ""; //임시로 저장된 숫자를 비워준다
                continue; //제일 가까운 명령문으로 이동
            }
            num += ch; //연산자 앞까지의 숫자를 임시로 넣어 놓음
        }

        Permutation(operator, output, visited, 0, 3);


        return answer;
    }


    //순열(nPr)
    public static void Permutation(char[] arr, char[] output, boolean[] visited, int depth, int n) {

        if(n == depth){
            for(int i=0; i<output.length; i++) {
                char a = output[i];
                for(int j=0; j<opList.size(); j++) {
                    if(a == opList.get(i)) {

                    }else {
                    }
                }

            }

            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                Permutation(arr, output, visited, depth+1, n);
                visited[i] = false;
                output[depth] =0;
            }
        }
    }

}
package Algorithm.test_utc;

import javax.lang.model.util.Elements;

public class Test2 {
    public static void main(String[] args) {

    }

    public long[] solution(String s, String op) {
        long[] answer = new long[s.length()-1];

        for(int i= 0; i<s.length()-1; i++) {

            long left = Long.parseLong(s.substring(0, i+1));
            long right = Long.parseLong(s.substring(i+1));
            long ans = 0 ;

            switch (op) {
                case "+":
                    ans = left + right;
                    break;
                case "-":
                    ans = left - right;
                    break;
                case "*":
                    ans = left * right;
                    break;
            }

            answer[i] = ans;
        }

        return answer;
    }
}

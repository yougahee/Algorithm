package Algorithm.test_friendtrip;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(6,6,5));
    }

    public static long solution(int n, int r, int c) {
        long answer = 0;
        long size = r+c;

        if(size-1 > n) {
            answer =  n * (n+1) / 2;
            if(size-2 != n) answer += (size-n-2) * ( 2 * (n-1) + (size - n - 3) * -1) /2;

            if(size%2 == 0) answer += n - r +1;
            else answer += n - c + 1;
        }
        else {
            answer = (size-2) * (size-1) / 2;

            if(size%2 == 0) answer += c;
            else answer += r;
        }

        return answer;
    }

}

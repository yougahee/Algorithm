package Algorithm.kakao;

public class Solution4 {

    public static void main(String[] args) {

        int[][] numbers = {{0,0,0},{0,0,0},{0,0,0}};

        ProblemSolve4 problemSolve4 = new ProblemSolve4();

        int arr = problemSolve4.solution(numbers);
        System.out.println(arr);

    }
}

class ProblemSolve4 {

    static int[] dx = {-1,1,0,0};//상하좌우
    static int[] dy = {0,0,-1,1};

    public int solution(int[][] board) {
        int answer = 0;

        int cnt=0;
        int corner=0;






        return cnt*100 + corner*500;
    }
}
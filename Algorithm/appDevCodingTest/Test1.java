package Algorithm.appDevCodingTest;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {

        String[] moves = {"U", "R", "D", "L", "U", "R", "D", "L"};


        System.out.println(solution(moves));
    }

    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, 1, -1};


    //시작점, 끝점을 저장하는 class하나 만들기
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            x = this.x;
            y = this.y;
        }
    }

    public static int solution(String[] moves) {
        int answer = 0;
        int n=0, m=0;
        int up=0, down =0, right=0, left=0;

        ArrayList<Node> arrayList = new ArrayList<>();

        //배열의 크기 먼저 만들어보자
        for(int i=0; i<moves.length; i++) {
            //상
            if(moves[i].equals("U")) {
                up++;
            }
            //하
            if(moves[i].equals("D")) {
                down++;
            }
            //좌
            if(moves[i].equals("L")) {
                right++;
            }
            //우
            if(moves[i].equals("R")) {
                left++;
            }
        }

        n = Math.max(up, down);
        m = Math.max(right, left);

        int[][] map = new int[n*2][m*2];

        //시작점은 n,m

        for(int i=0; i<moves.length; i++) {
            switch (moves[i]) {
                case "U":
                    n = n + dx[0];
                    m = m + dy[0];
                    break;

                case "D":
                    n = n + dx[1];
                    m = m + dy[1];
                    break;

                case "L":
                    n = n + dx[2];
                    m = m + dy[2];
                    break;

                case "R":
                    n = n + dx[3];
                    m = m + dy[3];
                    break;
            }

            arrayList.add(new Node(n, m));
        }


        //정사각형인지를 파악하여 개수 return 함수





        return answer;
    }


}

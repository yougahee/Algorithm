package Algorithm.kakao;

public class Solution1 {
    public static void main(String[] args) {

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        ProblemSolve1 problemSolve1 = new ProblemSolve1();

        String  arr = problemSolve1.solution(numbers, hand);
        System.out.println(arr);

    }
}


class Hand {
    int x;
    int y;

    public Hand(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class ProblemSolve1{

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        //처음 왼손의 위치
        Hand lefthand = new Hand(3,0);
        //처음 오른손의 위치
        Hand righthand = new Hand(3,2);


        for(int i=0; i<numbers.length; i++) {
            int number = numbers[i];

            if(number==0)
                number = 11;

            //왼쪽에 존재하면
            if(number == 1 || number == 4 || number == 7) {
                //왼쪽 손의 위치를 바꿔주기!
                lefthand.x = (number-1)/3;
                lefthand.y = (number-1)%3;
/*
                System.out.println(lefthand.x + " " + lefthand.y);
                System.out.println("L" + number);*/
                //왼손으로 했다는 거 집어넣어주고
                answer.append("L");
            }
            //오른쪽에 존재하면
            else if(number == 3 || number == 6 || number == 9) {
                righthand.x = (number-1)/3;
                righthand.y = (number-1)%3;/*

                System.out.println("RRRRR" + righthand.x + " " + righthand.y);
                System.out.println("R" + number);*/

                answer.append("R");
            }
            //가운데
            else{
                //현재 number의 위치
                int nx = (number-1)/3;
                int ny = (number-1)%3;
/*
                System.out.println("현재 number의 위치" +nx +" " + ny);

                System.out.println("tlwkr" + lefthand.x + " " + lefthand.y);

                System.out.println("righ" +righthand.x + " " + righthand.y);*/

                //왼손과 오른손의 위치 거리 파악.
                int leftdis = Math.abs(nx - lefthand.x) + Math.abs(ny - lefthand.y);
                int rightdis = Math.abs(nx - righthand.x) + Math.abs(ny - righthand.y);

                //거리 같으면
                if(leftdis == rightdis) {
                    char a = hand.charAt(0);

                    if(a == 'r') {
                        righthand.x = nx;
                        righthand.y = ny;
                    }else{
                        lefthand.x = nx;
                        lefthand.y = ny;
                    }

                    answer.append(Character.toUpperCase(a));

                }else if(leftdis > rightdis){
                    //오른쪽이 넣음
                    righthand.x = nx;
                    righthand.y = ny;

                   // System.out.println("R" + number);

                    answer.append("R");
                }else {
                    lefthand.x = nx;
                    lefthand.y = ny;

                   // System.out.println("L" + number);

                    answer.append("L");
                }
            }
        }

        return answer.toString();
    }
}

package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gear_14891 {

    static int[][] gear = new int[5][9];
    static int[] isChecked;
    static int score=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //톱니바퀴 입력
        for (int i = 1; i < 5; i++) {
            String t = br.readLine();
            for (int j = 1; j < 9; j++) {
                gear[i][j] = t.charAt(j - 1) - '0';
            }
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            isChecked = new int[5];

            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            isChecked[startRow] = 1;
            //함수호출
            stateProgram(startRow, direction);

            //어쨌든 처음꺼는 돌아가야한다.
            rotation(startRow,direction);
        }

        score();
        System.out.println(score);

    }

    public static  void stateProgram(int r, int d) {

        //왼쪽 톱니바퀴 확인
        if(r-1 > 0 && gear[r-1][3] != gear[r][7] && isChecked[r-1] == 0) {

            isChecked[r-1] =1;
            if(d>0) {
                stateProgram(r-1, -1);
                rotation(r-1, -1);
            }else{
                stateProgram(r-1, 1);
                rotation(r-1, 1);
            }
        }

        //오른쪽 톱니바퀴 확인
        if(r+1 <=4 && gear[r+1][7] != gear[r][3] && isChecked[r+1] == 0) {

            isChecked[r+1] =1;
            if(d>0) {
                stateProgram(r+1, -1);
                rotation(r+1, -1);
            }else{
                stateProgram(r+1, 1);
                rotation(r+1, 1);
            }
        }

    }


    //rotation
    public static void rotation(int r, int direction) {

        //시계방향이면
        if (direction == 1) {
            int tmp = gear[r][8];

            for (int i = 8; i > 1; i--) {
                gear[r][i] = gear[r][i - 1];
            }

            gear[r][1] = tmp;
        }
        //반시계방향이면
        else {
            int tmp = gear[r][1];

            for (int i = 1; i < 8; i++) {
                gear[r][i] = gear[r][i + 1];
            }

            gear[r][8] = tmp;
        }
    }

    //점수
    public static void score() {
        for(int i=1; i<5; i++) {
            if(gear[i][1] == 1) {
                score += (int) Math.pow(2, i-1);
            }
        }
    }

}

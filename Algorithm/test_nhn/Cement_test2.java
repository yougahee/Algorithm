package Algorithm.test_nhn;

import java.util.Scanner;

public class Cement_test2 {

    static int[] blockHigh;
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        int answer = 0;
        blockHigh = new int[width];
        for(int i=0; i<day; i++) {
            for(int j=0; j < width; j++) {
                blockHigh[j] += blocks[i][j];
            }

            int leftHigh = blockHigh[0], rightHigh = findRightHigh(0);
            //System.out.println("left :" + leftHigh + " right : " + rightHigh);

            for(int k=1; k<width-1; k++) {

                //오른쪽 먼저 보기
                if(rightHigh == blockHigh[k]){
                    rightHigh = findRightHigh(k);

                    if(rightHigh < leftHigh) continue;
                }

                //왼쪽은 계속 update
                if(leftHigh < blockHigh[k]) {
                    leftHigh = blockHigh[k];
                    continue;
                }

                //오른쪽, 왼쪽을 보고 작은 곳의 값을 집어 넣으면 됨.
                int high = Math.min(leftHigh, rightHigh);
                answer += high - blockHigh[k];
                //System.out.println("k : " + k  + " ans " + answer + " high " + high);
                blockHigh[k] = high;
            }
        }

        System.out.println(answer);
    }

    public static int findRightHigh(int index) {
        int rightHigh = 0;
        for(int i = index+1; i<blockHigh.length; i++) {
           rightHigh =  Math.max(rightHigh, blockHigh[i]);
        }
        return rightHigh;
    }



    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}

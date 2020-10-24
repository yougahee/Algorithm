package Algorithm.test_nhn;

import java.util.Scanner;
import java.util.Stack;

public class test3 {
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.


        for(int i=0; i<numOfOrder; i++) {
            String answer = orderArr[i];
            String temp = "";

            Stack<String> stack = new Stack<>();

            int index = 0;
            String str = "";
            boolean isRight = false;
            while (true) {

                if(answer.charAt(index) != '(' && !isRight) {
                    str += Character.toString(answer.charAt(index));
                }
                else if( answer.charAt(index) == '(') {
                    stack.add(str.substring(0, str.length()-1));
                    str = "";
                    temp += Character.toString(answer.charAt(index));
                }




                index++;
            }

            //괄호 없이 숫자만 있는 경우


           // System.out.println(temp);
        }
    }

    public static String makeOrderTable(char a, String str) {
        String temp = "";

        System.out.println("a : " + a + " str " + str);
        //숫자인경우
        if ( a >= '1' && a <= '9') {
            for(int i = 0; i< a - '0'; i++) {
                temp += str;
            }
        }
        //문자인경우
        else {
            for(int i=0; i<str.length(); i++) {
                temp += Character.toString(a) + Character.toString(str.charAt(i));
            }
        }

        return temp;
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}

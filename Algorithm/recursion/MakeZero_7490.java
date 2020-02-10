package Algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeZero_7490 {

    public static String[] resultStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());

            int[] arr = new int[size];
            int[] output = new int[size - 1];

            //수열저장
            for (int j = 0; j < size; j++) {
                arr[j] = j + 1;
            }

            //중복순열
            //배열의 크기 -1 의 순열자리에 3개의 기호를 가지고 만들 수 있는 순열
            //그 후, 그 연산자로 0이 만들어지는 지 확인한 후 맞으면 출력
            Permutation(arr, output, 0, output.length);
        }

    }

    static void Permutation(int[] arr, int[] output, int step, int n) {
        if (n == step) {
            //arr 숫자 중간중간에 output을 넣어서 계산해야함.
            //공백은 어떻게 처리할 것인가?
            //계산하여 0이 되면 출력까지! 여기서 하면 끝!
            int result = 1;
            int cnt = 1;
            int before = 1;

            int size = arr.length + output.length;

            resultStr = new String[size];

            for (int j = 0; j < size; j++) {
                if (j % 2 == 0) {
                    //숫자 집어넣기
                    resultStr[j] = String.valueOf(arr[j / 2]);
                } else {
                    //기호 집어넣어서 판별
                    switch (output[j / 2]) {
                        case 1:
                            resultStr[j] = " ";
                            result = result - before;
                            if (before > 0) {
                                result = result + (before * 10 + (++cnt));
                                before = before * 10 + cnt;
                            } else {
                                result = result - (-1*before * 10 + (++cnt));
                                before = -1*before * 10 + cnt;
                            }
                            break;

                        case 2:
                            resultStr[j] = "+";
                            result = result + (++cnt);
                            before = cnt;
                            break;

                        case 3:
                            resultStr[j] = "-";
                            result = result - (++cnt);
                            before = -1 * cnt;
                            break;
                    }
                }
            }
            //System.out.println(result);

            if (result == 0) {
                for(int t=0; t<resultStr.length; t++) {
                    System.out.print(resultStr[t]);
                }
                System.out.println("");
            }

        } else {
            for (int i = 0; i < 3; i++) {
                output[step] = arr[i];
                Permutation(arr, output, step + 1, n);
            }
        }
    }
}

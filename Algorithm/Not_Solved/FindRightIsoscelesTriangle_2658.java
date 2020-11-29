package Algorithm.Not_Solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindRightIsoscelesTriangle_2658 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // iter
        /*
        for (String arg : args) {

        }*/


        // itar

        /*
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }
        */


        //배열이 주어지고, 모든 수가 짝을 이루고 있지만, 딱 한개의 수만 한번 나온다.
        //어떻게 코드를 짤 것 인가?
        //XOR을 쓰면 시간복잡도 O(N)

        int[] arr = {1,3,5,5,4,6,4,1,3};

        int result  = 0;
        for (int i : arr) {
            result = result ^ i;
        }

        System.out.println(result);
    }
}

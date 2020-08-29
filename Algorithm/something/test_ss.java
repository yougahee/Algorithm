package Algorithm.something;

import java.io.IOException;
import java.util.Arrays;

public class test_ss {

    public static void main(String[] args)  {

        int num = 8;
        int[] cards = {1,4,6};

        int num1 = 18;
        int[] cards1 = {1,2,5};

        //System.out.println(solution(num, cards));
        System.out.println(solution(num1, cards1));
    }

    static int numS, result = -1;
    static boolean isTrue;

    static public int solution(int num, int[] cards) {
        numS = num;

        int size = num/cards[0];
        int start = num/cards[cards.length-1];
        int[] output;

        for(int i = start; i <= size+1; i++) {
            output = new int[i];
            recomb(cards, output, cards.length, i, 0,0);
            if(isTrue)
                return result;
        }

        return result;
    }

    //중복조합
    public static void recomb(int[] arr, int[] output, int n, int r, int index, int target) {
        if(r ==0) {
            int sum = 0;

            for(int i=0; i<output.length; i++) {
                sum += output[i];
            }

            if(sum == numS) {
                result = output.length;
                isTrue = true;
                return;
            }

            if(sum > numS)
                return;

            System.out.println(Arrays.toString(output) + " sum :  " + sum);
        }
        else if(target == n) return;
        else {
            output[index] = arr[target];
            recomb(arr, output, n, r-1, index+1, target); //뽑는 경우
            recomb(arr, output, n, r, index, target+1); //안뽑는 경우
        }
    }
}
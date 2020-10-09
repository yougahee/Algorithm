package Algorithm.test_naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinFlip {
    public static void main(String[] args) throws IOException {
        int[] coinArr = new int[100];
        int[] coinArrCopy = new int[100];

        int firstCnt = 0;
        int secondCnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        //똑같은 배열 복사
        coinArrCopy = Arrays.copyOf(coinArr, coinArr.length);

        for (int i = 0; i < testCase; i++) {

            //첫번째,
            if(coinArr[0] != 0){
                firstCnt++;
                coinArr[0] = 0;
            }
            //짝수번째는 무조건 0
            if (i % 2 == 0 && coinArr[i] != 0) {
                firstCnt++;
            } else if (i % 2 == 1 && coinArr[i] != 1) {
                firstCnt++;
            }

            if(coinArrCopy[0] != 1){
                secondCnt++;
                coinArrCopy[0] = 1;
            }
            //짝수번째는 무조건 1
            if (i % 2 == 0 && coinArrCopy[i] != 1) {
                secondCnt++;
            } else if (i % 2 == 1 && coinArrCopy[i] != 0) {
                secondCnt++;
            }
        }

        if(firstCnt<=secondCnt){
            System.out.println(firstCnt);
        } else {
            System.out.println(secondCnt);
        }
    }
}

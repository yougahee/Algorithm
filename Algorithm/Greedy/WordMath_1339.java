package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordMath_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wordSum = new int[30];
        long ans = 0;

        for (int i=0; i<N; i++) {
            String word = br.readLine();

            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'A';
                wordSum[index] += Math.pow(10, word.length()-j-1);
            }
        }

        Arrays.sort(wordSum);

        int getNumber = 9;
        for (int i= wordSum.length-1; i>=0; i--) {
            if(wordSum[i] == 0) break;
            ans += wordSum[i] * getNumber--;
        }

        System.out.println(ans);
    }
}

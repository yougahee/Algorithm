package Algorithm.binaryserch;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class SteppingSton_11561 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long T = sc.nextLong();
        long N;
        long left, right, middle;
        long ans;

        BigInteger k, BN, NN;

        for(long i=0; i<T; i++) {
            N = sc.nextLong();
            right = N;
            left = 1;
            ans = 0;

            while (left <= right) {
                middle = (left + right) / 2;



                k = new BigInteger("middle*(middle + 1)/2");
                BN = BigInteger.valueOf(N);

                if(k.compareTo(BN) <= 0) {
                    ans =  middle;
                    left =  middle + 1;
                }
                else {
                    right = middle - 1;
                }
            }
            System.out.println(ans);
        }
    }
}

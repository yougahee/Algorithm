package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_2747 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int fibo_num = Integer.parseInt(br.readLine());

        int a=0;
        int b=1;

        if(fibo_num == 0) System.out.println(0);
        else if(fibo_num == 1) System.out.println(1);
        else {
            while(fibo_num-1 >0 ) {
                int next = a+b;
                a =b;
                b = next;

                fibo_num--;
            }

            System.out.println(b);
        }
    }
}

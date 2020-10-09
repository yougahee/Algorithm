package Algorithm.test_toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test7 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        String[] kim_toss = input1.split(" ");
        String[] lee_toss = input2.split(" ");

        int money =0;

        for(int i=0; i<kim_toss.length; i++) {
            int kim_money = Integer.parseInt(kim_toss[i]);
            int lee_money = Integer.parseInt(lee_toss[i]);

            money = money + kim_money - lee_money;

            if(money < 0) {
                System.out.print( 0 + " ");
            } else {
                System.out.print(money + " ");
                money = 0;
            }
        }
    }
}

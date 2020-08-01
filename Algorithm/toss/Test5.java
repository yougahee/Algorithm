package Algorithm.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] input_split = input.split("\n");
        int money =0;

        System.out.println(input_split[1]);

        String[] kim_toss = input_split[0].split(" ");
        String[] lee_toss = input_split[1].split(" ");

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

package Algorithm.test_utc;

import javax.swing.*;

public class Test3 {
    public static void main(String[] args) {

    }

    public int solution(int money, String[] expected, String[] actual) {

        int moneyForGame = 100;
        for(int i=0; i<expected.length; i++) {
            System.out.println(money + " " + moneyForGame + " ");

            if(money <0) {
                return 0;
            }

            if(expected[i].equals(actual[i])) {
                money += moneyForGame;
                moneyForGame = 100;
            }
            else {
                money -= moneyForGame;

                if(money - moneyForGame*2 < 0) moneyForGame = money;
                else moneyForGame *= 2;
            }
        }


        return money;
    }
}

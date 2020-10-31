package Algorithm.test_wintercoding;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {

        int n = 6;
        int[][] delivery = {};

        //System.out.println(solution(perchase));
    }

    public String solution(int n, int[][] delivery) {
        String answer = "";

        int[] product = new int[n+1];

        for(int i=0; i<delivery.length; i++) {
            int isDelivery = delivery[i][2];

            if(isDelivery == 1) {
                product[delivery[i][0]] = 1;
                product[delivery[i][1]] = 1;
            }
        }


        for(int i=0; i<delivery.length; i++) {
            int isDelivery = delivery[i][2];

            if(isDelivery != 1) {
                if(product[delivery[i][0]] == 1) {
                    product[delivery[i][1]] = 2;
                }else if(product[delivery[i][1]] == 1) {
                    product[delivery[i][0]] = 2;
                }
            }
        }

        for(int i=1; i<product.length; i++) {
            int a = product[i];
            if(a == 0) answer += "?";
            else if(a == 1) answer += "O";
            else answer += "X";
        }
        return answer;
    }


}

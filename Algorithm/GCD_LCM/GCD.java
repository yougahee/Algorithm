package Algorithm.GCD_LCM;

public class GCD {
    public static void main(String[] args) {
        int value =1;
        int val1 =12;
        int val2 = 8;

        int max = val1, min= val2;
        max = Math.max(max, min);
        min = Math.min(max, min);

        //유클리드 호제법..
        while (value > 0) {
            value = max % min;
            max = min;
            min = value;
        }

        //최대공약수 --> max
        System.out.println(max);
        //최소공배수
        int lcm = val1 * val2 /max;
        System.out.println(lcm);
    }
}

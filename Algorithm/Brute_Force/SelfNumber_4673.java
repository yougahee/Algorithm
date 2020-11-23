package Algorithm.Brute_Force;

public class SelfNumber_4673 {
    public static void main(String[] args) {
        boolean[] selfNum = new boolean[10001];

        for(int i=1; i<10000; i++) {
            int index = selfNumber(i);
            if(index <= 10000) selfNum[selfNumber(i)] = true;
        }

        for(int i=1; i<selfNum.length; i++) {
            if(!selfNum[i]) System.out.println(i);
        }
    }

    public static int selfNumber(int n) {
        String str = Integer.toString(n);

        for(char a : str.toCharArray()) {
            n += a - '0';
        }

        return n;
    }
}

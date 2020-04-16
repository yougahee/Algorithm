package Algorithm.testnaverhack;

public class Num3 {

    static int answer = 0;

    public static void main(String[] args) {

        final int MOD_NUM = 1000000007;

        int n = 50;
        int m = 150;
        int k = 20;

        int[] arr = new int[n * k];

        //조합
        for (int i = 0; i < n * k; i++) {
            arr[i] = i;
        }

        System.out.println(11);
        //예외
        if (n > m) {
            System.out.println(0);
            return;
        }
        //예외
        if (n * k < m) {
            System.out.println(0);
            return;
        }

        System.out.println(22);
        //짝수
        if(n%2 == 0) {
            System.out.println(3333333);
            Combi(arr, n/2, (m-n)/2, 0,0);
            int num = answer;

            System.out.println(33);
            answer = num * num *2 % MOD_NUM;
        }else{
            Combi(arr, n/2+1, (m-n)/2, 0,0);
            int n1 = answer;
            answer=0;
            Combi(arr, n/2, (m-n)/2+1, 0,0);
            int n2 = answer;

            System.out.println(44);
            answer = n1*n2*2 % MOD_NUM;
        }

        System.out.println(55);
        System.out.println(answer);

    }

    //조합
    public static void Combi(int[] arr, int n, int r, int index, int target) {

        if (r == 0) {
            answer++;
            return;
        }

        if (index == n) {
            return;
        }

        arr[index] = index;
        Combi(arr, n, r - 1, index, target + 1);
        Combi(arr, n, r, index+1, target);

    }

}

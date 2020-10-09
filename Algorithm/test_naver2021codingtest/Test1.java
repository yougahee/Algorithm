package Algorithm.test_naver2021codingtest;

public class Test1 {

    public static void main(String[] args) {
        int n = 7;
        int p[] = {6, 2, 1, 0, 2, 4, 3};
        int c[] = {3, 6, 6, 2, 3, 7, 6};

        System.out.println(solution(n, p, c));
    }

    public static String solution(int n, int[] p, int[] c) {
        String answer ="";
        int sum =0;
        int remain =0, price = 100, cancleCnt=1;

        for(int i=0; i<n; i++) {

            //주문가능
            if(p[i] + remain >= c[i]) {
                sum += c[i]*price;

                if(p[i] + remain > c[i])
                    remain += p[i] - c[i];

                if(p[i] + remain == c[i])
                    remain = 0;

                //주문을 했으니까 초기화 시켜줌
                price = 100;
            }
            //주문이 취소되는 경우
            else {
                remain += p[i];
                price /= 2;
                System.out.println("price : " + price);

                if(price < 25) {
                    n = i+2;
                    System.out.println(i + "i의  " + n);
                    break;
                }
            }

            System.out.println("합 : " + sum + " 남은 수량 : " + remain);
        }


        System.out.println("n의 값 : " + n);
        System.out.println("총합 : " + sum);
        answer = String.format("%.2f",(double) sum/ (double) n);
        System.out.println("double : " + answer);

        return answer;
    }
}

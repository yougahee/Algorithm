package Algorithm.test_n_tech;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
    }

    public int solution(int N) {
        int answer = 0;

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[N];
    }
}

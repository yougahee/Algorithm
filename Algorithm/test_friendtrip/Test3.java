package Algorithm.test_friendtrip;

public class Test3 {
    public static void main(String[] args) {
        String s1 = "abcdcba";
        String s2 = "abacde";

        System.out.println(solution(s1));
    }

    //문제 풀어보기 --> 팰린드롬 문제
    public static int solution(String s)
    {
        int max = 1;
        int len = s.length();
        int l, r, cnt;

        for(int i = 1; i < len - 1; i++) {
            l= i-1;
            r = i+1;
            cnt = 0;

            while(l >= 0 && r < len) {
                if(s.charAt(l) == s.charAt(r)) {
                    cnt++;
                    l--;
                    r++;
                }
                else break;
            }
            max = Math.max(max, 1 + 2 * cnt);

            if(s.charAt(i) == s.charAt(i + 1)) {
                l = i;
                r = i + 1;
                cnt = 0;
                while(l >= 0 && r < len) {
                    if(s.charAt(l) == s.charAt(r)) {
                        cnt++;
                        l--;
                        r++;
                    }
                    else break;
                }
                max = Math.max(max, 2 * cnt);
            }
        }
        return max;
    }
}

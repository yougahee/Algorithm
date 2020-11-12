package Algorithm.test_friendtrip;

public class Test1 {
    public static void main(String[] args) {

    }

    public int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;

        int sx=0,sy=0,ex=0,ey=0;

        if(s[0] > e[0]) {
            sx = e[0];
            ex = s[0];
        }
        else {
            sx = s[0];
            ex = e[0];
        }

        if(s[1] > e[1]) {
            sy = e[0];
            ey = s[0];
        }
        else {
            sy = s[0];
            ey = e[0];
        }

        for(int[] loc : location) {
            int x = loc[0];
            int y = loc[1];
            if(x >= sx && x <= ex && y >= sy && y <= ey) answer++;
        }

        return answer;
    }

}

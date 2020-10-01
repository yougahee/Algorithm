package Algorithm.test_11st;

public class Test1 {
    public static void main(String[] args) {
        String s = "dog";
        System.out.println(solution(s));
    }

    public static int solution(String S) {

        if(S.contains("aaa"))
            return -1;

        int aCnt=0, result=0;
        for(int i=0; i<S.length(); i++) {
            char s_string = S.charAt(i);

            if(s_string == 'a') {
                aCnt++;
            }
        }

        int aRemove = S.replace("a", "").length();
        result = (aRemove+1)*2 - aCnt;

        return result;
    }
}

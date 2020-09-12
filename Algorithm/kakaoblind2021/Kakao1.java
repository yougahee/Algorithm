package Algorithm.kakaoblind2021;

public class Kakao1 {
    public static void main(String[] args) {
        String new_id = "=.=";
        //String new_id = "z-+.^.";
        //String new_id = "=.=";



        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {

        return rule(new_id);
    }

    public static String rule(String new_id) {
        String answer = "";

        //1단계
        new_id = new_id.toLowerCase();
        System.out.println("1단계 : " + new_id);

        //2단계
        for(int i=0; i<new_id.length(); i++) {
            char temp = new_id.charAt(i);

            if(temp == '-' || temp == '_' || temp == '.' || Character.isDigit(temp))
                answer += temp;
            else if(temp >= 'a' && temp <='z')
                answer += temp;
        }
        System.out.println("2단계 : " + answer);
        new_id = answer;

        int cnt = 0;
        String data = "";
        //3단계
        for(int i=0; i<new_id.length(); i++) {
            char temp = new_id.charAt(i);

            if(temp == '.') {
                if(cnt == 0)
                    data += temp;
                cnt++;
            }else {
                if(cnt > 0)
                    cnt = 0;
            }

            if(cnt == 0)
                data += temp;
        }
        answer = data;
        System.out.println("3단계 : " + answer);

        //4단계
        if(answer.charAt(0) == '.') {
            if(answer.length() == 1)
                answer = "";
            else
                answer = answer.substring(1);
        }
        if(answer.length() - 1 >= 0 && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);

        System.out.println("4단계 : " + answer);

        //5단계
        if(answer.length() == 0)
            answer += "a";

        System.out.println("5단계 : " + answer);


        //6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);

            if(answer.charAt(answer.length()-1) == '.') {
                answer = answer.substring(0, 14);
            }
        }

        System.out.println("6단계 : " + answer);

        //7단계
        if(answer.length() <= 2) {
            char add = answer.charAt(answer.length()-1);

            while (answer.length() <=2)
                answer += add;
        }

        System.out.println("7단계 : " + answer );
        return answer;
    }
}

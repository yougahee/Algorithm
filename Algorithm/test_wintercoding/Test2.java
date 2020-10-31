package Algorithm.test_wintercoding;


public class Test2 {
    public static void main(String[] args) {
        String encrypted_text = "qyyigoptvfb";
        String key = "abcdefghijk";
        int rotation = -50;

        System.out.println(solution(encrypted_text, key, rotation));
    }

    public static String solution(String encrypted_text, String key, int rotation) {
        String answer = "";

        //로테이트를 먼저하고..
        for(int i=0; i< Math.abs(rotation); i++) {
            //음수일때,
            if(rotation < 0) {
                //맨 끝에거 가져오고, 1부터 1마이너스 한 거 사용하고
                encrypted_text = encrypted_text.substring(encrypted_text.length()-1)
                        + encrypted_text.substring(0, encrypted_text.length()-1);
            }
            else {
                encrypted_text = encrypted_text.substring(1) + encrypted_text.substring(0,1);
            }
        }
        //System.out.println(encrypted_text);


        for(int i=0; i<encrypted_text.length(); i++) {
            int a = (encrypted_text.charAt(i) - 'a' - (key.charAt(i) - 'a' + 1) + 26) % 26;
            char arr = (char) (a + 'a');

            answer += Character.toString(arr);
        }

        //System.out.println(answer);

        return answer;
    }
}

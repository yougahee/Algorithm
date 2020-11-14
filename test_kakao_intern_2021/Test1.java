package test_kakao_intern_2021;

//문제 3번인데, source를 target으로 만드는데 드는 최소비용을 구하라고 한다.
// 맨처음 shift를 한다. 1 ~ 26까지 ( a~z까지 ) 돌렸을 때, 일치하는 것이 나오면 0번으로 끝!
// 하지만, shift를 해서도 끝나지 않는다면, 문자를 삭제하거나 삽입하는 과정을 거쳐야한다.
// 나는 shift 단계만 끝내고, 같은 수를 판별해서 계산을 해줬는데,
// 그렇게하면 모두 다 같은 문자지만, 위치가 다를 경우가 발생하였다.
// 하지만, 문제에서 위치가 다를 경우를 어떻게 처리할지 말을 안해줘서 어떻게 해야할지 감이안온다ㅏ.
// 내가 감이 안오는 부분은 위치가 맞지 않으면, 그 데이터를 삭제하고, 다시 삽입하는 과정이 들어가야 하는건가? 이다.

public class Test1 {
    public static void main(String[] args) {

        String source = "mqfsnmygrquczhymvkurxfelpeagkisearktnjrcapbuuawnmcrgsfsnusuprtnnzbuvtoemgiohvicsnkqhbgoomupuvjmfzpqp";
        String target = "yelitmysnjcfgvvvezaprgaonzkofyqqhfmxseezencanocepyzxocwivnkbjrhcehqlcwsagrfookhiwsrjguzonapppyyodlqx";
        int result = source.length()*2;

        //s1에 s2의 원자가 하나라도 있는 경우, 몇개의 값이 일치하는지 보면 될 듯
        for(int i=0; i<26; i++) {
            String temp = "";
            for(char a : source.toCharArray()) {
                if(a + i > 'z') temp += (char) ( a + i - 26 );

                else temp += (char) ( a + i );
            }

            result = Math.min(result, (source.length()-compareStr(temp, target))*2);
        }
        System.out.println(result);
    }

    public static int compareStr(String s1, String s2) {
        String temp = "";
        int cnt = 0;

        for(char a : s1.toCharArray()) {
            for(int i=0; i<s2.length(); i++) {
                char b = s2.charAt(i);

                if(a == b) {
                    cnt++;
                    //같은 것을 제외하고 다른 것들 중에 찾아보는 것.
                    temp += s2.substring(i+1);
                    break;
                }
                else temp += b;
            }
            s2 = temp;
            temp = "";
        }

        return cnt;
    }
}

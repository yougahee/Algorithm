package Algorithm.test_utc;

public class Test5 {
    public static void main(String[] args) {

    }

    public  String solution(String penter, String pexit, String pescape, String data) {
        String answer = "";

        int size = penter.length();
        for(int i=0; i< data.length() ; i += size) {
            System.out.println(i);
            String temp = data.substring(i, i + size);

            if(temp.equals(penter) || temp.equals(pexit) || temp.equals(pescape))
                answer += pescape;

            answer += temp;
        }

        return penter + answer + pexit;
    }

}

package Algorithm.test_naver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int result = a*b;
        int cnt=0;

        //10진수를 2진수로 바꿔주는 코드
        String binary = Integer.toBinaryString(result);

        int size = binary.length();

        char[] chars = new char[size];
        chars = binary.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(chars[i] == '1') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

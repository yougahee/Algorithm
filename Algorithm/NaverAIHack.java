package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NaverAIHack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int result = a*b;
        int cnt=0;

        String binary = Integer.toBinaryString(result);

        char[] chars = new char[binary.length()];

        chars = binary.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(chars[i] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}

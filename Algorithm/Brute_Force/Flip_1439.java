package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int a = 0, b =0;
        boolean flag = false;
        //0
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '0') {
                flag = false;
                continue;
            }
            else {
                if(!flag) {
                    a++;
                    flag = true;
                }
            }
        }

        flag = false;
        for(int j=0; j<str.length(); j++) {
            if(str.charAt(j) == '1') {
                flag = false;
                continue;
            }
            else {
                if(!flag) {
                    b++;
                    flag = true;
                }
            }
        }


        System.out.println(Math.min(a,b));
    }
}

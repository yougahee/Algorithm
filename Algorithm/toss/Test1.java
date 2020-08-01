package Algorithm.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Boolean result = true;

        if(input.charAt(input.length()-1) == '1')
            result = false;

        for(int i=0; i< input.length()-1; i++) {
            if(!result) {
                break;
            }

            if(input.charAt(i) == '1' && input.charAt(i+1) == '1') {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }

}

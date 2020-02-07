package naver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Palindrome {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        inputString = inputString.replaceAll(" ", "");
        String[] originString = inputString.split("");
        int originStringSize = originString.length;

        String[] reverseString = new String[originStringSize];
        //출력
        for (int i = 0; i < originStringSize; i++) {
            System.out.println("처음" + originString[i]);
        }

        //reverse하기
        for (int i = 0; i < originStringSize; i++) {
            reverseString[i] = originString[originStringSize - 1-i];
            //System.out.println("바꾼거" + reverseString[i]);
        }

        //비교하기
        for (int i = 0; i < originStringSize; i++) {
            //문자가 같지 않으면
            if (!reverseString[i].equals(originString[i])) {
                if(!reverseString[i].equals("?") && originString[i].equals("?")) {
                    originString[i] = reverseString[i];
                }else if(reverseString[i].equals("?") && !originString[i].equals("?")){
                    reverseString[i] = originString[i];
                }
                else {
                    System.out.println("NO");
                    //break;
                    return;
                }
            }else if(reverseString[i].equals("?") && originString[i].equals("?")) {
                originString[i] = "a";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<originStringSize; i++) {
            sb = sb.append(originString[i]);
        }

        System.out.println(sb.toString());

    }
}

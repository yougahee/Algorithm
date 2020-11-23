package Algorithm.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Compression_1662 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        arr = new int[50];

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') stack.push(i);
            if(str.charAt(i) == ')') arr[stack.pop()] = i;
        }

        System.out.println(stringLength(0, str.length(), str));

    }

    public static int stringLength(int s, int e, String str) {
        int length = 0;

        for(int i=s; i<e; i++) {
            if(str.charAt(i) == '(')  {
                int re = str.charAt(i-1) - '0';
                length--;
                length += stringLength(i+1, arr[i], str) * re;
                i = arr[i];
            }
            else{
                length++;
            }
        }

        return length;
    }
}

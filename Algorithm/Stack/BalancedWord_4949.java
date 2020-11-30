package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


//많이 풀어본 유형임에도 불구하고 한번 틀렸다.
//( 또는 [ 이 하나밖에 없을 때도 생각해줘야한다.
public class BalancedWord_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            Boolean isTrue = true;

            for(char a : str.toCharArray()) {
                if(a == '(' || a == '[') {
                    stack.add(a);
                }
                else if(a == ')') {
                    if( !stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        isTrue = false;
                        break;
                    }
                }
                else if(a == ']') {
                    if( !stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        isTrue = false;
                        break;
                    }
                }
            }

            if(isTrue && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class KeyLogger {
    public static void main(String[] args) throws Exception {

        int testCase;
        int cursor;
        LinkedList arrayList = new LinkedList();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack1 = new Stack<Character>();
            Stack<Character> stack2 = new Stack<Character>();

            arrayList.clear();
            cursor = 0;

            for (int j = 0; j < input.length; j++) {

                switch (input[j]) {
                    case '<':
                        if (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                        break;
                    case '>':
                        if (!stack2.isEmpty()) {
                            stack1.push(stack2.pop());
                        }
                        break;
                    case '-':
                        if (!stack1.isEmpty()) {
                            stack1.pop();
                        }
                        break;
                    default:
                        stack1.push(input[j]);
                        break;

                }
            }
            StringBuilder sb = new StringBuilder();

            while(!stack2.empty()) {
                stack1.push(stack2.pop());
            }

            for (int k = 0; k < stack1.size(); k++) {
                sb.append(stack1.elementAt(k));
            }/*
            for(int k=0; k<stack2.size(); k++) {
                sb.append(stack2.pop());
            }*/
            System.out.println(sb);
        }
        br.close();
    }
}

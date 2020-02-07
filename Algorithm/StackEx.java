package Algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackEx {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] array = new int[100001];
        ArrayList<String> arrayList = new ArrayList<>();

        int stackTop=1;
        boolean isRight = true;

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0; i< N; i++)
            array[i] = sc.nextInt();

        for(int i=0; i<N; i++) {
            while(array[i] >= stackTop) {
                stack.push(stackTop);
                arrayList.add("+");
                stackTop++;
            }
            if(stack.peek() == array[i]){
                stack.pop();
                arrayList.add("-");
            }else {
                isRight = false;
                break;
            }
        }

        if(isRight) {
            for(int i=0; i<arrayList.size(); i++){
                System.out.println(arrayList.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}

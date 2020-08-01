package Algorithm.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] input_split = input.split(" ");

        HashSet<String> hashSet = new HashSet<>();
        Deque<String> deque = new LinkedList<>();

        for(int i=0; i<input_split.length; i++) {

            if(!hashSet.contains(input_split[i])) {
                if(hashSet.size() == 5) {
                    hashSet.remove(deque.pollFirst());
                }
                hashSet.add(input_split[i]);
                deque.addLast(input_split[i]);
            }
            //존재한다면, 맨 뒤로 집어넣어야함
            deque.remove(input_split[i]);
            deque.addLast(input_split[i]);
            Iterator<String> iterator = deque.descendingIterator();

            while(true) {
                System.out.print(iterator.next());
                if(iterator.hasNext())
                    System.out.print(" ");
                else
                    break;
            }
            System.out.println();
        }
    }

}

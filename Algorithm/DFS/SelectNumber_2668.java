package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SelectNumber_2668 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++) {
            if(i == arr[i]) {
                answer.add(i);
                continue;
            }

            int index = arr[i];
            set.clear();
            set.add(i);
            while (true) {
                if(i == arr[index]) {
                    answer.add(i);
                    break;
                }

                if(set.contains(index)) break;
                set.add(index);
                index = arr[index];
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i=0; i<answer.size(); i++)
            System.out.println(answer.get(i));
    }
}

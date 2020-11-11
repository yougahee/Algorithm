package Algorithm.not_solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NextPermutation_10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        LinkedList<Integer> arrayList = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = N-2;
        int next = Integer.MAX_VALUE;
        while (index >= 0) {
            if( arr[index] < arr[index+1]) {
                int value = arr[index];
                arrayList.add(value);
                for(int i = index + 1; i<N; i++) {
                    if( value < arr[i] && next > arr[i]) {
                        if(next != Integer.MAX_VALUE) arrayList.add(next);
                        next = arr[i];
                        continue;
                    }
                    arrayList.add(arr[i]);
                }
                break;
            }

            index--;
        }

        if(arrayList.size() == 0) {
            System.out.println(-1);
            return;
        }

        Collections.sort(arrayList);
        arrayList.add(0, next);

        for(int i=0; i<N-arrayList.size(); i++)
            System.out.print(arr[i] + " ");

        for(int i=0; i< arrayList.size(); i++)
            System.out.print(arrayList.get(i) + " ");

    }
}

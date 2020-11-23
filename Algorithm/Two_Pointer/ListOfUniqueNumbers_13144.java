package Algorithm.Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s=0, e=0;
        while (true) {
            if(s == n) break;

            if(e < n && !set.contains(arr[e])) {
                set.add(arr[e]);
                e++;
            } else {
                sum += set.size();
                set.remove(arr[s]);
                s++;
            }
        }

        System.out.println(sum);
    }
}

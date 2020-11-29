package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordSort_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if(set.contains(str)) continue;
            set.add(str);
            arr.add(str);
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length()- o2.length();
                if(len == 0) return o1.compareTo(o2);
                return len;
            }
        });

        for (String s : arr) System.out.println(s);
    }
}

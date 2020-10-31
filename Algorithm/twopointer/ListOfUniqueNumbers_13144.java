package Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        boolean[] isChecked = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = n * (n+1) /2;

        int left = 0, right = 0;
        isChecked[arr[left]] = true;
        while (true) {
            if(left >= n) break;

            if(right < n && !isChecked[arr[right+1]]) {
                //System.out.println("right : " + right + " ans : " + answer);
                right++;
                isChecked[arr[right]] = true;

            }else {
                if(right < n && isChecked[arr[right+1]])
                    answer -= (n-right-1);

                isChecked[arr[left]] = false;
                left++;
            }
        }

        System.out.println(answer);
    }
}

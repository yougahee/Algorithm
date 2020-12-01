package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CrossCardProblem_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[4];
        for(int i=0; i<4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        String str = "";
        Arrays.sort(arr);
        for (int i : arr) {
            str += i;
        }

        String card = "1111";
        int cnt =0;
        while (true) {
            String minString = minString(card);
            if(card.equals(minString)) {
                cnt++;

                if(str.equals(minString)) break;
            }

            card = Integer.toString(Integer.parseInt(card ) + 1);
        }

        System.out.println(cnt);
    }

    static String minString(String card) {

        if(card.contains("0")) return "";
        String[] arr = card.split("");

        Arrays.sort(arr);

        String str = "";
        for (String s : arr) str += s;

        return str;
    }
}

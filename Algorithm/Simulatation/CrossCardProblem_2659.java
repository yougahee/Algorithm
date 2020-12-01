package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class CrossCardProblem_2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String mainCard = "";
        for(int i=0; i<4; i++)
            mainCard += st.nextToken();

        int mainCardInt = minString(mainCard);

        String card = "1111";
        HashSet<Integer> set = new HashSet<>();
        set.add(-1);

        int cnt =0;
        while (true) {
            int b = minString(card);

            if(!set.contains(b)) {
                set.add(b);
                cnt++;

                if(mainCardInt == b) break;
            }

            card = Integer.toString(parseInt(card ) + 1);
        }

        System.out.println(cnt);
    }

    static int minString(String card) {

        if(card.contains("0")) return -1;
        String[] arr = card.split("");

        String str1 = "",str2 ="",str3="",str4="";

        for (int i = 0; i < arr.length; i++) {
            str1 += arr[i];
            str2 += arr[(i+1)%4];
            str3 += arr[(i+2)%4];
            str4 += arr[(i+3)%4];
        }

        return Math.min(Integer.parseInt(str1),
                        Math.min(parseInt(str2),
                                Math.min(parseInt(str3), parseInt(str4))));
    }
}

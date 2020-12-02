package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Remote_1107 {

    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int ans = 0;
        set = new HashSet<>();

        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        int intN = Integer.parseInt(N);

        if(M>0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }


        int abs = Math.abs(intN - 100);
        if (isOk(N)) {
            ans = Math.min(abs, N.length());
            System.out.println(ans);
            return;
        }

        if(set.size() == 10)
        {
            System.out.println(abs);
            return;
        }

        int cnt = 0;
        String minusN = "", plusN = "";
        while (true) {
            cnt++;

            minusN = String.valueOf(intN - cnt);
            plusN = String.valueOf(intN + cnt);

            //마이너스부터
            if (Integer.parseInt(minusN) >= 0 && isOk(minusN)) {
                N = minusN;
                break;
            }
            if (isOk(plusN)) {
                N = plusN;
                break;
            }
        }

        System.out.println(Math.min(abs, N.length() + cnt));
    }

    static boolean isOk(String n) {
        String[] str = n.split("");

        for (String s : str) {
            if (set.contains(Integer.parseInt(s))) return false;
        }
        return true;
    }
}

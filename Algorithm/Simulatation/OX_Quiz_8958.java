package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX_Quiz_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans, cnt;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            ans = 0;
            cnt = 1;
            String str = br.readLine();

            for (char c : str.toCharArray()) {
                if(c == 'O') {
                    ans += cnt++;
                } else {
                    cnt = 1;
                }
            }

            System.out.println(ans);
        }
    }
}

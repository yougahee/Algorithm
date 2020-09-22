package Algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CreatePassword {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] pwAlphabet = new String[L];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<L; i++) {
            pwAlphabet[i] = st.nextToken();
        }

        Arrays.sort(pwAlphabet);


    }
}

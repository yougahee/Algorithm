package Algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CreatePassword {

    static ArrayList<String> arr;
    static int L, C;
    static String[] pwAlphabet;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        pwAlphabet = new String[C];
        arr = new ArrayList<>();


        String inputString = br.readLine();
        pwAlphabet = inputString.split(" ");

        Arrays.sort(pwAlphabet);

        DFS(0, 0, 0,0,"");

        Collections.sort(arr);

        for(String str : arr) {
            System.out.println(str);
        }
    }

    public static void DFS(int cnt, int start, int consonant, int vowel, String str) {
        String temp = str;

        if(cnt == L) {
            if(consonant >=2 && vowel >=1)
                arr.add(temp);

            return;
        }

        if(cnt + C - start < L)
            return;

        //해당 index를 포함하지 않는다.
        DFS(cnt, start+1, consonant, vowel, temp);

        //해당 index 포함
        if(pwAlphabet[start].equals("a") || pwAlphabet[start].equals("i") || pwAlphabet[start].equals("o")
        || pwAlphabet[start].equals("e") || pwAlphabet[start].equals("u"))
            vowel++;
        else
            consonant++;

        DFS(cnt+1, start+1, consonant, vowel, temp+pwAlphabet[start]);

    }
}

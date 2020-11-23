package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ReverseSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] splited =input.split("");

        Arrays.sort(splited, Comparator.reverseOrder());

        for(int i=0; i<splited.length; i++) {
            System.out.print(splited[i]);
        }

    }
}

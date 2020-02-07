package Algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int tnum = sc.nextInt();
            int max =0;
            int frequent=0;

            int[] arr = new int[101];
            for (int i = 0; i < 5; i++) {
                int score = sc.nextInt();
                arr[score]++;
            }

            for(int i=0; i<= 100; i++) {
                if(max < arr[i]) {
                    max = arr[i];
                    frequent = i;
                } else if(max == arr[i]) {
                    if(frequent < i) {
                        frequent = i;
                    }
                }
            }
            System.out.println("#"+tnum+ " " + frequent);
        }
    }
}
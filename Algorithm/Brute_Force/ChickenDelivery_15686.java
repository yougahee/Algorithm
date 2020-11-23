package Algorithm.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {

    static int N, M, answer;
    static LinkedList<House> home;
    static LinkedList<House> chickenShop;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        int[][] city = new int[N][N];
        chickenShop = new LinkedList<>();
        home = new LinkedList<>();

        int chickenCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) home.add(new House(i, j));
                if (city[i][j] == 2) {
                    chickenShop.add(new House(i, j));
                    chickenCnt++;
                }
            }
        }

        int[] arr = new int[chickenCnt];
        int[] output = new int[M];
        for(int i=0; i<chickenCnt; i++) arr[i] = i;

        combination(arr, output, chickenCnt, M, 0, 0);
        System.out.println(answer);
    }

    public static void combination(int[] arr, int[] output, int n, int r, int index, int depth) {
        if(r == 0) {
            findChickenDistance(output);
        }
        else if( depth == n ) return;
        else {
            output[index] = arr[depth];
            combination(arr, output, n, r-1, index+1, depth+1 ); // 뽑는경우
            combination(arr, output, n, r, index, depth + 1); // 뽑지 않는 경우
        }
    }

    public static void findChickenDistance(int[] output) {
        int result = 0;

        for( House house : home) {
            int minDis = Integer.MAX_VALUE;

            for(int i=0; i<output.length; i++) {
                House chicken = chickenShop.get(output[i]);
                minDis = Math.min(minDis, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }
            result += minDis;
        }

        answer = Math.min(answer, result);
    }

    static class House {
        int x, y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Easy2048_12100 {

    static int N;
    static int[][] map;
    static int[][] copy;

    static int[] arr = {1,2,3,4};
    static int[] output = new int[5];

    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        copy = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rePermutation(4,5,0);

    }

    //중복순열
    public static void rePermutation(int n, int r, int depth) {

        if(r == depth) {
            //copy에 map의 값 복사
            //copyMap();

            //방향이 만들어내는!!
            for(int i=0; i<5; i++) {
                solution(output[i]);
            }

            //최대값 찾아내기!
            max = Math.max(max, calMax());
            return;
        }

        for(int i=0; i<4; i++) {
            output[depth] = arr[i];
            rePermutation(n, r, depth+1);

        }
    }

    //화살표 방향마다 바뀌는 배열들
    public static void solution(int a) {

            switch (a) {
                //상
                case 1:
                    for(int y=0; y<N; y++) {
                        int newX =0;
                        for(int x=0; x<N; x++) {
                            if(map[x][y] !=0) {
                                copy[newX++][y] = map[x][y];
                            }
                        }
                    }
                    break;

                //하
                case 2:
                    break;
                //좌
                case 3:
                    break;

                //우
                case 4:
                    break;
            }


    }

    public static void copyMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }



    //최대값 찾기
    public static int calMax() {
        int calmax=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                calmax = Math.max(calmax, copy[i][j]);
            }
        }

        return calmax;
    }
}

package Algorithm.binaryserch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Firefly_3020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x, y;
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int cnt =0, repeat=0;
        int min = Integer.MAX_VALUE;

        int[][] obstacle = new int[x][y];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //입력
        for(int i=0; i<y; i++ ){
            int n = Integer.parseInt(br.readLine());

            //종유석
            if(i%2 == 0) {
                for(int k = x-1; k>=x-n; k--) {
                    //System.out.println(k);
                    obstacle[k][i] = 1;
                }
            }
            //석순
            else {
                for(int k = 0; k<n; k++) {
                    obstacle[k][i] = 1;
                }
            }
        }

        for(int i=0; i<x; i++) {
            cnt=0;
            for(int j=0; j<y; j++) {
                if(obstacle[i][j] == 1)
                    cnt++;
            }
            if(min >= cnt) {
                min = cnt;
                priorityQueue.add(min);
            }
        }

        /*for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                System.out.print(obstacle[i][j]);
            }
            System.out.println();
        }*/

        while (!priorityQueue.isEmpty()) {
            int kk = priorityQueue.poll();

            if(kk == min)
                repeat++;
            else
                break;
        }

        System.out.print( min + " " +  repeat);
    }

}

package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SwingArr_17406 {

    static int min =10000;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r;
        int c;
        int s;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int swingNum = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<swingNum; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            int leftR = r-s-1;
            int leftC = c-s-1;
            int rightR = r+s-1;
            int rightC = c+s-1;

            while(leftR != rightR && leftC !=rightC) {

                queue.add(arr[leftR][leftC+1]);
                arr[leftR][leftC+1] = arr[leftR][leftC];

                //위가로
                for(int j=1; j<rightC-leftC; j++) {
                    queue.add(arr[leftR][leftC+j+1]);
                    arr[leftR][leftC+j+1] = queue.poll();

                }

                //오른쪽아래
                for(int j=0; j<rightR-leftR; j++) {
                    queue.add(arr[leftR+j+1][rightC]);
                    arr[leftR+j+1][rightC] = queue.poll();
                }

                //아래가로
                for(int j=0; j<rightC-leftC; j++) {
                    queue.add(arr[rightR][rightC-j-1]);
                    arr[rightR][rightC-j-1] = queue.poll();

                }

                //왼쪽위
                for(int j=0; j<rightR-leftR; j++) {
                    queue.add(arr[rightR-j-1][leftC]);
                    arr[rightR-j-1][leftC] = queue.poll();
                }

                leftR++; leftC++; rightC--; rightR--;
            }

        }

        min(arr, m, n);
    }

    //행렬의 최소값 구하기
    public static void min(int[][] arr, int n, int m) {

        for(int i=0; i<n; i++) {
            int total =0;
            for(int j=0; j<m; j++) {
                total += arr[i][j];
            }
            if(min > total) {
                min = total;
            }
        }
        System.out.println(min);
    }
}

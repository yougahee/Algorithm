package Algorithm.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_4256 {

    static int[] preOrder;
    static int[] inOrder;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            preOrder = new int[N];
            inOrder = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                preOrder[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                inOrder[j] = Integer.parseInt(st.nextToken());
            }

            postOrder(0, N-1, 0);
            System.out.println();

        }
    }

    static void postOrder(int s, int e, int index) {

        for(int i = s; i <= e; i++) {
            if(preOrder[index] == inOrder[i]) {
                postOrder(s, i-1, index+1);
                postOrder(i+1, e, index+i+1-s);
                System.out.print(preOrder[index] + " ");
            }
        }


    }
}

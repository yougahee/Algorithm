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

        }
    }

    static void postOrder(int s, int e, int index) {
        if(index == N) {
            //System.out.println("여기에 언제들어오지?  s: " + s + " e : " + e);
            return;
        }

        int root = preOrder[index];
        int mid = -1;

        //System.out.println(root + " " + s + " " + e);

        for(int i = s; i <= e; i++) {
            if(root == inOrder[i]) {
                mid = i;
                break;
            }
        }

        System.out.println("mid의 값 : " + mid);

        if(mid == -1) return;
        //left
        if(s==e) {
            System.out.print(root + " ");
            return;
        }
        else {
            postOrder(s, mid-1, index+1);
            postOrder(mid+1, e, mid+1);
        }

        //mid
        System.out.print(root + " ");
    }
}

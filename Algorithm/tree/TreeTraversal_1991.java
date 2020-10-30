package Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal_1991 {

    static int[][] arr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';

            arr[a][0] = b;
            arr[a][1] = c;
        }

        prefix(0);
        System.out.println();


        inOrder(0);
        System.out.println();


        postfix(0);
        System.out.println();
    }

    //루트 -> 왼쪽 -> 오른쪽
    public static void prefix(int start) {
        System.out.print(Character.toChars(start+'A'));

        if(arr[start][0] >=0) prefix(arr[start][0]);
        if(arr[start][1] >=0) prefix(arr[start][1]);
    }

    public static void inOrder(int start) {
        if(arr[start][0] >=0) inOrder(arr[start][0]);
        System.out.print(Character.toChars(start+'A'));
        if(arr[start][1] >=0) inOrder(arr[start][1]);
    }

    public static void postfix(int start) {
        if(arr[start][0] >=0) postfix(arr[start][0]);
        if(arr[start][1] >=0) postfix(arr[start][1]);
        System.out.print(Character.toChars(start+'A'));
    }
}

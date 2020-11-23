package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSDFS_1260 {

    public static int arrDB[][];
    public static int isCheckedBFS[];
    public static int isCheckedDFS[];
    static int n;//정점의 개수
    static int m;//간선의 개수
    static int v;//시작하는 점
    static Queue<Integer> bfsQue = new LinkedList<Integer>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        bfsQue.add(v);

        arrDB = new int[n + 1][n + 1];
        isCheckedBFS = new int[n + 1];
        isCheckedDFS = new int[n + 1];

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrDB[x][y] = 1;
            arrDB[y][x] = 1;
        }


        isCheckedDFS[v] =1;
        DFS(v);
        System.out.println();
        BFS();
    }

    public static void DFS(int start) {

        System.out.print(start + " ");

        for(int i=1; i<=n; i++) {
            if(arrDB[start][i] == 1 && isCheckedDFS[i] == 0 ) {
                isCheckedDFS[i] =1;
                DFS(i);
            }
        }
    }

    public static void BFS() {

        //시작되는 정점은 check해놓기
        isCheckedBFS[v] = 1;

        while (!bfsQue.isEmpty()) {

            int start = bfsQue.peek();

            for (int i = 1; i <= n; i++) {
                if (arrDB[start][i] == 1 && isCheckedBFS[i] == 0) {
                    bfsQue.add(i);
                    isCheckedBFS[i] = 1;
                }
            }
            System.out.print(bfsQue.poll() + " ");
        }

    }

}

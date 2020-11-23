package Algorithm.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus_2606 {

    static int N;
    static int map[][];
    static int isChecked[];
    static Queue<Integer> queue;
    static int cnt =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        isChecked = new int[N+1];
        queue = new LinkedList<Integer>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            map[k1][k2] = 1;
            map[k2][k1] = 1;

        }

        queue.add(1);
        isChecked[1] = 1;
        FindVirus();
    }

    public static void FindVirus() {

        while (!queue.isEmpty()) {

            int pop = queue.peek();
            queue.poll();
            cnt++;

            for(int i=1; i<=N; i++) {
                if(map[pop][i] == 1 && isChecked[i]==0) {
                    isChecked[i] = 1;
                    queue.add(i);
                }
            }
        }

        System.out.println(cnt-1);
    }
}

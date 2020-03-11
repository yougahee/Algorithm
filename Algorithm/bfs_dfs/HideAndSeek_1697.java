package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<Integer>();
        int isChecked[] = new int[100001];

        queue.add(N);

        while(!queue.isEmpty()) {

            N = queue.poll();

            if(N==K) {
                break;
            }
            if(N-1>=0 && isChecked[N-1] == 0) {
                isChecked[N-1] = isChecked[N] +1;
                queue.add(N-1);
            }
            if(N+1 <= 100000 && isChecked[N+1] == 0) {
                isChecked[N+1] = isChecked[N] +1;
                queue.add(N+1);
            }
            if(N*2<=100000 && isChecked[N*2] == 0) {
                isChecked[N*2] = isChecked[N] +1;
                queue.add(N*2);
            }
        }

        System.out.println(isChecked[N]);
    }
}

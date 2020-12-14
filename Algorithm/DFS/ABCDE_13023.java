package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static boolean isCheck;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        int a,b;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i=0; i<N; i++) {
            //System.out.println("======== " + i + " =========");
            boolean[] visited = new boolean[N];
            isCheck = false;
            visited[i] = true;
            isConnect(i, visited, 1);
            if(isCheck) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void isConnect(int start, boolean[] visited, int cnt) {
        if(cnt == 5) {
            isCheck = true;
            return;
        }
        //System.out.println("cnt : " + cnt + " start : " + start);

        for(int i=0; i< arr[start].size(); i++) {
            int next = arr[start].get(i);
            if(visited[next]) continue;
            visited[start] = true;
            isConnect(next, visited, cnt+1);
            visited[start] = false;
        }
    }
}

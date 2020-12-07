package Algorithm.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree_4803 {

    static int n;
    static ArrayList<Integer>[] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m, cnt = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            node = new ArrayList[n+1];
            visited = new boolean[n+1];

            for (int i = 0; i < node.length; i++) {
                node[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a,b;
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                node[a].add(b);
                node[b].add(a);
            }

            int ans = 0;
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    if(isTree(i))
                        ans++;
                }
            }

            System.out.print("Case " + cnt + ": ");

            if(ans == 0) System.out.println("No trees.");
            else if(ans == 1) System.out.println("There is one tree.");
            else System.out.println("A forest of " + ans + " trees.");

            cnt++;
        }
    }

    static boolean isTree(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int v =0, e =0;

        while (!q.isEmpty()) {
            int next = q.poll();

            if(visited[next]) continue;

            visited[next] = true;
            v++;

            for(int i=0; i<node[next].size(); i++) {
                int a = node[next].get(i);

                e++;
                q.add(a);
            }
        }

        return e / 2 == v - 1;
    }
}

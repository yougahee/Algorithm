package Algorithm.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다시풀어보기!!!
public class TermProject_9466 {
    static int N;
    static int[] team;

    static int[] visited;
    static int[] finished;

    static int cnt=0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            cnt = 0;
            team = new int[N+1];
            visited = new int[N+1];
            finished = new int[N+1];

            for(int j=1; j<=N; j++) {
                team[j] = Integer.parseInt(st.nextToken());
            }

            //함수
            for(int k=1; k<=N; k++) {
                if(visited[k] ==0) {
                    solution(k);
                }
            }


            System.out.println(N-cnt);
        }
    }


    public static void solution(int start) {

        visited[start] =1;
        int next = team[start];

        if(visited[next] == 0){
            solution(next);
        }else {
            if(finished[next] == 0) {
                cnt++;
                for(int i=next; i!=start; i=team[i]) {
                    cnt++;
                }
            }
        }

        finished[start] =1;
    }
}

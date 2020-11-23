package Algorithm.Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise_1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX = 100000;
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] town = new int[V][V];

        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++)
                town[i][j] = MAX;

        int a,b,c;
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            town[a-1][b-1] = c;
        }

        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    town[i][j] = Math.min(town[i][j], town[i][k] + town[k][j]);
                }
            }
        }

        int answer = MAX;

        for(int i=0; i<V; i++) {
            answer = Math.min(answer, town[i][i]);
        }

        if(answer == MAX) System.out.println(-1);
        else System.out.println(answer);
    }
}

package Algorithm.Floyd_Warshall;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class History_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] history = new int[n][n];
        int max = 100000;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                history[i][j] = (i==j) ? 0 : max;
            }
        }

        int a,b;
        for(int i=0; i<k; i++)  {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            history[a-1][b-1] = 1;
        }

        for(int t=0; t<n; t++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    history[i][j] = Math.min(history[i][j], history[i][t] + history[t][j]);
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i=0; i<s; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(history[a-1][b-1] == max && history[b-1][a-1] == max) System.out.println(0);
            else if(history[a-1][b-1] < history[b-1][a-1])System.out.println(-1);
            else System.out.println(1);
        }
    }
}

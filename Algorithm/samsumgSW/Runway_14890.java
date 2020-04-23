package Algorithm.samsumgSW;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.StringTokenizer;

public class Runway_14890 {

    static int N;
    static int L;

    static int[][] map;
    static int[] visited;

    static int[] road;


    static int cnt=0;

    static int num =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        road = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                road[j] = map[i][j];
            }
            num++;
            solution();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                road[j] = map[j][i];
            }
            num++;
            solution();
        }

        System.out.println(cnt);


    }

    public static void solution() {

        visited = new int[N];

        for(int i=0; i<N-1; i++) {

            //비교,, 뒤가 더 클 때
            if (road[i] - road[i + 1] == -1) {
                if (i - L + 1 < 0 || visited[i] ==1) {
                    return;
                }

                if(L ==1) {
                    visited[i] =1;
                }

                int l =1;

                //앞에 L개를 판별
                while(l < L) {

                    if(road[i] != road[i-l] || visited[i-l] == 1) {
                        return;
                    }
                    visited[i-l] = 1;

                    l++;
                }


            }
            //앞이 더 클 때,
            if (road[i] - road[i + 1] == 1) {

                if (i + L >= N || visited[i+1] == 1) {
                    return;
                }

                if(L ==1) {
                    visited[i+1] =1;
                }

                int l = 1;

                //뒤에 L개를 판별.
                while(l < L) {

                    if(road[i+1] != road[i+l+1] || visited[i+l+1] == 1) {
                        return;
                    }
                    visited[i+l+1] = 1;

                    l++;
                }
            }

            //1이상 차이가 날 경우
            if (Math.abs(road[i] - road[i + 1]) > 1) {
                return;
            }
        }

        //System.out.println("무엇을 판별해야하지..?   " + num);
        cnt++;
    }
}

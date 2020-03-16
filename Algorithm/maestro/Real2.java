package Algorithm.maestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Real2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Boolean result;


        for (int k = 0; k < T; k++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[][] = new int[N + 5][M + 5];
            result = true;

            //입력
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //탐색하면서 볼 거임..!
            //1만 보고 false이면 No 출력하고 끝내기..!
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (arr[i][j] == 1) {
                        int nxR = i + 1;
                        int nxL = i - 1;
                        int nyU = j - 1;
                        int nyD = j + 1;
                        //좌우 중 하나라도 1이 있다면
                        if (arr[nxR][j] == 1 || arr[nxL][j] == 1) {
                            if (arr[i][nyD] == 1 || arr[i][nyU] == 1) {
                                continue;
                            }
                            else{
                                result = false;
                                break;
                            }
                        }
                        else {
                            result = false;
                            break;
                        }
                    }
                }
            }

            if(result) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}

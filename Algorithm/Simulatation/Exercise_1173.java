package Algorithm.Simulatation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise_1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,m,M,T,R;
        N = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int cnt = 0, restCnt =0, originM = m;
        while (N > 0) {
            cnt++;
            if( m+T <= M ) {
                m += T;
                N--;
                restCnt = 0;
            }
            else {
                if( m-R < originM) {
                    if(restCnt != 0) {
                        System.out.println(-1);
                        return;
                    }
                    restCnt++;
                    m = originM;
                }
                else m -= R;
            }
        }
        System.out.println(cnt);
    }
}

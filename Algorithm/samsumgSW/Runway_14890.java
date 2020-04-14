package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Runway_14890 {

    static int N;
    static int L;
    static int[][] map;
    static int num = 0;
    static int[] arr = new int[10];
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<Integer>();

            for (int j = 0; j < L; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                queue.add(map[i][j]);
            }
            //행은 여기서 검사해버리기
            if (roadNum())
                num++;
        }

        for (int i = 0; i < N; i++) {
            queue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                queue.add(map[j][i]);
            }
            //열검사
            if(roadNum())
                num++;
        }

        System.out.println(num);

    }


    public static boolean roadNum() {

        int a = queue.poll();
        int a_cnt = 1;

        while (!queue.isEmpty()) {

            int peak = queue.peek();

            if (a == peak) {
                queue.poll();
                a_cnt++;
            } else {
                //1 이상으로 커버리면,
                if (Math.abs(a - peak) > 1) {
                    //끝내기.. 필요없음
                    return false;
                }
                // 뒤의 값이 작은 것
                else if (a - peak == 1) {

                    for (int i = 1; i < L; i++) {
                        if (queue.peek() == peak) {
                            a = queue.poll();
                        } else {
                            return false;
                        }
                    }
                }
                // 앞의 값이 작은 것
                else if (a - peak == -1) {
                    //끝내기!! 필요없음.
                    if (a_cnt < L) {
                        return false;
                    }
                }
            }

        }
        return true;

    }
}

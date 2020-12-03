package Algorithm.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddSection_2042 {

    static long[] arr;
    static long[] tree;

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N * 4];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        init(0, N - 1, 1);


        int a, b, c;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 배열 update, 구간합 update
            if (a == 1) {
                update(0, N - 1, 1, b - 1, (long) c - arr[b - 1]);
                arr[b - 1] = c;
            }
            // 구간합 출력
            else {
                System.out.println(sum(b - 1, c - 1, 1, 0, N - 1));
            }
        }
    }

    //dif가 바꿀 숫자
    //index가 그 위치에 바뀔 숫자.
    public static void update(int start, int end, int node, int index, long dif) {
        if (index < start || end < index) return;

        tree[node] += dif;
        if (start == end) return;
        int mid = start + (end - start) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }

    public static long sum(int L, int R, int node, int nodeL, int nodeR) {
        if (R < nodeL || L > nodeR) return 0;
        // arr은 구간합이 저장되어있는 노드
        if (L <= nodeL && R >= nodeR) return tree[node];

        int mid = nodeL + (nodeR - nodeL) / 2;
        return sum(L, R, node * 2, nodeL, mid) + sum(L, R, node * 2 + 1, mid + 1, nodeR);
    }

    public static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = start + (end - start) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void print() {
        for (int i = 1; i < tree.length; i++) {
            System.out.println(i + "번째 노드의 구간합 : " + tree[i]);
        }
    }
}

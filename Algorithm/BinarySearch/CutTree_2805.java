package Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree_2805 {

    static int[] treeHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        treeHeight = new int[N];

        int left = 0, right = 0, middle;
        long m_max;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());

            if(right < treeHeight[i])
                right = treeHeight[i];
        }

        while (left <= right) {
            middle = (right+left+1)/2;
            //System.out.println(middle);

            m_max = cutTree(middle);
            //System.out.println(m_max + " m max");

            if(M <= m_max) {
                left = middle + 1;
            }else if (M > m_max){
                right = middle -1;
            }
        }

        System.out.println(right);
    }

    public static long cutTree(int middle) {
        long sum = 0;

        //나무를 자름
        for(int i=0; i<treeHeight.length; i++) {
            if(treeHeight[i] > middle) {
                sum += (treeHeight[i] - middle);
            }
        }

        return sum;
    }
}

package Algorithm.simulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainWater_14719 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        int l[] = new int[W];
        int r[] = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer =0;

        //dp로 간단하게 푸는 방법
        /*
        l[0] = arr[0];
        r[W-1] = arr[W-1];
        for(int i=1; i<W; i++) l[i] = Math.max(l[i-1], arr[i]);
        for(int i= W-2; i>=0; i--) r[i] = Math.max(r[i+1], arr[i]);
        for(int i=0; i<W; i++) answer += Math.max(0, Math.min(l[i], r[i]) - arr[i]);

        System.out.println(answer);*/


        int left = 0, right = 0, high=0;

        for(int i=1; i<W-1; i++) {
            right = findRightHigh(i);
            left = findLeftHigh(i);
            high = Math.min(left, right);

            if(high > arr[i])
                answer += high - arr[i];
        }

        System.out.println(answer);
    }

    public static int findLeftHigh(int index) {
        int left = 0;
        for(int i = 0; i<index; i++) {
            left = Math.max(left, arr[i]);
        }
        return left;
    }

    public static int findRightHigh(int index) {
        int rightHigh = 0;
        for(int i = index+1; i<arr.length; i++) {
            rightHigh = Math.max(rightHigh, arr[i]);
        }
        return rightHigh;
    }
}

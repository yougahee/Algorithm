package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ship_1092 {

    static int N;
    static LinkedList<Integer> box, crane;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        crane = new LinkedList<>();
        for (int i = 0; i < N; i++)
            crane.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        box = new LinkedList<>();
        for (int i = 0; i < M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box);

        System.out.println(moveShip());
    }

    public static int moveShip() {
        int cnt = 0;

        if( crane.get(0) < box.get(box.size()-1) )
            return -1;

        loop:
        while (box.size() > 0) {
            cnt++;

            for (int i = 0; i < N; i++) {
                int craneWeight = crane.get(i);

                if(box.size() == 0) break loop;
                if(box.get(0) > craneWeight) continue;

                int left = 0, middle = 0, ans = 0;
                int right = box.size()-1;

                while (left <= right) {
                    middle = (left + right) / 2;

                    if( box.get(middle) <= craneWeight ) {
                        ans = middle;
                        left = middle + 1;
                    }
                    else {
                        right = middle - 1;
                    }
                }

                box.remove(ans);
            }
        }

        return cnt;
    }
}

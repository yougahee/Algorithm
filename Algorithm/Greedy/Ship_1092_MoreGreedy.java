package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//시간초과 남.. 왜지??
//왜 시간초과 나지?
public class  Ship_1092_MoreGreedy{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> crane = new LinkedList<>();
        for (int i = 0; i < N; i++)
            crane.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> box = new LinkedList<>();
        for (int i = 0; i < M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if( crane.get(0) < box.get(0) ) {
            System.out.println(-1);
            return;
        }

        //시간초과남 --> 어디서 잘못된 것일까?
        int cnt =0;
        while (box.size() > 0) {
            cnt++;

            int index = 0;
            for (int i = 0; i < box.size(); i++) {
                if(index == N) break;

                if(crane.get(index) >= box.get(i)) {
                    box.remove(i);
                    i--;
                    index++;
                }
            }
        }

        System.out.println(cnt);
    }
}

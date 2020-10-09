package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ship_1092 {

    static int N,M, cnt = 0;
    static ArrayList<Integer> box, crane;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        crane = new ArrayList<>();
        for(int i=0; i<N; i++)
            crane.add(Integer.parseInt(st.nextToken()));


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        box = new ArrayList<>();
        for(int i=0; i<M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        moveShip();
    }

    public static void moveShip() {

        while (box.size() > 0) {
            if(crane.size() == 0) {
                System.out.println(-1);
                return;
            }

            cnt++;

            for(int i=0; i<crane.size(); i++) {
                for(int j=0; j<box.size(); j++) {
                    if( crane.get(i) >= box.get(j) ) {
                        box.remove(j);
                        break;
                    }
                    else if( j == box.size()-1 ) {
                        crane.remove(i);
                        break;
                    }
                }
            }
        }

        //System.out.println("cnt : " + cnt + " box : " +  box.size() + " crane : " + crane.size());
        System.out.println(cnt);
    }
}

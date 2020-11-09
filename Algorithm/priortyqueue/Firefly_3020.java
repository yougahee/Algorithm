package Algorithm.priortyqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Firefly_3020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, H;
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int cnt =0, repeat=0;
        int min = Integer.MAX_VALUE;

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //입력
        int num = 0;
        for(int i=0; i<N; i++ ){
            num = Integer.parseInt(br.readLine());

            if(i%2 == 0) minPQ.add(num);
            else maxPQ.add(num);
        }

        int up = 0;
        for(int i=1; i<=H; i++) {
            cnt = 0;

            //석순
            while (!minPQ.isEmpty()) {
                if(minPQ.peek() >= i) break;

                minPQ.poll();
            }

            //종유석
            while (!maxPQ.isEmpty()) {
                if(maxPQ.peek() < H - i + 1) break;

                maxPQ.poll();
                up++;
            }

            cnt = minPQ.size() + up;

            //System.out.println("min의 사이즈 : " + minPQ.size() + " up의 크기 : " + up);
            if(min > cnt) {
                min = cnt;
                repeat = 1;
            }
            else if(min == cnt) repeat++;
        }

        System.out.print( min + " " +  repeat );
    }
}

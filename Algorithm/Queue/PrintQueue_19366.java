package Algorithm.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PrintQueue_19366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int n,m;

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Queue<Document> docu = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++) {
                int impo = Integer.parseInt(st.nextToken());
                docu.add(new Document(k, impo));
                pq.add(impo);
            }

            int cnt = 0;
            while (!docu.isEmpty()) {
                Document d = docu.poll();

                if( d.important == pq.peek() ) {
                    pq.poll();
                    cnt++;

                    if( d.index == m ) break;
                }
                else docu.add(d);

            }

            System.out.println(cnt);
        }
    }

    static class Document {
        int index, important;

        public Document(int i, int p) {
            this.index = i;
            this.important = p;
        }
    }
}

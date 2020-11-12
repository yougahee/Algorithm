package Algorithm.priortyqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RuleOfToilet_19640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        LinkedList<People>[] employee = new LinkedList[M];

        for(int i=0; i<M; i++) employee[i] = new LinkedList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            employee[i % M].add(new People(x,y,i % M, i));
        }

        PriorityQueue<People> waitingPeople = new PriorityQueue<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                int workingDay =  o2.x - o1.x;
                if(workingDay == 0){
                    int hurry = o2.y - o1.y;
                    if(hurry == 0) return o1.room - o2.room;
                    return hurry;
                }
                return workingDay;
            }
        });

        for(int i=0; i<M; i++) {
            if(employee[i].size() == 0) break;
            People people = employee[i].remove(0);
            waitingPeople.add(people);
        }

        while (!waitingPeople.isEmpty()) {
            cnt++;
            People people = waitingPeople.poll();
            //System.out.println(" index " + people.num + " room : " + people.room+ " x : " + people.x + " y : " + people.y);

            if(people.num == K) break;
            if(employee[people.room].size() == 0) continue;

            waitingPeople.add(employee[people.room].remove(0));
        }

        System.out.println(cnt-1);
    }

    static class People {
        int x, y, room, num;

        public People( int x, int y, int room, int num) {
            this.x = x;
            this.y = y;
            this.room = room;
            this.num = num;
        }
    }
}

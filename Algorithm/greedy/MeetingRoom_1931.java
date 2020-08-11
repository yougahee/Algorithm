package Algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom_1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Time[] room = new Time[N];

        int s_time, e_time, cnt = 1;

        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());

            s_time = Integer.parseInt(st.nextToken());
            e_time = Integer.parseInt(st.nextToken());

            room[i] = new Time(s_time, e_time);
        }

        Arrays.sort(room);

        int index = room[0].end;

        for(int i=1; i<room.length; i++) {
            if(index <= room[i].start ) {
                cnt++;
                index = room[i].end;
            }
        }

        System.out.println(cnt);
    }

    static class Time implements Comparable<Time> {

        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 끝나는 시간이 빠른 순으로,
        // 끝시간이 같다면 늦게 시작하는 순으로 나열
        @Override
        public int compareTo(Time o) {
            int r = this.end - o.end;

            if(r == 0) {
                r = this.start - o.start;
            }
            return r;
        }
    }
}

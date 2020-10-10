package Algorithm.test_coupang2020;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {

        String[] orders = {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
        String[] orders1 = {"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"};

        //4
        System.out.println(solution(3, orders));
        //2
        System.out.println(solution(2, orders1));
    }

    public static int solution(int n, String[] customers) {
        ArrayList<Work> customerArr = new ArrayList<>();
        ArrayList<Kiosk> kiostArr = new ArrayList<>();
        int[] kiosk = new int[n + 1];

        for (int i = 0; i < customers.length; i++) {
            String[] info = customers[i].split(" ");
            int endTime = calEndTime(info[0], info[1], info[2]);
            //customerArr.add(new Work(0, endDate, endTime, Integer.parseInt(info[2])));
        }

        PriorityQueue<Kiosk> pq = new PriorityQueue(new Comparator<Kiosk>() {
            @Override
            public int compare(Kiosk o1, Kiosk o2) {
                int date = o1.lastWorkDate - o2.lastWorkDate;

                if (date == 0) {
                    int time = o1.lastWorkTime - o2.lastWorkTime;
                    if (time == 0)
                        return o1.n - o2.n;
                    return time;
                }
                return date;
            }
        });

        //pq에 다 넣어
        for (int i = 1; i <= n; i++) {
            pq.add(new Kiosk(i, 0, 0));
        }

        int lastDate = 0;
        int lastTime = 0;
        for (int i = 0; i < customerArr.size(); i++) {
            Work cust = customerArr.get(i);
            Kiosk kiosk1 = pq.poll();

            //대기를 한 경우 --> endTime으로 들어가면 안됨. startTime으로 들어가야함.
            if (kiosk1.lastWorkDate >= cust.endDate && kiosk1.lastWorkTime >= cust.endTime) {
                //### 와후 --> 계산이 한번 더 들어가야 함...
                // lastWorkDate, lastWorkTime --> 00시가 넘을 수도 있으니까.
                pq.add(new Kiosk(kiosk1.n, kiosk1.lastWorkDate, kiosk1.lastWorkTime + cust.time));
            } else {
               // pq.add(new Kiosk(kiosk1.n, work.));
            }
        }

        Arrays.sort(kiosk);
        return kiosk[n];
    }

    public static int calEndTime(String date, String start, String working) {
        int endTime = 0;
        int[] month = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        int monthInx = Integer.parseInt(date.substring(0, date.indexOf("/")));
        endTime += month[monthInx] + Integer.parseInt(date.substring(date.indexOf("/") + 1));

        String[] time = start.split(":");
        endTime += Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
        return endTime + Integer.parseInt(working);
    }

    public static class Work {
        int n;
        int endDate;
        int endTime;
        int time;

        public Work(int n, int endDate, int endTime) {
            this.n = n;
            this.endDate = endDate;
            this.endTime = endTime;
        }

        public Work(int n, int endDate, int endTime, int time) {
            this.n = n;
            this.endDate = endDate;
            this.endTime = endTime;
            this.time = time;
        }
    }

    public static class Kiosk {
        int n;
        int lastWorkDate;
        int lastWorkTime;

        public Kiosk(int n, int lastWorkDate, int lastWorkTime) {
            this.n = n;
            this.lastWorkDate = lastWorkDate;
            this.lastWorkTime = lastWorkTime;
        }
    }
}

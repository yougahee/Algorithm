package Algorithm.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//시간복잡도 생각하기
public class StartTaxi_19238 {

    static int n;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int taxiX = Integer.parseInt(st.nextToken()) - 1;
        int taxiY = Integer.parseInt(st.nextToken()) - 1;

        boolean[] visitedCustomer = new boolean[m];
        LinkedList<Customer> customers = new LinkedList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int dis = findMinDistance(sx,sy,ex,ey);

            if(dis == -1){
                System.out.println(-1);
                return;
            }

            customers.add(new Customer(sx, sy, ex,ey, dis));
        }


        for(int i=0; i<m; i++) {
            int minDistance = Integer.MAX_VALUE;
            int nextCusIdx = 0;

            //다음으로 태울 손님 찾기 --> 이 부분을 시간복잡도 바꾸기
            for(int j=0; j<m; j++) {
                if(visitedCustomer[j]) continue;

                Customer c = customers.get(j);
                int dis = findMinDistance(taxiX, taxiY, c.startX, c.startY);

                if(dis == -1) {
                    System.out.println(-1);
                    return;
                }

                if(minDistance > dis){
                    minDistance = dis;
                    nextCusIdx = j;
                }

                if(minDistance == dis) {

                }
            }

            fuel -= minDistance;
            fuel -= customers.get(nextCusIdx).distance;
            taxiX = customers.get(nextCusIdx).endX;
            taxiY = customers.get(nextCusIdx).endY;

            if( fuel < 0 ) break;

            fuel += customers.get(nextCusIdx).distance * 2;
            visitedCustomer[nextCusIdx] = true;

        }

        if( fuel < 0 ) {
            System.out.println(-1);
            return;
        }

        System.out.println(fuel);
    }

    //최대 시간복잡도 ==> O(n^2) --> n = 20, n^2 = 400 = m
    static int findMinDistance (int sx, int sy, int ex, int ey) {

        boolean[][] visited = new boolean[n][n];
        Queue<Customer> queue = new LinkedList<>();

        queue.add(new Customer(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Customer cust = queue.poll();

            if(cust.startX == ex && cust.startY == ey) {
                return cust.distance;
            }

            for(int i=0; i<4; i++) {
                int nx = dx[i] + cust.startX;
                int ny = dy[i] + cust.startY;

                if(nx < 0 || nx >= n || ny < 0 || ny >= n ) continue;
                if(map[nx][ny] == 1) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Customer(nx, ny, cust.distance + 1));
            }
        }

        return -1;
    }


    static class Customer {
        int startX, startY;
        int endX, endY;
        int distance;

        public Customer(int startX, int startY, int endX, int endY, int distance) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.distance = distance;
        }

        public Customer(int startX, int startY, int dis) {
            this.startX = startX;
            this.startY = startY;
            this.distance = dis;
        }
    }
}

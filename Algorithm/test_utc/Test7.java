package Algorithm.test_utc;

public class Test7 {
    public static void main(String[] args) {
        System.out.println(solution(4, true));
    }

    //대각선 아래, 위
    static int[] kx = {1, -1};
    static int[] ky = {-1, 1};

    //오른쪽, 아래
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];

        int second = 0;
        int x = 0, y = 0, index = 0;

        if (!horizontal) index = 1;

        while (true) {
            if (x == n - 1 && y == n - 1) break;

            //오른쪽 or 아래
            int nx = dx[index % 2] + x;
            int ny = dy[index % 2] + y;

            //범위에 벗어나면
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                nx = dx[(index + 1) % 2] + x;
                ny = dy[(index + 1) % 2] + y;
            }

            System.out.println("x의 값 : " + x + " y : " + y);
            System.out.println(nx + "  " + ny);
            answer[nx][ny] = ++second;
            x = nx;
            y = ny;

            print(answer);

            //대각선 아래 or 위
            int xx = kx[index % 2] + x;
            int xy = ky[index % 2] + y;

            // 대각선 아래
            while (xx >= 0 && xx < n && xy >= 0 && xy < n) {
                second += 2;
                answer[xx][xy] = second;
                x = xx;
                y = xy;
                xx += kx[index % 2];
                xy += ky[index % 2];
            }

            print(answer);

            index++;
        }

        return answer;
    }

    static void print(int[][] map) {
        System.out.println("==============");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

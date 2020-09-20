package Algorithm.line2021;

public class Line4 {
    public static void main(String[] args) {
        int[][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};

        System.out.println(solution(maze));
    }

    static int cnt =0;
    //상에서 반시계방향
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;

    public static int solution(int[][] maze) {
        int answer = 0;
        //0 -> 아래, 반시계방향으로 회전 direction+1%4
        int direction  = 0;
        n = maze.length;

        move(0,0, direction, maze);

        return cnt;
    }

    public static void move(int x, int y, int dir, int[][] maze) {

        int nx = x + dx[(dir+1)%4];
        int ny = y + dy[(dir+1)%4];
        cnt++;

        if(x == n-1 && y == n-1)
            return;

        //왼쪽에 벽이 있는지 확인
        //있다면 이동, 없으면 방향틀기
        while (!leftRight(nx, ny, maze)) {
            dir = (dir+1)%4;
            nx = x + dx[(dir+1)%4];
            ny = y + dy[(dir+1)%4];
        }

        move(x + dx[dir], y + dy[dir], dir, maze);
}

    public static boolean leftRight(int x, int y, int[][] maze) {
        if(( x < 0 || x >= n || y < 0 || y >= n )) {
            return true;
        }

        if(maze[x][y] == 1)
            return true;

        return false;
    }

}

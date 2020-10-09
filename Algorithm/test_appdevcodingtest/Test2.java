package Algorithm.test_appdevcodingtest;

public class Test2 {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


        System.out.println(solution(arr));
    }

    static int[] dx = {1, 0, 1, 1}; //하우 , 아래 대각선(오), 대각선(왼)
    static int[] dy = {0, 1, 1, -1}; //하우

    static int[][] isVisited;

    public static int solution(int[][] moves) {
        int blackCnt =0;
        int whiteCnt =0;

        isVisited = new int[15][15];

        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                //흑의 연속 개수가 몇개?
                if(moves[i][j] == 1) {
                    //System.out.println(i + "  " + j);
                    blackCnt = Math.max(blackCnt, count(i, j,1, moves));
                }

                //백의 연속 개수가 몇개?
                if(moves[i][j] == 2) {

                    //System.out.println("white : " + i + "  " + j);
                    whiteCnt = Math.max(whiteCnt, count(i, j,1, moves));
                }
            }
        }

        //System.out.println(blackCnt + " " + whiteCnt);
        if(blackCnt == 5 && whiteCnt != 5) {
            return 1;
        }
        else if(blackCnt !=5 && whiteCnt == 5) {
            return 2;
        }
        else
            return 0;
    }

    public static int count(int x, int y, int color, int[][] maps) {
        int count=0;
        int nx;
        int ny;

        for(int k=0; k<4; k++) {
            nx = x + dx[k];
            ny = y + dy[k];

            //System.out.println(nx + " nx " + " ny " + ny );

            //범위 안에 있고
            if(nx >=0 && nx <15 && ny >=0 && ny <15) {
                if(maps[nx][ny] == color){

                    //아래면 아래, 오른쪽이면 오른쪽 연속해서 몇개가 있는지 확인해야한다.
                    //최대값만 보낸다.
                     count = Math.max(count, isCount(nx, ny, k, color, maps));
                   // System.out.println(count);

                }
            }
        }

        return count;
    }

    public static int isCount(int x, int y, int dir, int color, int[][] maps) {
        int count=1;

        while (color == maps[x][y]){
            x = x + dx[dir];
            y = y + dy[dir];

            count++;
        }

        return count;
    }


}

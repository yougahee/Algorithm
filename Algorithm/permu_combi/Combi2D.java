package Algorithm.permu_combi;

//2차원 배열 조합
public class Combi2D {

    static int n = 3;
    static int m = 3;

    public static void main(String[] args) {

        int[][] map = new int[n][m];
        comb(map, 0, 0);
    }

    static void comb(int[][] map, int start, int depth) {
        if (depth == 3) {
            print(map);
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                comb(map, i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

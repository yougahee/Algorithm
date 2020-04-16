package Algorithm.testnaverhack;

public class Num1 {
    public static void main(String[] args) {

        int n = 6;
        int[][] delivery = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};
        int[] perchase = new int[n];

        for (int[] order : delivery) {

            int a = order[0] - 1;
            int b = order[1] - 1;

            if (order[2] == 1) {
                perchase[a] = 1;
                perchase[b] = 1;
            } else if (order[2] == 0) {
                if (perchase[a] == 1) {
                    perchase[b] = 2;
                }

                if (perchase[b] == 1) {
                    perchase[a] = 2;
                }
            }
        }

        System.out.println(makeItemSoldoutStatusString(perchase));
    }

    private static String makeItemSoldoutStatusString(int[] itemSoldoutStatus) {

        StringBuilder sb = new StringBuilder();
        for (int i : itemSoldoutStatus) {
            switch (i) {
                case 0:
                    sb.append("?");
                    break;
                case 1:
                    sb.append("O");
                    break;
                case 2:
                    sb.append("X");
                    break;
            }
        }
        return sb.toString();

    }
}

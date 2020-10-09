package Algorithm.test_line2021;

import java.util.HashMap;

public class Line1 {
    public static void main(String[] args) {
        int[][] boxes = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(solution(boxes));
    }

    public static int solution(int[][] boxes) {
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<boxes.length; i++) {
            int a = boxes[i][0];
            int b = boxes[i][1];

            if (hashMap.containsKey(a)) {
                hashMap.put(a, hashMap.get(a) + 1);
            } else {
                hashMap.put(a, 1);
            }
            if (hashMap.containsKey(b)) {
                hashMap.put(b, hashMap.get(b) + 1);
            } else {
                hashMap.put(b, 1);
            }
        }

        for(int value : hashMap.values()) {
            if(value%2 == 1)
                answer++;
        }

        return answer/2;
    }
}

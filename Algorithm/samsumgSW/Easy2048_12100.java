package Algorithm.samsumgSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Easy2048_12100 {

    static int N;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(map, 0);
        System.out.println(max);
    }

    public static void DFS(int[][] mapCopy, int depth) {
        if(depth == 5){
            max = Math.max(max, maxValue(mapCopy));
            return;
        }
        DFS(upMove(mapCopy), depth+1);
        DFS(downMove(mapCopy), depth+1);
        DFS(leftMove(mapCopy), depth+1);
        DFS(rightMove(mapCopy), depth+1);
    }

    //상
    // 내가 값을 바꿔서 집어 넣었는데 바꿔서 집어넣은 값이 앞의 값과 또 같을 경우가 있다.
    public static int[][] upMove(int[][] map) {
        Stack<Integer> stack = new Stack<>();;
        int[][] copyMap = new int[N][N];
        boolean flag = true;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[j][i] != 0) {
                    if(stack.isEmpty()) stack.add(map[j][i]);
                    else if( flag && stack.peek() == map[j][i]) {
                        stack.add(stack.pop()*2);
                        flag = false;
                        continue;
                    }
                    else stack.add(map[j][i]);
                    flag = true;
                }
            }

            int index = stack.size()-1;
            while (!stack.isEmpty()) {
                copyMap[index--][i] = stack.pop();
            }
        }
        //printMap(copyMap);
        return copyMap;
    }

    //하
    public static int[][] downMove(int[][] map) {
        Stack<Integer> stack = new Stack<>();
        int[][] copyMap = new int[N][N];
        boolean flag = true;

        for(int i=0; i<N; i++) {
            for(int j=N-1; j>=0; j--) {
                if(map[j][i] != 0) {
                    if(stack.isEmpty()) stack.add(map[j][i]);
                    else if( flag && stack.peek() == map[j][i]) {
                        stack.add(stack.pop()*2);
                        flag = false;
                        continue;
                    }
                    else stack.add(map[j][i]);
                    flag = true;
                }
            }
            int index = N - stack.size();
            while (!stack.isEmpty()) {
                copyMap[index++][i] = stack.pop();
            }
        }

        //printMap(copyMap);
        return copyMap;
    }

    //좌
    public static int[][] leftMove(int[][] map) {
        Stack<Integer> stack = new Stack<>();
        int[][] copyMap = new int[N][N];
        boolean flag = true;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0) {
                    if(stack.isEmpty()) stack.add(map[i][j]);
                    else if( flag && stack.peek() == map[i][j]) {
                        stack.add(stack.pop()*2);
                        flag = false;
                        continue;
                    }
                    else stack.add(map[i][j]);
                    flag = true;
                }
            }
            int index = stack.size()-1;
            while (!stack.isEmpty()) {
                copyMap[i][index--] = stack.pop();
            }
        }

        //printMap(copyMap);
        return copyMap;
    }

    //우
    public static int[][] rightMove(int[][] map) {
        Stack<Integer> stack;
        int[][] copyMap = new int[N][N];
        boolean flag = true;

        for(int i=0; i<N; i++) {
            stack = new Stack<>();
            for(int j=N-1; j>=0; j--) {
                if(map[i][j] !=0 ) {
                    if(stack.isEmpty()) stack.add(map[i][j]);
                    else if( flag && stack.peek() == map[i][j]) {
                        stack.add(stack.pop()*2);
                        flag = false;
                        continue;
                    }
                    else stack.add(map[i][j]);
                    flag = true;
                }
            }
            int index = N - stack.size();
            while (!stack.isEmpty()) {
                copyMap[i][index++] = stack.pop();
            }
        }

        //printMap(copyMap);
        return copyMap;
    }

    public static int maxValue(int[][] map) {
        int maxValue = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(maxValue < map[i][j])
                    maxValue = map[i][j];
            }
        }
        return maxValue;
    }

    public static void printMap(int[][] map) {
        System.out.println("=======================");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

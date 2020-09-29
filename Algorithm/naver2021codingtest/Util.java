package Algorithm.naver2021codingtest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Util {
    //union find
    static int[] set;

    public static void main(String[] args) {
        //우선순위큐
        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());

    }

    //binary search
    public static void binarySearch() {
        int left=0, right=0, middle;
        int ans =0, cnt =0;

        while (left <= right) {
            middle = (left + right) / 2;

            //###조건은 내가 작성해야한다아이잉
            if (cnt < middle) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }

    //조합(중복X)
    public static void comb(int[] arr, int[] output, int n, int r, int index, int target) {

        if(r == 0) System.out.println(Arrays.toString(output));
        else if(target == n) return;
        else{
            output[index] = arr[target];
            comb(arr, output,n,r-1, index+1, target+1);//뽑는 경우
            comb(arr, output, n, r, index, target+1);//안뽑는 경우
        }
    }

    //중복조합
    public static void recomb(int[] arr, int[] output, int n, int r, int index, int target) {
        if(r ==0) System.out.println(Arrays.toString(output));
        else if(target == n) return;
        else {
            output[index] = arr[target];
            recomb(arr, output, n, r-1, index+1, target); //뽑는 경우
            recomb(arr, output, n, r, index, target+1); //안뽑는 경우
        }
    }

    //순열(nPr)
    public static void Permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {

        if(r == depth){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                Permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
                output[depth] =0;
            }
        }
    }

    //중복순열nㅠr
    public static void repermutation(int[] arr, int[] output, int depth, int n, int r) {

        if(r == depth) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=0; i<n; i++) {
            output[depth] = arr[i];
            repermutation(arr, output, depth+1, n, r);
        }
    }

    //union find
    static int find(int n) {
        if(set[n] == n) return n;
        set[n] = find(set[n]);
        return set[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;
        set[b] = a;
    }

}

//dfs

//bfs
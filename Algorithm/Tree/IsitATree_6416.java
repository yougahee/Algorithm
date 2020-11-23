package Algorithm.Tree;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//트리 문제 트라우마를 없애보자..!
public class IsitATree_6416 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int k = 1, u = 0, v=0, sum = 0;
        boolean end = false;
        Set<Integer> set = new HashSet<>();

        while (true) {
            set.clear();
            sum =0;
            while (true) {
                u = sc.nextInt();
                v = sc.nextInt();

                if(u < 0 && v < 0) {
                    end = true;
                    break;
                }

                if(u == 0 && v == 0)
                    break;

                set.add(u);
                set.add(v);
                sum++;
            }

            if(end) break;

            if(sum ==0 || sum+1 == set.size()) System.out.println("Case " + k +" is a tree.");
            else System.out.println("Case " + k +" is not a tree.");
            k++;
        }
    }
}

package Algorithm.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FriendNetwork_4195 {

    static int[] p;
    static HashMap<String, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int F;
        String f1, f2;
        int value1, value2, index;

        for(int i=0; i<T; i++) {
            F = Integer.parseInt(br.readLine());

            value1 = 0;
            value2 = 0;
            index = 1;
            hashMap = new HashMap<>();
            p = new int[200002];

            for(int j=0; j<F; j++) {
                st = new StringTokenizer(br.readLine());
                f1 = st.nextToken();
                f2 = st.nextToken();

                if(hashMap.containsKey(f1)) {
                    value1 = hashMap.get(f1);
                }
                else {
                    hashMap.put(f1, index);
                    p[index] = -1;
                    value1 = index;
                    index++;
                }

                if(hashMap.containsKey(f2)) {
                    value2 = hashMap.get(f2);
                }
                else {
                    hashMap.put(f2, index);
                    p[index] = -1;
                    value2 = index;
                    index++;
                }

                //System.out.println("value1 : " + value1 + " value2 : " + value2);
                union(value1, value2);
                //System.out.println("루트 값 : " + find(value1));
                System.out.println(Math.abs(p[find(value1)]));
            }
        }
    }

    public static int find(int n){
        if(p[n] < 0) return n;
        p[n] = find(p[n]);
        return p[n];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        p[a] += p[b];
        p[b] = a;
    }
}

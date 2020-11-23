package Algorithm.Hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class FindNumber  {
    public static void main(String[] args) throws Exception{
        int N;
        int M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> hashSet = new HashSet<>();

        N = Integer.parseInt(br.readLine());

        String[] strArr = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            hashSet.add(strArr[i]);
        }

        M = Integer.parseInt(br.readLine());
        String[] mStrArr = br.readLine().split(" ");

        for(int i=0; i<M; i++) {
            if( hashSet.contains(mStrArr[i])) {
                bw.write(1 + "\n");
            }else {
                bw.write(0 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

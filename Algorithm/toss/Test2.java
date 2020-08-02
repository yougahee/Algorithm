package Algorithm.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

//testcase 1개 통과 못함...
public class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] input_split = input.split(" ");
        String[] clone_array = input_split.clone();
        HashSet<String> hashSet = new HashSet<>();
        int range_int =0;

        Arrays.sort(clone_array);

        //길이가 6인지, 오름차순
        if(input_split.length != 6 || !Arrays.equals(input_split, clone_array)) {
            System.out.println(false);
            return;
        }

        //중복인지 확인하기, 숫자 범위 안에 있나?
        for(int i=0; i<input_split.length; i++) {
            range_int = Integer.parseInt(input_split[i]);

            if(hashSet.contains(input_split[i]) || range_int < 1 || range_int > 45) {
                System.out.println(false);
                return;
            }
            else{
                hashSet.add(input_split[i]);
            }
        }

        System.out.println(true);
    }

}

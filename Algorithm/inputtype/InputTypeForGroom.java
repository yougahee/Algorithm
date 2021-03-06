package Algorithm.inputtype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputTypeForGroom {

    static char map[][];
    static int intmap[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //int형 공백으로 입력 --> 보통..!
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //String 으로 입력받아서 char 하나씩 배열에 넣기
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        //String 으로 입력받아서 int형으로 넣기
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                intmap[i][j] = str.charAt(j) - '0';
            }
        }

    }
}

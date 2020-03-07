package Algorithm.samsumgSW;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class TestSite_13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int peopleNum[];
        long cnt=0;
        int N;

        N = Integer.parseInt(br.readLine());
        peopleNum = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            peopleNum[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            int a = peopleNum[i] - b;
            cnt++;
            if(a!=0 && a>0) {
                //몫
                long re = a/c;

                cnt = cnt + re;
                if(a%c != 0){
                    cnt = cnt +1;
                }
            }
        }

        System.out.println(cnt);


    }
}

package Algorithm.test_appdevcodingtest;

public class Test3 {
    public static void main(String[] args) {

        String command = "<v>AB^CYv^XAZ";
        String[] buttons = {"v>AB^CYv^XA","<v>A","^XAZ","Yv^XA",">AB^"};
        int[] scores = {50, 18, 20, 30, 25};

        System.out.println(solution(command, buttons, scores));

    }

    public static int solution(String command, String[] buttons, int[] scores) {
        int answer = command.length();
        int[] arr = new int[buttons.length];

        for(int i=0; i<buttons.length; i++) {
            arr[i] = i;
        }

        for(int i=1; i<buttons.length; i++) {
            int[] output = new int[i];
            comb(arr, output, arr.length, i, 0,0);
        }


        return answer;
    }

    //조합(중복X)
    public static void comb(int[] arr, int[] output, int n, int r, int index, int target) {

        if(r == 0) {
            //output 값
        }
        else if(target == n) return;
        else{
            output[index] = arr[target];
            comb(arr, output,n,r-1, index+1, target+1);//뽑는 경우
            comb(arr, output, n, r, index, target+1);//안뽑는 경우
        }
    }




}

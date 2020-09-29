package Algorithm.n_tech_test;

public class Test3 {
    public static void main(String[] args) {
        int a[] = {2, 2, 2, 3};
        System.out.println(solution(a));
    }

    public static int solution(int[] histogram) {
        int max = 0, sum =0, maxEndHigh=0, maxStartHigh =0,end_high, start_high;

        for(int i=histogram.length-1; i>0; i--) {
             end_high = histogram[i];
             //System.out.println("end_high" + end_high );

             if(maxEndHigh > end_high){
                 continue;
             }
             maxEndHigh = end_high;
             maxStartHigh =0;

            for(int j=0; j<i; j++) {
                sum =0;
                start_high = histogram[j];
                //System.out.println("start_high" + start_high );

                //탈출 조건
                if(maxStartHigh > start_high)
                    continue;

                //System.out.println(i-j-1);

                if(end_high > start_high)
                    sum = start_high * (i-j-1);
                else
                    sum = end_high * (i-j-1);
                max = Math.max(sum, max);
            }
        }

        return max;
    }

/*
    public int solution(int[] histogram) {
        int answer = 0;
        int max = 0, sum =0;

        int start =0, end = histogram.length-1;

        while (start < end) {
            int l = histogram[start];
            int r = histogram[end];

            if(l <= r)
                start++;
            else
                end--;

        }



        return answer;
    }*/
}

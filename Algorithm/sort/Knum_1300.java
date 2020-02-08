package Algorithm.sort;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.lang.reflect.Array;
        import java.util.Arrays;

public class Knum_1300 {

    static int[] resultArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCase = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        //int[][] a = new int[inputCase][inputCase];
        int[] b = new int[inputCase*inputCase];

        int cnt =0;

        for(int i=1; i<=inputCase; i++) {
            for(int j=1; j<=inputCase; j++) {
                //a[i-1][j-1] = i*j;
                b[cnt++] = i*j;
            }
        }
        //Arrays.sort(b);

        mergeSort(b, 0, b.length-1);

        System.out.println(b[num-1]);
    }


    static public void mergeSort(int arr[], int m, int n) {

        int middle;

        if (m < n) {
            middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            Merge(arr, m, n, middle);
        }
    }

    static public void Merge(int[] arr, int m, int n, int middle) {

        int i = m;
        int j = middle+1;
        int k = m;

        while (i<=middle && j<=n) {
            if(arr[i] <= arr[j]) {
                resultArr[k++] = arr[i++];
            }else {
                resultArr[k++] = arr[j++];
            }
        }

        while (i<=middle) {
            resultArr[k++] = arr[i++];
        }
        while (j<=n) {
            resultArr[k++] = arr[j++];
        }

        for(int a=m; a<=n; a++) {
            arr[a] = resultArr[a];
        }
    }
}

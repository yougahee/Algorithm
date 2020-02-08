package Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort2_2751 {

    static int[] resultArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int[] arr = new int[testCase];
        resultArr = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

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

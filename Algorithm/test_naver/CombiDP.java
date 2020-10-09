package Algorithm.test_naver;

import java.util.ArrayList;
import java.util.HashSet;

public class CombiDP {

    static ArrayList<String> realUsearray;
    static int max = 0;


    public static void main(String[] args) {


      String[] strArr = {"co", "dil", "ity"};
//        String[] strArr = {"abc", "yyy", "def", "csv"};
//      String[] strArr = {"potato", "kayak", "banana", "racecar"};
//        String[] strArr = {"eva", "jqw", "tyn", "jan"};

        setUseArray(strArr);

    }

    //"yyy"같이 하나의 문자열에서 중복되는 것은 배열에서 제외
    public static void setUseArray(String[] strArr) {
        realUsearray = new ArrayList<>();
        HashSet<Character> hashSet = new HashSet();

        for (int i = 0; i < strArr.length; i++) {

            boolean flag = true;
            hashSet.clear();

            for (int j = 0; j < strArr[i].length(); j++) {
                char alphabet = strArr[i].charAt(j);

                if (hashSet.contains(alphabet)) {
                    flag = false;
                    //이 break를 하면 어디로 가는지..?
                    break;
                } else {
                    hashSet.add(alphabet);
                }
            }

            if (flag) {
                realUsearray.add(strArr[i]);
            }
        }

        int[] arr;
        int[] output;
        arr = new int[realUsearray.size()];
        for (int i = 0; i < realUsearray.size(); i++) {
            arr[i] = i;
        }

        for (int j = 1; j <= realUsearray.size(); j++) {
            output = new int[j];
            Combi(arr, output, 0, realUsearray.size(), j, 0);
        }

        System.out.println(max);
    }

    //조합
    public static void Combi(int[] strArr, int[] output, int step, int n, int r, int target) {
        if (r == 0) {
            int count = 0;
            HashSet<Character> set = new HashSet();

            for (int i = 0; i < output.length; i++) {
                for (int j = 0; j < realUsearray.get(output[i]).length(); j++) {
                    char alphabet = realUsearray.get(output[i]).charAt(j);
                    if (set.contains(alphabet)) {
                        break;
                    } else {
                        set.add(alphabet);
                        count++;
                    }
                }

                if (max < count) {
                    max = count;
                }
            }

        } else if (n == target) return;
        else {
            output[step] = strArr[target];

            Combi(strArr, output, step + 1, n, r - 1, target + 1);
            Combi(strArr, output, step, n, r, target + 1);
        }


    }

/*
    // 조합
    public static void comb(int[] arr, int[] output, int step, int n, int r, int target) {
        if(r == 0) {
            int count = 0;
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < output.length; i++) {
                int index = output[i];
                for (int j = 0; j < useArr.get(index).length(); j++) {
                    char alpha = useArr.get(index).charAt(j);
                    // set에 있는지
                    if(set.contains(alpha)) {
                        // 있으면 이 경우의 수 쓰레기~
                        return;
                    }
                    // 없다면 count+1 and set 추가
                    count++;
                    set.add(alpha);
                }
            }

            // 최댓값 비교
            if(max < count) {
                max = count;
            }
        }
        else if(target == n) return;
        else {
            output[step] = arr[target];

            comb(arr, output, step+1, n, r-1, target+1);
            comb(arr, output, step, n, r, target+1);
        }
    }
*/

}

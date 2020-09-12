package Algorithm.kakaoblind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Kakao2 {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(solution(orders, course)));
    }

    static ArrayList<String> arrayList;
    static HashMap<String, Integer> hashMap;
    static int max = 0;

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();

        String[] orderArr, output;

        for(int i=0; i<course.length; i++) {
            int r = course[i];
            System.out.println("r : " + r);

            //HashMap초기화
            hashMap.clear();
            max =0;

            for(int j=0; j<orders.length; j++) {
                orderArr = orders[j].split("");
                output = new String[r];
                Arrays.sort(orderArr);

                System.out.println("배열 만들기 : " + Arrays.toString(orderArr));

                comb(orderArr, output, orderArr.length, r, 0,0);
            }

            //다 돌리고 arrayList에 넣는 작업

            if(max != 0) {
                for(Object o: hashMap.keySet()) {
                    if(hashMap.get(o).equals(max)) {
                        System.out.println("??ㄸ? " + o.toString());
                        arrayList.add(o.toString());
                    }
                }
            }

        }

        //마무리단계
        answer = new String[arrayList.size()];

        for(int i=0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void comb(String[] arr, String[] output, int n, int r, int index, int target) {

        if(r == 0)  {
            System.out.println(Arrays.toString(output));

            String temp= "";
            for(int i=0; i<output.length; i++) {
                temp += output[i];
            }

            System.out.println("값 : " + temp);

            if(hashMap.containsKey(temp)) {
                int getCnt = hashMap.get(temp) + 1;
                hashMap.put(temp, getCnt);

                max = Math.max(max, getCnt);
            }else {
                hashMap.put(temp, 0);
            }

            return;
        }
        else if(target == n) return;
        else{
            output[index] = arr[target];
            comb(arr, output,n,r-1, index+1, target+1);//뽑는 경우
            comb(arr, output, n, r, index, target+1);//안뽑는 경우
        }
    }



    public static void Permutation(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {

        if(r == depth){
            System.out.println(Arrays.toString(output));

            String temp= "";
            for(int i=0; i<output.length; i++) {
                temp += output[i];
            }

            System.out.println("값 : " + temp);

            if(hashMap.containsKey(temp)) {
                int getCnt = hashMap.get(temp) + 1;
                hashMap.put(temp, getCnt);

                max = Math.max(max, getCnt);
            }else {
                hashMap.put(temp, 0);
            }

            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                Permutation(arr, output, visited, depth+1, n, r);
                visited[i] = false;
                output[depth] = "";
            }
        }
    }
}

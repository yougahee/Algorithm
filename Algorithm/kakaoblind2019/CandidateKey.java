package Algorithm.kakaoblind2019;

import java.util.*;

public class CandidateKey {
    public static void main(String[] args) {

        String[][] stages = {{"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(stages));
    }

    static int column, row;
    static String[][] relationcopy;

    static public int solution(String[][] relation) {
        column = relation[0].length;
        row = relation.length;

        relationcopy = relation;

        int answer = column;
        int[] array;

        HashSet<String> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList();

        for(int i=0; i<column; i++) {
            hashSet.clear();
            for(int j=0; j<row; j++) {
                if(hashSet.contains(relation[j][i])) {
                    arrayList.add(i);
                    answer--;
                    break;
                }
                hashSet.add(relation[j][i]);
            }
        }

        array = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }


        //조합
        for(int i=2; i<= arrayList.size()-1; i++) {
            int[] output =  new int[i];
            Combi(array, output, array.length, i, 0, 0);
        }

        return answer;
    }

    //조합
    static void Combi(int[] arr, int[] output, int n, int r, int index, int target) {
        if(r == 0) isReal(output);
        else if(target == n) return;
        else{
            output[index] = arr[target];
            Combi(arr, output,n,r-1, index+1, target+1);
            Combi(arr, output, n, r, index, target+1);
        }
    }

    //확인 클래스
    static void isReal(int[] array) {
        HashMap<String, Integer> hash = new HashMap<>();
        HashSet<Integer> index = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        //첫번째 중복을 찾는다..!
        for(int i=0; i<row; i++) {
            if(hash.containsKey(relationcopy[i][array[0]])){
                queue.add(i);
                queue.add(hash.get(relationcopy[i][array[0]]));
                //index.add(i);
                //index.add(hash.get(relationcopy[i][array[0]]));
            }else {
                hash.put(relationcopy[i][array[0]], i);
            }
        }

        int start = queue.poll();
        index.add(start);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            if(index.contains(q)) {
                continue;
            }

            index.add(q);





        }
    }
}

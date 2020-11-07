package Algorithm.test_utc;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        String[] aa = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        System.out.println(Arrays.toString(solution(aa)));
    }

    public static String[] solution(String[] logs) {
        String[] answer = {};

        HashSet<String> set = new HashSet<>();
        HashMap<String, HashMap<Integer, Integer>> hashMap = new HashMap<>();
        HashMap<Integer, Integer> addScore = new HashMap<>();
        HashSet<String> ans = new HashSet<>();

        for(int i=0; i < logs.length; i++) {
            String[] log = logs[i].split(" ");
            set.add(log[0]);
        }

        for (String s : set) {
            addScore = new HashMap<>();

            for (int j = 0; j < logs.length; j++) {
                String[] log = logs[j].split(" ");
                if (s.equals(log[0]))
                    addScore.put(Integer.parseInt(log[1]), Integer.parseInt(log[2]));
            }

            if(addScore.size() >= 5)
                hashMap.put(s, addScore);
        }

        if(hashMap.isEmpty()){
            answer = new String[1];
            answer[0] = "None";
            return answer;
        }


        boolean isTrue = true;
        for( String key : hashMap.keySet() ){
            for( String key2 : hashMap.keySet() ){
                if(key.equals(key2)) continue;
                if(hashMap.get(key).size() == hashMap.get(key2).size()) {
                    //푼 번호가 모두 같은지
                    isTrue = true;
                    for( Integer num : hashMap.get(key).keySet()) {
                        if(!hashMap.get(key2).containsKey(num))
                            isTrue = false;
                        else {
                            if(hashMap.get(key2).get(num) != hashMap.get(key).get(num))
                                isTrue = false;
                        }

                        if(!isTrue)
                             break;
                    }

                    if(isTrue){
                        ans.add(key);
                        ans.add(key2);
                    }
                }
            }
        }

        answer = new String[ans.size()];

        int i=0;
        for( String anw : ans) {
            answer[i++] = anw;
        }

        Arrays.sort(answer);
        return answer;
    }

    static class Pair {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Pair(int a, int b) {
            hashMap.put(a, b);
        }
    }

    static class Score{
        int code;
        ArrayList<Integer> problemNum;
        ArrayList<Integer> score;

    }
}

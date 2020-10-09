package Algorithm.test_naverhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Num2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] id_list= {"A B C D", "A D", "A B D", "B D"};
        int k = 2;

        ArrayList<String> oneDaylist = new ArrayList<>();
        Hashtable<String, Integer> idset = new Hashtable<>();

        int answer =0;

        for(int i=0; i<id_list.length; i++) {
            oneDaylist.clear();
            String[] splitId = id_list[i].split(" ");

            for(int j=0; j<splitId.length; j++) {
                String a = splitId[j];

                //하루에 한번만 나오기
                if(!oneDaylist.contains(a)) {
                    oneDaylist.add(a);

                    if(idset.get(a) == null) {
                        idset.put(a, 1);
                        answer++;
                    }
                    else{
                        int value = idset.get(a)+1;
                        idset.put(a,value);

                        //최대 K번까지임
                        if(value <= k) {
                            answer++;
                        }
                    }

                }
            }
        }

        System.out.println(answer);
    }
}

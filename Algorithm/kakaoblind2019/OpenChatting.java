package Algorithm.kakaoblind2019;

import java.util.Arrays;
import java.util.HashMap;

public class OpenChatting {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Enter uid1111 Gahui"};

        System.out.println(Arrays.toString(solution(record)));
    }

    static public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hashMap = new HashMap<>();

        String[][] enter = new String[record.length][3];

        for (int i = 0; i < record.length; i++) {
            enter[i] = record[i].split(" ");

            if(!enter[i][0].equals("Leave"))
                hashMap.put(enter[i][1], enter[i][2]);
        }

        StringBuilder sb = new StringBuilder();
        for (String[] i : enter) {
            switch (i[0]) {
                case "Enter":
                    sb.append(hashMap.get(i[1]) + "님이 들어왔습니다.");
                    sb.append(",");
                    break;
                case "Leave":
                    sb.append(hashMap.get(i[1]) + "님이 나갔습니다.");
                    sb.append(",");
                    break;
            }
        }

        answer = sb.toString().split(",");
        return answer;
    }
}


package Algorithm.test_devMatching;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) {

        int[][] map = {};
        int[] arr = {};
        String[] orders = {"XYZ", "XWY", "WXA"};

        System.out.println(solution("PM 01:00:00", 1000));
    }

    public static String solution(String p, int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("a hh:mm:ss");
        LocalTime localTime = LocalTime.parse(p, formatter);
        localTime = localTime.plusSeconds(n);

        return localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}

package Algorithm.test_kakaoblind2021;

import java.util.Arrays;

public class Kakao5 {
    public static void main(String[] args) {
        String play_time = "99:59:59";
        String adv_time = "25:00:00";

        String[] logs = {
                "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
        };

        System.out.println(solution(play_time, adv_time, logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int secondAnswer = 0;
        int endPlayTime = changeStringtoSecond(play_time);
        int watchingTime =0;
        int max =0;

        int[] startTime = new int[logs.length];
        int[] endTime = new int[logs.length];

        Arrays.sort(logs);

        changeSecond(logs, startTime, endTime);

        for(int i=0; i<logs.length; i++) {
            //광고시작, 끝
            int startSection = startTime[i];
            int endSection = startSection + changeStringtoSecond(adv_time);
            watchingTime =0;

            //광고가 끝나는 시간이 재생시간을 넘지 않았는지 파악하기. --> 넘었으면 그 경우는 안된다.
            if(endSection > endPlayTime)
                continue;

            for(int j=0; j<logs.length; j++) {
                if(startTime[j] >= startSection && startTime[j] < endSection) {
                    if(endTime[j] > endSection)
                        watchingTime += endSection-startTime[j];
                    else
                        watchingTime += endTime[j] - startTime[j];
                }
                else if(endTime[j] >= startSection && endTime[j] < endSection) {
                    if(startTime[j] > startSection)
                        watchingTime += endTime[j] - startTime[j];
                    else
                        watchingTime += endTime[j] - startSection;
                }
                else if(startTime[j] <= startSection && endTime[j] >= endSection) {
                    watchingTime += endSection - startSection;
                }
            }

            if(watchingTime > max) {
                max = watchingTime;
                secondAnswer = startSection;
            }
        }

        return String.format("%02d", secondAnswer/3600) + ":" + String.format("%02d", secondAnswer%3600/60) + ":" + String.format("%02d", secondAnswer%60);
    }

    public static int changeStringtoSecond ( String str) {
        String[] time;

        time = str.split(":");

        return (Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 +
                Integer.parseInt(time[2]));

    }

    public static void changeSecond(String[] original, int[] startTime, int[] endTime)  {
        String[] temp, time;

        for(int i=0; i<original.length; i++) {
            temp = original[i].split("-");

            //startTime
            time = temp[0].split(":");
            int secondStartTime = (int) ((Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 +
                    Integer.parseInt(time[2])));

            time = temp[1].split(":");
            int secondsEndTime = (int) ((Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 +
                    Integer.parseInt(time[2])));

            startTime[i] = secondStartTime;
            endTime[i] = secondsEndTime;
        }
    }
}

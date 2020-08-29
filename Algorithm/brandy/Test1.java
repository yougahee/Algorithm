package Algorithm.brandy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int[] type = new int[6];

        int N = sc.nextInt();

        int heart = 220 - N;
        int heartbeat, heartSec;

        while (sc.hasNext()) {
            heartSec = sc.nextInt();

            heartbeat = (heartSec * 100 ) /heart;
            //System.out.println(heartbeat);

            if(heartbeat < 60)
                type[5]++;
            else if(heartbeat < 68)
                type[4]++;
            else if(heartbeat < 75)
                type[3]++;
            else if(heartbeat < 80)
                type[2]++;
            else if(heartbeat < 90)
                type[1]++;
            else
                type[0]++;
        }

        for(int i=0; i<6; i++) {
            System.out.print(type[i] + " ");
        }
    }
}

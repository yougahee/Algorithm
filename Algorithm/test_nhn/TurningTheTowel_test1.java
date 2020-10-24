package Algorithm.test_nhn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TurningTheTowel_test1 {

    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        ArrayList<Player>[] people = new ArrayList[numOfAllPlayers-1];
        int location = 0;
        char taggerName = 'A';
        int taggerCnt = 1;

        HashSet<Character> hashSet = new HashSet<>();
        for(int i=0; i<numOfQuickPlayers; i++) {
            hashSet.add(namesOfQuickPlayers[i]);
        }

        for(int i=0; i<numOfAllPlayers-1; i++) {
            people[i] = new ArrayList<>();
            people[i].add(new Player((char) ('A' + i + 1), 0));
        }

        for(int i=0; i<numOfGames; i++) {
            //수건을 놓고갈 위치
            int move = (location + numOfMovesPerGame[i] + numOfAllPlayers-1 ) % (numOfAllPlayers-1);

            if(hashSet.contains(people[move].get(0).name)){
                location = move;
                taggerCnt++;
            }else {
                location = move;
                people[move].add(new Player(taggerName, taggerCnt));
                taggerName = people[move].get(0).name;
                taggerCnt = people[move].get(0).cnt + 1;
                people[move].remove(0);
            }
        }

        //출력
        for(int i=0; i<numOfAllPlayers-1; i++) {
            System.out.println(people[i].get(0).name + " " + people[i].get(0).cnt);
        }
        System.out.println(taggerName + " " + taggerCnt);

    }

    public static class Player {
        char name;
        int cnt;

        public Player(char name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}
